package com.byabie.rdf.lib.xtml;

public class Lexer {
     public class Token {
          public int line;
          public Object literal;
          public TokenType type;
          public Token(TokenType type, Object literal, int line) {
               this.type = type;
               this.line = line;
               this.literal = literal;
          }
     }
     public enum TokenType {
          OPEN_CURLY, CLOSE_CURLY, COLON, STRING, NULL, TRUE, FALSE, INTEGER
     }
}