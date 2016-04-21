package net.roryclaasen.test;

import java.io.IOException;

import net.roryclaasen.language.LangUtil;
import net.roryclaasen.language.LanguageFile;

public class Bootstrap {
	public static void main(String[] args) {
		LanguageFile file = new LanguageFile("src/net/roryclaasen/test/en_UK.lang").notCompiled();
		try {
			LangUtil.setLanguageFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep();
		System.out.println(LangUtil.get("test.1"));
		System.out.println(LangUtil.get("test.2"));
		System.out.println(LangUtil.get("test.3"));
		/*
		 * Expected output
		 * 
		 * Hello World
		 * null
		 * Testing... 1 2 3
		 */

		LanguageFile resource = new LanguageFile("net/roryclaasen/test/en_UK2.lang");
		try {
			LangUtil.setLanguageFile(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sleep();
		System.out.println(LangUtil.get("test2.1"));
		System.out.println(LangUtil.get("test2.2"));
		System.out.println(LangUtil.get("test2.3"));/*
		 * Expected output
		 * 
		 * Hello World!
		 * This Will Pass
		 * Testing... 1 2 3 ohh who cares
		 */
	}

	private static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// Only used so that the print stream doesn't merge with the stacktrace.
		}
	}
}
