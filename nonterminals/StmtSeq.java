package nonterminals;

import tokenizer.Tokenizer;

public class StmtSeq {
    private Stmt stmt;
    private StmtSeq stmtSeq;
    
    public void parseStmtSeq(Tokenizer tokens){
        // Parse <stmt>
        stmt = new Stmt();
        stmt.parseStmt(tokens);
        
        // If the next token is a <stmt> then parse <stmt seq>
        if (tokens.getToken() != 32 || tokens.getToken() != 5 || 
                tokens.getToken() != 8 || tokens.getToken() != 10 || 
                tokens.getToken() != 11) {
            stmtSeq = new StmtSeq();
            stmtSeq.parseStmtSeq(tokens);
        }
    }
    
    public void printStmtSeq(){
        // Print <stmt>
        stmt.printStmt();
        
        // Print <stmt seq>
        if (stmtSeq != null){
            stmtSeq.printStmtSeq();
        }
    }
    
    public void execStmtSeq(){
        
    }
}