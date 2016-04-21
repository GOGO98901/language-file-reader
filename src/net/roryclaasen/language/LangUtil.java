package net.roryclaasen.language;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LangUtil {

	private static Map<String, String> hardCodeStrings = new HashMap<String, String>();
	private static Map<String, String> fileStrings = new HashMap<String, String>();

	private static LanguageFile file;

	protected static boolean debug = false;

	public static String get(String key) {
		if (hardCodeStrings.containsKey(key)) return hardCodeStrings.get(key);
		if (fileStrings.containsKey(key)) return fileStrings.get(key);
		try {
			throw new NoLanguageKeyFoundException(key);
		} catch (NoLanguageKeyFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setLanguageFile(LanguageFile file) throws IOException {
		LangUtil.file = file;
		read();
	}

	public static void addHardcodeString(String key, String phrase) throws KeyAlreadyExistsException {
		if (hardCodeStrings.containsKey(key)) {
			throw new KeyAlreadyExistsException(key);
		}
		hardCodeStrings.put(key, phrase);
	}

	public static void removeHardcodeString(String key) {
		if (hardCodeStrings.containsKey(key)) hardCodeStrings.remove(key);
	}

	private static void read() throws IOException {
		if (file == null) throw new NullPointerException("No language file set");
		clear();
		fileStrings.putAll(file.read());
	}

	public static void clear() {
		clear(false);
	}

	public static void clear(boolean everything) {
		if (everything) clearHardCodedStrings();
		fileStrings.clear();
	}

	public static void clearHardCodedStrings() {
		hardCodeStrings.clear();
	}

	public static void setDebug(boolean debug) {
		LangUtil.debug = debug;
	}

	public static boolean getDebug() {
		return debug;
	}
}
