package JunitTesting_With_Mockito.Chapter16ExceptionHandlingWithVoidMethods;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    void save(Book book) throws SQLException;

    Book findBookById(String bookId);

}
