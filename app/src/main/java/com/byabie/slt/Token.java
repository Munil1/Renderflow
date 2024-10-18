package com.byabie.slt;

public class Token {
	public int line;
	public Object literal;
	public TokenType type;
	public Token(int line, TokenType type) {
		this.type = type;
		this.line = line;
	}
	public Token(int line, TokenType type, Object literal) {
		this.type = type;
		this.line = line;
		this.literal = literal;
	}
	public enum TokenType {
		PLUS, MINUS, AT, EQUALS, HASH, DOLLAR, NOT, BIT_AND, SLASH, BACKSLASH, COLON, SEMICOLON, QUESTION, ASTERISK, CODEBAR, QUOTE, QUOTES, PERCENT, CARET, COMMA, DOT,
		////
		CURVE_OPEN, CURVE_CLOSE,
		SQUARE_OPEN, SQUARE_CLOSE,
		ANGLE_OPEN, ANGLE_CLOSE,
		CURLY_OPEN, CURLY_CLOSE,
		////
		PLUS_EQUAL, MINUS_EQUAL, DOUBLE_EQUAL, INCREMENT, DECREMENT, INEQUAL, OR, AND, GREATER_EQUAL, LESS_EQUAL,
		////
		IF, ELSE, WHILE, CLASS, SCRIPT, PUBLIC, STATIC, VOID, IMPORT, IMPLEMENT, RETURN, BREAK, CONTINUE, NULL, TRUE, FALSE, FOR,
		OBJECT, INT, BOOLEAN, KSTRING, CHAR, 
		////
		INTEGER, STRING, IDENTIFIER,
		////
		EOF;
	}
}