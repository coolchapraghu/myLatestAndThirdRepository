package JunitTesting_With_Mockito.Chapter15ExceptionHandlingWithNonVoidMethods;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);

    List<Book> findAllBooks() throws SQLException;
}
