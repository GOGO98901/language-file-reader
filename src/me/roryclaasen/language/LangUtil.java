package me.roryclaasen.language;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LangUtil {

	private static LangSettings settings = new LangSettings();
	private static Map<String, String> hardCodeStrings = new HashMap<String, String>();
	private static Map<String, String> fileStrings = new HashMap<String, String>();

	private static LanguageFile file;

	public static String get(String key) {
		if (settings.doHardCodeFirst()) {
			if (hardCodeStrings.containsKey(key)) return hardCodeStrings.get(key);
			if (fileStrings.containsKey(key)) return fileStrings.get(key);
		} else {
			if (fileStrings.containsKey(key)) return fileStrings.get(key);
			if (hardCodeStrings.containsKey(key)) return hardCodeStrings.get(key);
		}
		try {
			throw new NoLanguageKeyFoundException(key);
		} catch (NoLanguageKeyFoundException e) {
			if (settings.isDebug()) e.printStackTrace();
		}
		return null;
	}

	public static void setLanguageFile(LanguageFile file) {
		LangUtil.file = file;
	}

	public static void setLanguageFileAndRead(LanguageFile file) throws IOException {
		setLanguageFile(file);
		readLanguageFile();
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

	public static void readLanguageFile() throws IOException {
		if (file == null) throw new NullPointerException("No language file set");
		if (!settings.keepValuesAfterLoad()) clear();
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

	public static int getErrorCount() {
		if (file == null) {
			try {
				throw new NullPointerException("No language file set");
			} catch (Exception e) {
				if (settings.isDebug()) e.printStackTrace();
				return 1;
			}
		}
		return file.getErrorCount();
	}

	public static LangSettings settings() {
		return settings;
	}
}
