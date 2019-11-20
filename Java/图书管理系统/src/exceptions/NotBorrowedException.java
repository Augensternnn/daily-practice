package exceptions;

public class NotBorrowedException extends Exception {
    public NotBorrowedException() {
    }

    public NotBorrowedException(String message) {
        super(message);
    }

    public NotBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotBorrowedException(Throwable cause) {
        super(cause);
    }

    public NotBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
