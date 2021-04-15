package JunitTesting_With_Mockito.Chapter18ArgumentCaptorWithAnnotations;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);

    Book findBookbyBookId(String bookId);

    List<Book> findNewBooks(int dayz);
}
