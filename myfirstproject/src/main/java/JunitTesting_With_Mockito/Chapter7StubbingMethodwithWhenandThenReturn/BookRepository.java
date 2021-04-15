package JunitTesting_With_Mockito.Chapter7StubbingMethodwithWhenandThenReturn;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookbyBookId(String bookId);
}
