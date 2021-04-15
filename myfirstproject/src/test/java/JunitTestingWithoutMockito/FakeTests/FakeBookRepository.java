package JunitTestingWithoutMockito.FakeTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Repository.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    Map<String, Book> bookMap = new HashMap<>();

    @Override
    public void save(Book book) {
         bookMap.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookMap.values();
    }


}
