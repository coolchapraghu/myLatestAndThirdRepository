package JunitTestingWIthoutMockito.Repository;

import JunitTestingWIthoutMockito.Model.Book;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();

}
