package JunitTesting_With_Mockito.Chapter6CreatingMockwithAnnotations;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
