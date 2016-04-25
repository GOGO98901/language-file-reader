package net.roryclaasen.language;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LanguageFile {

	private String filePath;

	private boolean compiled = true;

	private int stringCount;
	private int errorCount;

	public LanguageFile(String filePath) {
		this.filePath = filePath;
	}

	public LanguageFile notCompiled() {
		this.compiled = false;
		return this;
	}

	public Map<String, String> read() throws IOException {
		Map<String, String> strings = new HashMap<String, String>();
		InputStream stream;
		if (compiled) stream = LanguageFile.class.getClassLoader().getResourceAsStream(filePath);
		else stream = new FileInputStream(filePath);

		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		if (reader != null) {
			String line;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] split = validate(line);
				if (split != null) {
					strings.put(split[0], split[1]);
					stringCount++;
				} else {
					try {
						throw new LanguageFormatNotExcepted("(" + lineNumber + ") " + line);
					} catch (LanguageFormatNotExcepted e) {
						if (LangUtil.debug) e.printStackTrace();
						errorCount++;
					}
				}
			}
			reader.close();
		}
		return strings;
	}

	private String[] validate(String line) {
		if (line == null) return null;

		String[] split = line.split("=");
		if (split == null) return null;
		if (split.length != 2) return null;
		return split;
	}

	public boolean isComplied() {
		return compiled;
	}

	public int getCount() {
		return stringCount;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public String getPath() {
		return filePath;
	}
}
