package JunitTesting_With_Mockito.Chapter20StubbingMethodUsingBDDMockito;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    void save(Book book);

    Book findBookById(String bookId);
}
