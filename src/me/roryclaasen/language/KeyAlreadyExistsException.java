package me.roryclaasen.language;

public class KeyAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String message = "Key was not found in language file ";

	public KeyAlreadyExistsException() {
		this("");
	}

	public KeyAlreadyExistsException(String key) {
		super(message + (key != null ? (key.length() == 0 ? "'" + key + "'" : "") : ""));
	}

	public KeyAlreadyExistsException(Throwable cause) {
		super(message, cause);
	}

	public KeyAlreadyExistsException(String key, Throwable cause) {
		super(message + (key != null ? (key.length() == 0 ? "'" + key + "'" : "") : ""), cause);
	}
}
