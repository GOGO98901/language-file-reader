package net.roryclaasen.language;

public class NoLanguageKeyFoundException extends Exception {
	private static final long serialVersionUID = 1099183988116117302L;
	
	private static String message = "Key Not Found In Language File ";

	public NoLanguageKeyFoundException() {
		this("");
	}

	public NoLanguageKeyFoundException(String key) {
		super(message + (key != null ? (key.length() == 0 ? "'" + key + "'" : "") : ""));
	}

	public NoLanguageKeyFoundException(Throwable cause) {
		super(message, cause);
	}

	public NoLanguageKeyFoundException(String key, Throwable cause) {
		super(message + (key != null ? (key.length() == 0 ? "'" + key + "'" : "") : ""), cause);
	}
}
