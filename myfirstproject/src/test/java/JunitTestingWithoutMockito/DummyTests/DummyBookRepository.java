package JunitTestingWithoutMockito.DummyTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Repository.BookRepository;

import java.util.Collection;

public class DummyBookRepository implements BookRepository {


    @Override
    public void save(Book book) {

    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }
}
