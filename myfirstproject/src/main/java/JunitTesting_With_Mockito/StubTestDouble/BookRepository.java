package JunitTesting_With_Mockito.StubTestDouble;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
