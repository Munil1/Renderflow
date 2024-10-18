package com.byabie.slt;
/*
import java.util.*;
import static com.byabie.slt.Token.TokenType.*;

public class Lexer {
	//Variables
	private int line = 1;
	private String source;
	private ArrayList<Token> tokens;
	private int start = 0;
	private int current = 0;
	private static final Map<String, TokenType> keywords;
	//Define 'keywords'
	static {
		keywords = new HashMap<>();
		keywords.put("if", IF);
		keywords.put("else", ELSE);
		keywords.put("while", WHILE);
		keywords.put("class", CLASS);
		keywords.put("script", SCRIPT);
		keywords.put("public", PUBLIC);
		keywords.put("static", STATIC);
		keywords.put("void", VOID);
		keywords.put("import", IMPORT);
		keywords.put("implement", IMPLEMENT);
		keywords.put("return", RETURN);
		keywords.put("break", BREAK);
		keywords.put("continue", CONTINUE);
		keywords.put("null", NULL);
		keywords.put("true", TRUE);
		keywords.put("false", FALSE);
		keywords.put("for", FOR);
		keywords.put("Object", OBJECT);
		keywords.put("obj", OBJECT);
		keywords.put("int", INT);
		keywords.put("Integer", INT);
		keywords.put("boolean", BOOLEAN);
		keywords.put("String", STRING);
		keywords.put("char", CHAR);
		keywords.put("Char", CHAR);
	}
	//Util methods
	private boolean isAtEnd() {
		return current >= source.length();
	}
	private char advance() {
		return source.charAt(current++);
	}
	private void addToken(TokenType type) {
		tokens.add(new Token(line, type));
	}
	private void addLiteral(TokenType type, Object literal) {
		tokens.add(new Token(line, type, literal));
	}
	private boolean match(char expected) {
		if (isAtEnd()) return false;
		if (source.charAt(current) != expected) return false;
		
		current++;
		return true;
	}
	private char peek() {
		if (isAtEnd()) return '\0';
		return source.charAt(current);
	}
	private void string() {
		while (peek() != '"' && !isAtEnd()) {
			if (peek() == '\n') line++;
			advance();
		}

		if (isAtEnd()) {
			throw new IllegalStateException("Unterminated string, line " + line);
			return;
		}

		advance();

		String value = source.substring(start + 1, current - 1);
		addLiteral(STRING, value);
	}
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	private void number() {
		while (isDigit(peek())) advance();
		if (peek() == '.' && isDigit(peekNext())) {
		// Consume the "."
		advance();

		while (isDigit(peek())) advance();
		}

		addToken(INTEGER,
			Double.parseDouble(source.substring(start, current)));
	}
	private char peekNext() {
		if (current + 1 >= source.length()) return '\0';
		return source.charAt(current + 1);
	} 
	private void identifier() {
		while (isAlphaNumeric(peek()) || peek() == '@') advance();

		String text = source.substring(start, current);
		TokenType type = keywords.get(text);
		if (type == null) {
			type = IDENTIFIER;
			addLiteral(type, text);
			return;
		}
		addToken(type);
	}
	private boolean isAlpha(char c) {
		return (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z') ||
            c == '_' ||
			c == '$';
	}
	private boolean isAlphaNumeric(char c) {
		return isAlpha(c) || isDigit(c);
	}
	//scanTokens method
	private void scanToken() {
		char c = advance();
		switch(c) {
			case '=': addToken(match("=") ? DOUBLE_EQUALS : EQUAL);
			//And so on
			case '/':
				if (match('/')) {
					// A comment goes until the end of the line.
					while (peek() != '\n' && !isAtEnd()) advance();
				} else {
					addToken(SLASH);
				}
				break;
			case ' ':
			case '\r':
			case '\t':
				// Ignore whitespace.
				break;
			case '\n':
				line++;
				break;
				case '"': string(); break;
			default: 
				if(isDigit(c)) {
					number(); break;
				} else if(isAlpha(c)) {
					identifier(); break;
				} else {
					throw new IllegalStateException("Invalid token " + c + " in line " + line);
				}
		} //}
	}
	//Main method
	public ArrayList<Token> splitLexemes(String source) {
		this.source = source;
		this.tokens = new ArrayList<Token>();
		while(!isAtEnd()) {
			start = current;
			scanToken();
		}
		return this.tokens;
	}
} */