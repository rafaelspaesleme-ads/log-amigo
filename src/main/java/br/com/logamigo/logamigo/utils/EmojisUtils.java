package br.com.logamigo.logamigo.utils;

public class EmojisUtils {

    private EmojisUtils() {

    }

    protected static String ofOk() {
        return String.valueOf(Character.toChars(0x2705));
    }
    protected static String ofWarn() {
        return String.valueOf(Character.toChars(0x26A0));
    }
    protected static String ofErr() {
        return String.valueOf(Character.toChars(0x1F6AB));
    }
    protected static String ofIn() {
        return String.valueOf(Character.toChars(0x2139));
    }
}
