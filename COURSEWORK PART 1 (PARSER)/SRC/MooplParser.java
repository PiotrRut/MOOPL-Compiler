/* Generated By:JavaCC: Do not edit this line. MooplParser.java */
  import syntaxtree.*;
  import java.util.List;
  import java.util.ArrayList;
  import java.util.LinkedList;
  public class MooplParser implements MooplParserConstants {

  final public void testTokens() throws ParseException {
  Token t;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PROC:
      case FUN:
      case CLASS:
      case INT:
      case NEW:
      case SELF:
      case RETURN:
      case EXTENDS:
      case LOCAL:
      case BOOLEAN:
      case OUTPUT:
      case WHILE:
      case DO:
      case IF:
      case ELSE:
      case THEN:
      case TRUE:
      case FALSE:
      case LENGTH:
      case ISNULL:
      case LBRACKET:
      case RBRACKET:
      case LSQRBRACKET:
      case RSQRBRACKET:
      case LPAREN:
      case RPAREN:
      case PERIOD:
      case SEMICOLON:
      case COMMA:
      case INTEGER_LITERAL:
      case NOT:
      case LOG_AND:
      case LESS_THAN:
      case EQUAL_TO:
      case ASSIGN_OP:
      case DIV:
      case ADD:
      case SUBT:
      case MULT:
      case ID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PROC:
      case FUN:
      case CLASS:
      case INT:
      case NEW:
      case SELF:
      case RETURN:
      case EXTENDS:
      case LOCAL:
      case BOOLEAN:
      case OUTPUT:
      case WHILE:
      case DO:
      case IF:
      case ELSE:
      case THEN:
      case TRUE:
      case FALSE:
      case LENGTH:
      case ISNULL:
      case LBRACKET:
      case RBRACKET:
      case LSQRBRACKET:
      case RSQRBRACKET:
      case LPAREN:
      case RPAREN:
      case PERIOD:
      case SEMICOLON:
      case COMMA:
      case NOT:
      case LOG_AND:
      case LESS_THAN:
      case EQUAL_TO:
      case ASSIGN_OP:
      case DIV:
      case ADD:
      case SUBT:
      case MULT:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PROC:
          t = jj_consume_token(PROC);
          break;
        case FUN:
          t = jj_consume_token(FUN);
          break;
        case CLASS:
          t = jj_consume_token(CLASS);
          break;
        case INT:
          t = jj_consume_token(INT);
          break;
        case NEW:
          t = jj_consume_token(NEW);
          break;
        case SELF:
          t = jj_consume_token(SELF);
          break;
        case RETURN:
          t = jj_consume_token(RETURN);
          break;
        case EXTENDS:
          t = jj_consume_token(EXTENDS);
          break;
        case LOCAL:
          t = jj_consume_token(LOCAL);
          break;
        case BOOLEAN:
          t = jj_consume_token(BOOLEAN);
          break;
        case OUTPUT:
          t = jj_consume_token(OUTPUT);
          break;
        case WHILE:
          t = jj_consume_token(WHILE);
          break;
        case DO:
          t = jj_consume_token(DO);
          break;
        case IF:
          t = jj_consume_token(IF);
          break;
        case ELSE:
          t = jj_consume_token(ELSE);
          break;
        case THEN:
          t = jj_consume_token(THEN);
          break;
        case TRUE:
          t = jj_consume_token(TRUE);
          break;
        case FALSE:
          t = jj_consume_token(FALSE);
          break;
        case LENGTH:
          t = jj_consume_token(LENGTH);
          break;
        case ISNULL:
          t = jj_consume_token(ISNULL);
          break;
        case LBRACKET:
          t = jj_consume_token(LBRACKET);
          break;
        case RBRACKET:
          t = jj_consume_token(RBRACKET);
          break;
        case LSQRBRACKET:
          t = jj_consume_token(LSQRBRACKET);
          break;
        case RSQRBRACKET:
          t = jj_consume_token(RSQRBRACKET);
          break;
        case LPAREN:
          t = jj_consume_token(LPAREN);
          break;
        case RPAREN:
          t = jj_consume_token(RPAREN);
          break;
        case PERIOD:
          t = jj_consume_token(PERIOD);
          break;
        case SEMICOLON:
          t = jj_consume_token(SEMICOLON);
          break;
        case COMMA:
          t = jj_consume_token(COMMA);
          break;
        case NOT:
          t = jj_consume_token(NOT);
          break;
        case LOG_AND:
          t = jj_consume_token(LOG_AND);
          break;
        case LESS_THAN:
          t = jj_consume_token(LESS_THAN);
          break;
        case EQUAL_TO:
          t = jj_consume_token(EQUAL_TO);
          break;
        case ASSIGN_OP:
          t = jj_consume_token(ASSIGN_OP);
          break;
        case DIV:
          t = jj_consume_token(DIV);
          break;
        case ADD:
          t = jj_consume_token(ADD);
          break;
        case SUBT:
          t = jj_consume_token(SUBT);
          break;
        case MULT:
          t = jj_consume_token(MULT);
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        System.out.println("Recognised as valid token: " + t.image);
        break;
      case INTEGER_LITERAL:
        t = jj_consume_token(INTEGER_LITERAL);
        System.out.println("Recognised as INTEGER_LITERAL: " + t.image);
        break;
      case ID:
        t = jj_consume_token(ID);
        System.out.println("Recognised as ID: " + t.image);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  }

  final public void nt_Program() throws ParseException {
    label_2:
    while (true) {
      nt_ProcDecl();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PROC:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      nt_ClassDecl();
    }
    jj_consume_token(0);
  }

  final public void nt_ClassDecl() throws ParseException {
    if (jj_2_1(3)) {
      jj_consume_token(CLASS);
      jj_consume_token(ID);
      jj_consume_token(LBRACKET);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        nt_FieldDecl();
      }
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PROC:
        case FUN:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        nt_MethodDecl();
      }
      jj_consume_token(RBRACKET);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLASS:
        jj_consume_token(CLASS);
        jj_consume_token(ID);
        jj_consume_token(EXTENDS);
        jj_consume_token(ID);
        jj_consume_token(LBRACKET);
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ID:
            ;
            break;
          default:
            jj_la1[7] = jj_gen;
            break label_6;
          }
          nt_FieldDecl();
        }
        label_7:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PROC:
          case FUN:
            ;
            break;
          default:
            jj_la1[8] = jj_gen;
            break label_7;
          }
          nt_MethodDecl();
        }
        jj_consume_token(RBRACKET);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void nt_FieldDecl() throws ParseException {
    jj_consume_token(ID);
  }

  final public void nt_MethodDecl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PROC:
      nt_ProcDecl();
      break;
    case FUN:
      nt_FunDecl();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void nt_FunDecl() throws ParseException {
    jj_consume_token(FUN);
  }

  final public void nt_ProcDecl() throws ParseException {
    jj_consume_token(PROC);
  }

  final public void nt_PrimaryExp() throws ParseException {
    jj_consume_token(INTEGER_LITERAL);
  }

  final public void nt_Op() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LOG_AND:
      jj_consume_token(LOG_AND);
      break;
    case EQUAL_TO:
      jj_consume_token(EQUAL_TO);
      break;
    case LESS_THAN:
      jj_consume_token(LESS_THAN);
      break;
    case DIV:
      jj_consume_token(DIV);
      break;
    case ADD:
      jj_consume_token(ADD);
      break;
    case SUBT:
      jj_consume_token(SUBT);
      break;
    case MULT:
      jj_consume_token(MULT);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void nt_Exp() throws ParseException {
    jj_consume_token(NEW);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1() {
    if (jj_scan_token(CLASS)) return true;
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public MooplParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xffffff00,0xffffff00,0xffffff00,0x100,0x400,0x0,0x300,0x0,0x300,0x400,0x300,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0xffff,0x7fdf,0xffff,0x0,0x0,0x8000,0x0,0x8000,0x0,0x0,0x0,0x7b80,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MooplParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MooplParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MooplParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MooplParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MooplParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MooplParser(MooplParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MooplParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[48];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

  }
