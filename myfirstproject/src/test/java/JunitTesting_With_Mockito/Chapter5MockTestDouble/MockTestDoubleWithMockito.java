package JunitTesting_With_Mockito.Chapter5MockTestDouble;

import JunitTesting_With_Mockito.MockTestDouble.MockBookRepository;
import JunitTesting_With_Mockito.MockTestDouble.MockBookService;
import JunitTesting_With_Mockito.MockTestDouble.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockTestDoubleWithMockito {

    @Test
    public void mockTestWithMockito() {

        MockBookRepository bookRepository = Mockito.mock(MockBookRepository.class);
        MockBookService bookService = new MockBookService(bookRepository);

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepository).save(book1);
       // Mockito.verify(bookRepository).save(book2);

        // the above line fails the test due to 6500 being 5000

        // lets try something different
        Mockito.verify(bookRepository, Mockito.times(1)).save(book1);
        Mockito.verify(bookRepository, Mockito.times(0)).save(book2);
    }

}
