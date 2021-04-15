package JunitTesting_With_Mockito.Chapter15ExceptionHandlingWithNonVoidMethods;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String s) {
        super(s);
    }
}
