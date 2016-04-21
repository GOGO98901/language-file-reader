# Language file reader
This is a java project that allows the user to read language files to retrieve strings use in their program

## Usage
The examples given are using the [example lang file](#example-lang-file)
To load the language file use
```java
LanguageFile enUK = new LanguageFile("en_UK.lang");
LangUtil.setLanguageFile(enUK);
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
test.2=Testing 1 2 3
```
