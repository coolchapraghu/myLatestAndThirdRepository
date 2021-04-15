package JunitTesting_With_Mockito.Chapter10StubbingVoidMethods;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookbyBookId(String bookId);

    void save(Book book);

}
