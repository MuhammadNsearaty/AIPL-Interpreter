/* Generated By:JavaCC: Do not edit this line. Parser.java */
package com.parser;
import java.io.IOException;
import java.io.FileInputStream;
import nodes.*;

public class Parser implements ParserConstants {

  public static void main(String args []) throws ParseException, IOException{

    FileInputStream stream = new FileInputStream("newText.txt");
        Parser parser = new Parser(stream);
        AbstractTreeNode node = start();

        //for(String s : Context.functionMap.keySet())
                //Context.functionMap.get(s).print("");

        //node.print("");
        node.execute(new Context());
  }

  static final public BlockNode start() throws ParseException {
  BlockNode bnode = new BlockNode();
  AbstractTreeNode n;
        FunctionNode fnode;
  ExpressionNode enode;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        fnode = Func();
                          Context.functionMap.put(fnode.getFunctionId(), fnode);
        break;
      case FLOOP:
      case WLOOP:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        n = Statement();
                             bnode.addChild(n);
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOOP:
      case WLOOP:
      case FUNCTION:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
          {if (true) return bnode;}
    throw new Error("Missing return statement in function");
  }

  static final public FunctionNode Func() throws ParseException {
        FunctionNode fnode = new FunctionNode();
        Token t;
        ExpressionNode enode;
        AbstractTreeNode n;
    jj_consume_token(FUNCTION);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      t = jj_consume_token(VAR);
                                    fnode.getParIds().add(t.image);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 35:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_2;
        }
        jj_consume_token(35);
        t = jj_consume_token(VAR);
                                                                                      fnode.getParIds().add(t.image);
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(RP);
    jj_consume_token(WRITE);
    t = jj_consume_token(VAR);
                                                                                                                                                         fnode.setFunctionId(t.image);
    jj_consume_token(COLON);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOOP:
      case WLOOP:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      n = Statement();
      fnode.addChild(n);
    }
    jj_consume_token(END);
    {if (true) return fnode;}
    throw new Error("Missing return statement in function");
  }

  static final public FunctionCallNode CAllFUNCTION() throws ParseException {
  FunctionCallNode enode = new FunctionCallNode();
  AbstractTreeNode n,s;
  Token t;
    t = jj_consume_token(VAR);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
    case LP:
    case DOUBLE:
    case VAR:
      n = E();
                 enode.addChild(n);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 35:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(35);
        n = E();
                                                 enode.addChild(n);
      }
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(RP);
    enode.setOperationName(t.image);
    {if (true) return enode;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode E() throws ParseException {
  ExpressionNode enode = new ExpressionNode();
  ExpressionNode node1;
  ExpressionNode node2 = null;
  Token t = new Token();
    node1 = F();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      t = jj_consume_token(PLUS);
      node2 = E();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
          enode.setOperationName(t.image);
          enode.addChild(node1);
          if(node2!= null) {
                enode.addChild(node2);
                {if (true) return enode;}
                }
          else
                {if (true) return node1;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode F() throws ParseException {
  ExpressionNode fnode= new ExpressionNode();
  ExpressionNode node1;
  ExpressionNode node2 = null;
  Token t = new Token();
    node1 = Exp();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLY:
      t = jj_consume_token(MULTIPLY);
      node2 = F();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
          fnode.setOperationName(t.image);
          fnode.addChild(node1);
          if(node2 != null) {
                fnode.addChild(node2);
                {if (true) return fnode;}
         }
         else
                {if (true) return node1;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode Exp() throws ParseException {
  ExpressionNode expnode= new ExpressionNode();
  ExpressionNode node1;
  ExpressionNode node2 = null;
  Token t = new Token();
    node1 = N();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case POWER:
      t = jj_consume_token(POWER);
      node2 = Exp();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    expnode.setOperationName(t.image);
    expnode.addChild(node1);
    if(node2 != null) {
        expnode.addChild(node2);
                {if (true) return expnode;}
   }
        else
                {if (true) return node1;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode N() throws ParseException {
  ExpressionNode enode= new ExpressionNode();
  ExpressionNode node1 = null;
  ConstantNode conNode = null;
  VariableNode varNode = null;
  Token t= new Token();
    if (jj_2_1(2)) {
      node1 = CAllFUNCTION();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOUBLE:
        t = jj_consume_token(DOUBLE);
                       conNode = new ConstantNode();
                                   conNode.setValue(t.image);
        break;
      case VAR:
        t = jj_consume_token(VAR);
                    varNode = new VariableNode();
                                varNode.setVarId(t.image);
        break;
      case NUM:
        t = jj_consume_token(NUM);
                   conNode = new ConstantNode();
                                        conNode.setValue(t.image);
        break;
      case LP:
        jj_consume_token(LP);
        node1 = E();
        jj_consume_token(RP);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          if(node1 != null) {
                {if (true) return node1;}
         }
          else
                if(varNode != null)
                        {if (true) return varNode;}
                else
                        {if (true) return conNode;}
    throw new Error("Missing return statement in function");
  }

  static final public ForNode For() throws ParseException {
        Token t= new Token();
        ForNode fnode = new ForNode();
        ExpressionNode enode1, enode2, enode3;
        enode3 = new ConstantNode(1);
        BlockNode bnode = new BlockNode();
        AbstractTreeNode n;
    jj_consume_token(FLOOP);
    t = jj_consume_token(VAR);
    jj_consume_token(COLON);
    enode1 = E();
    jj_consume_token(WRITE);
    enode2 = E();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLON:
      jj_consume_token(COLON);
      enode3 = E();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    label_5:
    while (true) {
      n = Statement();
                  bnode.addChild(n);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOOP:
      case WLOOP:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(END);
          fnode.setVarName(t.image);
          fnode.addChild(enode1);
          fnode.addChild(enode2);
          fnode.addChild(enode3);
          fnode.addChild(bnode);
          {if (true) return fnode;}
    throw new Error("Missing return statement in function");
  }

  static final public ConditionNode Condition() throws ParseException {
  Token t = new Token();
  ConditionNode cnode = new ConditionNode();
  ExpressionNode enode1;
  ExpressionNode enode2;
    enode1 = E();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      t = jj_consume_token(EQ);
      break;
    case LT:
      t = jj_consume_token(LT);
      break;
    case GT:
      t = jj_consume_token(GT);
      break;
    case LET:
      t = jj_consume_token(LET);
      break;
    case GET:
      t = jj_consume_token(GET);
      break;
    case NEQ:
      t = jj_consume_token(NEQ);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    enode2 = E();
          cnode.setOperationName(t.image);
          cnode.addChild(enode1);
          cnode.addChild(enode2);
          {if (true) return cnode;}
    throw new Error("Missing return statement in function");
  }

  static final public WhileNode While() throws ParseException {
  WhileNode wnode = new WhileNode();
  BlockNode bnode = new BlockNode();
  AbstractTreeNode n,s;
    jj_consume_token(WLOOP);
    jj_consume_token(LP);
    n = Condition();
    jj_consume_token(RP);
    label_6:
    while (true) {
      //statement must return ATN
                s = Statement();
                            bnode.addChild(s);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOOP:
      case WLOOP:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(END);
          wnode.addChild(n);
          wnode.addChild(bnode);
          {if (true) return wnode;}
    throw new Error("Missing return statement in function");
  }

  static final public IfNode IF() throws ParseException {
             Token t = new Token();
        IfNode ifNode = new IfNode();
        ElseNode enode = new ElseNode();
        ConditionNode cnode;
        BlockNode bnode1 = new BlockNode();
        BlockNode bnode2 = null;
        AbstractTreeNode n;
    t = jj_consume_token(IF);
    jj_consume_token(LP);
    cnode = Condition();
    jj_consume_token(RP);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOOP:
      case WLOOP:
      case Return:
      case VAR:
      case IF:
      case READ:
      case WRITE:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_7;
      }
      n = Statement();
                bnode1.addChild(n);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      bnode2 = new BlockNode();
      label_8:
      while (true) {
        n = Statement();
                bnode2.addChild(n);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FLOOP:
        case WLOOP:
        case Return:
        case VAR:
        case IF:
        case READ:
        case WRITE:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_8;
        }
      }
          enode.addChild(bnode2);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(END);
    ifNode.addChild(cnode);
    ifNode.addChild(bnode1);
    if(bnode2 != null)
        ifNode.addChild(enode);
    {if (true) return ifNode;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignmentNode Assignment() throws ParseException {
  Token t, t1;
  AssignmentNode anode = new AssignmentNode();
  AbstractTreeNode n ;
    t = jj_consume_token(VAR);
    t1 = jj_consume_token(assignment);
    n = E();
           anode.setvarId(t.image);
           anode.setOperation(t1.image);
           anode.addChild(n);
           {if (true) return anode;}
    throw new Error("Missing return statement in function");
  }

  static final public ReadNode Read() throws ParseException {
                 ReadNode n = new ReadNode();
Token t;
    jj_consume_token(READ);
    t = jj_consume_token(VAR);
   n.setVarName(t.image);

  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public WriteNode Write() throws ParseException {
        WriteNode wnode = new WriteNode();
        ExpressionNode enode;
    jj_consume_token(WRITE);
    enode = E();
  wnode.addChild(enode);
  {if (true) return wnode;}
    throw new Error("Missing return statement in function");
  }

  static final public ReturnNode Return() throws ParseException {
        ExpressionNode enode;
    jj_consume_token(Return);
    enode = E();
          ReturnNode rnode = new ReturnNode();
          rnode.addChild(enode);
          {if (true) return rnode;}
    throw new Error("Missing return statement in function");
  }

  static final public AbstractTreeNode Statement() throws ParseException {
        AbstractTreeNode n = null;
    if (jj_2_2(2)) {
      n = CAllFUNCTION();
      jj_consume_token(SIMICOLON);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        n = Assignment();
        jj_consume_token(SIMICOLON);
        break;
      case IF:
        n = IF();
        break;
      case WLOOP:
        n = While();
        break;
      case READ:
        n = Read();
        jj_consume_token(SIMICOLON);
        break;
      case WRITE:
        n = Write();
        jj_consume_token(SIMICOLON);
        break;
      case FLOOP:
        n = For();
        break;
      default:
        jj_la1[18] = jj_gen;
        if (jj_2_3(2)) {
          n = Return();
          jj_consume_token(SIMICOLON);
        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
            {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(LP)) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(Return)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_scan_token(VAR)) return true;
    if (jj_scan_token(LP)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(NUM)) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(VAR)) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_9()) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(DOUBLE)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_9()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xb1980000,0xb1980000,0x0,0x10000000,0xb1180000,0x0,0x14220000,0x20,0x40,0x100,0x14220000,0x0,0xb1180000,0x7e00,0xb1180000,0xb1180000,0xb1180000,0x40000000,0xb0180000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1,0x1,0x8,0x0,0x1,0x8,0x0,0x0,0x0,0x0,0x0,0x2,0x1,0x0,0x1,0x1,0x1,0x0,0x1,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[3];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
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
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
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
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
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
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
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
    for (int i = 0; i < 36; i++) {
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
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
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