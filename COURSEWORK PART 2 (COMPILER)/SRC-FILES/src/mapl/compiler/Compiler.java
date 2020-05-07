package mapl.compiler;

import mapl.ast.*;
import mapl.ast.util.VisitorAdapter;
import ir.ast.*;
import static mapl.compiler.FreshNameGenerator.makeName;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    
    private final StmCompiler stmCompiler;
    private final ExpCompiler expCompiler;

    public Compiler() {
        stmCompiler = new StmCompiler();
        expCompiler = new ExpCompiler();
    }
    
    /**************************************************************************/
    /*                                                                        */
    /* The following factory methods methods are not strictly necessary but   */
    /* they greatly simplify the code that you have to write. For example,    */
    /* instead of:                                                            */
    /*                                                                        */
    /*    new IRStmMoveTemp("x",                                              */
    /*                      new IRExpBinOp(new IRExpTemp("y"),                */
    /*                                     IROp.EQ,                           */
    /*                                     new IRExpConst(7)                  */
    /*                                    )                                   */
    /*                     )                                                  */
    /*                                                                        */
    /* you can write:                                                         */
    /*                                                                        */
    /*    MOVE(TEMP("x"), BINOP(TEMP("y"), IROp.EQ, CONST(7)))                */
    /*                                                                        */
    /**************************************************************************/
    
    /****************************************************/
    /* Convenience factory methods for building IRStms. */
    /****************************************************/
    
    private static IRStm MOVE(IRExp el, IRExp er) {
        if (el instanceof IRExpTemp) {
            return new IRStmMoveTemp(((IRExpTemp)el).name, er);
        } else if (el instanceof IRExpMem) {
            return new IRStmMoveMem(((IRExpMem)el).e, er);
        } else {
            throw new Error("Left-expression of MOVE must be either a TEMP or a MEM, not: " + el);
        }
    }
    
    private static IRStmNoop NOOP = new IRStmNoop();
    
    private static IRStmJump JUMP(IRExp e) {
        return new IRStmJump(e);
    }
    
    private static IRStmCJump CJUMP(IRExp e1, IROp op, IRExp e2, String trueLabel, String falseLabel) {
        return new IRStmCJump(e1 , op, e2, trueLabel, falseLabel);
    }
    
    private static IRStmExp EXP(IRExp e) {
        return new IRStmExp(e);
    }
    
    private static IRStmLabel LABEL(String name) {
        return new IRStmLabel(name);
    }
    
    private static IRStm SEQ(IRStm... stms) {
        int n = stms.length;
        if (n == 0) return NOOP;
        IRStm stm = stms[n-1];
        for (int i = n-2; i >= 0; --i) {
            stm = new IRStmSeq(stms[i], stm);
        }
        return stm;
    }
    
    private static IRStm SEQ(List<IRStm> stms) {
        return SEQ(stms.toArray(new IRStm[0]));
    }
    
    private static IRStmPrologue PROLOGUE(int params, int locals) {
        return new IRStmPrologue(params, locals);
    }
    
    private static IRStmEpilogue EPILOGUE(int params, int locals) {
        return new IRStmEpilogue(params, locals);
    }
    
    /****************************************************/
    /* Convenience factory methods for building IRExps. */
    /****************************************************/
    
    private static IRExpBinOp BINOP(IRExp e1, IROp op, IRExp e2) {
        return new IRExpBinOp(e1, op, e2);
    }
    
    private static IRExpCall CALL(IRExp f, IRExp... args) {
        return new IRExpCall(f, args);
    }
    
    private static IRExpCall CALL(IRExp f, List<IRExp> args) {
        return new IRExpCall(f, args);
    }
    
    private static IRExpConst CONST(int n) {
        return new IRExpConst(n);
    }
    
    private static IRExpMem MEM(IRExp e) {
        return new IRExpMem(e);
    }
    
    private static IRExpTemp TEMP(String name) {
        return new IRExpTemp(name);
    }
    
    private static IRExpName NAME(String labelName) {
        return new IRExpName(labelName);
    }

    private static IRExpESeq ESEQ(IRStm s, IRExp e) {
        return new IRExpESeq(s, e);
    }

    public IRProgram compile(Program n) {
        List<IRStm> stms = new ArrayList<>();
        for (Stm stm: n.pd.ss) {
            stms.addAll(stm.accept(stmCompiler));
        }
        // this jump to _END is redundant in the prototype
        stms.add(JUMP(NAME("_END")));
        return new IRProgram(stms);
    }
    
    // TODO: add visit methods for all the Stm classes
    // TODO: add visit methods for method declarations
    // Note: no need to define visit methods for any other AST types
    private class StmCompiler extends VisitorAdapter<List<IRStm>> {

        
        @Override
        public List<IRStm> visit(StmOutchar s) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(EXP(CALL(NAME("_printchar"), s.e.accept(expCompiler))));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmOutput n) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(EXP(CALL(NAME("_printint"), n.e.accept(expCompiler))));
            return stms;
        }
        
        @Override
        public List<IRStm> visit(StmVarDecl n) {
            return new ArrayList<>();
        }

        @Override
        public List<IRStm> visit(StmBlock n) {
            List<IRStm> stms = new ArrayList<>();
            for(Stm stm : n.ss) stms.addAll(stm.accept(stmCompiler));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmAssign s){
            List<IRStm> stms = new ArrayList<>();
            stms.add(MOVE(TEMP(s.v.id), s.e.accept(expCompiler)));
            return stms;
        }

        @Override
        public List<IRStm> visit(FunDecl n) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(LABEL(n.id));
            stms.add(PROLOGUE(n.fs.size(), n.stackAllocation));
            n.ss.forEach(stmt -> stms.addAll(stmt.accept(stmCompiler)));
            stms.add(MOVE(TEMP("RV"), n.e.accept(expCompiler)));
            stms.add(EPILOGUE(n.fs.size(), n.stackAllocation));
            return stms;
        }

        @Override
        public List<IRStm> visit(ProcDecl n) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(LABEL(n.id));
            stms.add(PROLOGUE(n.fs.size(), n.stackAllocation));
            n.ss.forEach(stmt -> stms.addAll(stmt.accept(stmCompiler)));
            stms.add(EPILOGUE(n.fs.size(), n.stackAllocation));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmArrayAssign n) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(SEQ(MOVE(MEM(BINOP(n.e1.accept(expCompiler),IROp.ADD, n.e2.accept(expCompiler))), n.e3.accept(expCompiler))));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmWhile s){
            List<IRStm> stms = new ArrayList<>();
            IRExp exp = s.e.accept(expCompiler);
            String startLbl = makeName();
            String insideLoop = makeName();
            String endLbl = makeName();
            stms.add(LABEL(startLbl));
            stms.add(CJUMP(exp, IROp.EQ, CONST(1), insideLoop, endLbl));
            stms.add(LABEL(insideLoop));
            stms.addAll(s.body.accept(stmCompiler));
            stms.add(JUMP(NAME(startLbl)));
            stms.add(LABEL(endLbl));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmIf s){
            List<IRStm> stms = new ArrayList<>();
            String trueLbl = makeName();
            String falseLbl = makeName();
            String end = makeName();
            stms.add(CJUMP(s.e.accept(expCompiler), IROp.EQ, CONST(1), trueLbl, falseLbl));
            stms.add(LABEL(trueLbl));
            stms.addAll(s.st.accept(stmCompiler));
            stms.add(JUMP(NAME(end)));
            stms.add(LABEL(falseLbl));
            stms.addAll(s.sf.accept(stmCompiler));
            stms.add(LABEL(end));
            return stms;
        }

        @Override
        public List<IRStm> visit(StmCall n) {
            List<IRStm> stms = new ArrayList<>();
            stms.add(LABEL(n.id));
            for (Exp exp : n.es) {
                stms.add(EXP(exp.accept(expCompiler)));
            }
            return stms;
        }
    }
    
    // TODO: add visit methods for all the Exp classes
    // Note: no need to define visit methods for any other AST types
    private class ExpCompiler extends VisitorAdapter<IRExp> {
        
        @Override
        public IRExp visit(ExpInteger e) {
            return CONST(e.i);
        }

        @Override
        public IRExp visit(ExpTrue e) {
            return CONST(1);
        }

        @Override
        public IRExp visit(ExpFalse e) {
            return CONST(0);
        }

        @Override
        public IRExp visit(ExpVar e) {
            return BINOP(TEMP("FP"), IROp.ADD, CONST(e.v.offset));
        }

        @Override
        public IRExp visit(ExpNot e) {
            return BINOP(CONST(1), IROp.SUB, e.e.accept(expCompiler));
        }

        @Override
        public IRExp visit(ExpOp e) {
            IRExp e1 = e.e1.accept(expCompiler);
            IRExp e2 = e.e2.accept(expCompiler);

            if (e.op == ExpOp.Op.AND) {
                return ESEQ(SEQ(CJUMP(e1, IROp.EQ, CONST(1), makeName(), makeName()),
                        SEQ(SEQ(LABEL(makeName()), SEQ(MOVE(TEMP(makeName()), BINOP(e2, IROp.EQ, CONST(1))), JUMP(NAME(makeName())))),
                                SEQ(LABEL(makeName()), MOVE(TEMP(makeName()), CONST(0)), LABEL(makeName())))), TEMP(makeName()));
            } else {
                return BINOP(e1, convertToIROp(e.op), e2);
            }
        }

        @Override
        public IRExp visit(ExpCall e){
            List<IRExp> args = new ArrayList<>();
            e.es.forEach(exp -> args.add(exp.accept(expCompiler)));
            return CALL(NAME(e.id), args);
        }

        @Override
        public IRExp visit(ExpArrayLength e) {
            return MEM(BINOP(e.e.accept(expCompiler), IROp.ADD, CONST(1)));
        }

        @Override
        public IRExp visit(ExpArrayLookup e) {
            return MEM(BINOP(e.e1.accept(expCompiler), IROp.ADD, e.e2.accept(expCompiler)));
        }

        @Override
        public IRExp visit(ExpNewArray e) {
            return ESEQ(SEQ(MOVE(TEMP(makeName()), CALL(NAME("_malloc"), e.e.accept(this)))), TEMP(makeName()));
        }

        @Override
        public IRExp visit(ExpIsnull e) {
            return BINOP(CONST(0), IROp.EQ, e.e.accept(expCompiler));
        }

        private IROp convertToIROp(ExpOp.Op op) {
            if( op == ExpOp.Op.PLUS ) return IROp.ADD;
            else if( op == ExpOp.Op.MINUS ) return IROp.SUB;
            else if( op == ExpOp.Op.DIV ) return  IROp.DIV;
            else if (op == ExpOp.Op.EQUALS ) return IROp.EQ;
            else if( op == ExpOp.Op.LESSTHAN ) return IROp.LT;
            else if( op == ExpOp.Op.TIMES ) return IROp.MUL;
            return null;
        }
        
    }
}