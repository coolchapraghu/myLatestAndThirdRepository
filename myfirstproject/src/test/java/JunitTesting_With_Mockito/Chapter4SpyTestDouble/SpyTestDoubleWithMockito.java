package JunitTesting_With_Mockito.Chapter4SpyTestDouble;

import JunitTesting_With_Mockito.SpyTestDouble.Book;
import JunitTesting_With_Mockito.SpyTestDouble.SpyBookRepository;
import JunitTesting_With_Mockito.SpyTestDouble.SpyBookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpyTestDoubleWithMockito {

    @Test
    public void spyTestWithMockito() {

        SpyBookRepository bookRepositorySpy = Mockito.spy(SpyBookRepository.class);
        SpyBookService bookService = new SpyBookService(bookRepositorySpy);

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepositorySpy).save(book1);
        // Mockito.verify(bookRepository).save(book2);

        // the above line fails the test due to 6500 being 5000

        // lets try something different
        Mockito.verify(bookRepositorySpy, Mockito.times(1)).save(book1);
        Mockito.verify(bookRepositorySpy, Mockito.times(0)).save(book2);





    }
}
