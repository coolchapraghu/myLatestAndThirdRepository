package JunitTesting_With_Mockito.Chapter16ExceptionHandlingWithVoidMethods;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String s) {
        super(s);
    }
}
