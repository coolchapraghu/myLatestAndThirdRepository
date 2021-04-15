package JunitTesting_With_Mockito.DummyTestDouble;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();

}
