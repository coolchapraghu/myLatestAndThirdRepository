package JunitTestingWIthoutMockito.stub;

import JunitTestingWIthoutMockito.Model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
