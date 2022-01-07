package br.com.logamigo.logamigo.exceptions;

public class StringException extends RuntimeException {
    public StringException() {
    }

    public StringException(String s) {
        super(s);
    }

    public StringException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StringException(Throwable throwable) {
        super(throwable);
    }

    public StringException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
