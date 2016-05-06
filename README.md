# Language file reader
This is a java project that allows the user to read language files to retrieve strings use in their program
## Instalation
This project is licensed under the [MIT license](https://github.com/GOGO98901/language-file-reader/blob/master/LICENSE)

1. [Click here](https://github.com/GOGO98901/language-file-reader/releases/latest) to find the latest release.<br>
   Download the jar or the src files and add them to youre project
   - You could also [download](https://github.com/GOGO98901/language-file-reader/archive/master.zip) the whole project at this current version
2. Using [git shell](https://git-scm.com/docs/git-shell) or a such like program cd to project directory and
   run the command `git submodule add https://github.com/GOGO98901/language-file-reader.git languageUtils`.<br>
   Then add the src folder to your project

## Usage
The examples given are using the [example lang file](#example-lang-file). View the example java file [here](/src/net/roryclaasen/language/test/Bootstrap.java).<br>
To load the language file use
```java
LanguageFile enUK = new LanguageFile("en_UK.lang");
LangUtil.setLanguageFile(enUK);
LangUtil.readLanguageFile();
```
or
```java
LanguageFile enUK = new LanguageFile("en_UK.lang");
LangUtil.setLanguageFileAndRead(enUK);
```
and then to print your strings use
```java
String title = LangUtil.get("net.roryclaasen.title");
System.out.println(title);
```
You can also hard code phrases using
```java
LangUtil.addHardcodeString(key, phrase);
```
#### Example lang file
en_UK.lang
```
net.roryclaasen.title=Language File Reader
test.1.example=Testing 1 2 3
```
