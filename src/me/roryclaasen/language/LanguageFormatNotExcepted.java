package me.roryclaasen.language;

public class LanguageFormatNotExcepted extends Exception {
	private static final long serialVersionUID = 5011056946824545565L;

	private static String message = "Language Format Not Excepted ";

	public LanguageFormatNotExcepted() {
		this("");
	}

	public LanguageFormatNotExcepted(String line) {
		super(message + (line != null ? (line.length() != 0 ? "'" + line + "'" : "") : ""));
	}

	public LanguageFormatNotExcepted(Throwable cause) {
		super(message, cause);
	}

	public LanguageFormatNotExcepted(String line, Throwable cause) {
		super(message + (line != null ? (line.length() == 0 ? "'" + line + "'" : "") : ""), cause);
	}
}
