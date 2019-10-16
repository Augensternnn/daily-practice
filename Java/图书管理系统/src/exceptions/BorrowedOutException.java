package exceptions;

public class BorrowedOutException extends Exception {
    public BorrowedOutException() {
    }

    public BorrowedOutException(String message) {
        super(message);
    }

    public BorrowedOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public BorrowedOutException(Throwable cause) {
        super(cause);
    }

    public BorrowedOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
