package JunitTesting_With_Mockito.Chapter9StubbingMultipleCallstoSameMethod;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookbyBookId(String bookId);
}
