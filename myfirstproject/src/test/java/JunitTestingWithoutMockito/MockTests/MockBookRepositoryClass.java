package JunitTestingWithoutMockito.MockTests;

import JunitTestingWIthoutMockito.Mock.MockBookRepository;
import JunitTestingWIthoutMockito.Model.Book;
import org.junit.jupiter.api.Assertions;

public class MockBookRepositoryClass implements MockBookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {

        saveCalled++;
        lastAddedBook = book;

    }

    public void verify(Book book, int times){

        Assertions.assertEquals(times, saveCalled);
        Assertions.assertEquals(book, lastAddedBook, () -> book.toString() + " is not your last book" );

    }
}
