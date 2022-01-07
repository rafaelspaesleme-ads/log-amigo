package br.com.logamigo.logamigo.exceptions;

public class FileException extends RuntimeException {
    public FileException() {
    }

    public FileException(String s) {
        super(s);
    }

    public FileException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FileException(Throwable throwable) {
        super(throwable);
    }

    public FileException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
