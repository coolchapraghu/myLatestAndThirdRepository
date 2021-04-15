package JunitTesting_With_Mockito.FakeTestDouble;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();

}
