package JunitTesting_With_Mockito.Chapter14VerifyAtLeastNumberofTimes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class VerifyAtLeastNumberofTimes {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void verifyAlteastNumberofTimes(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 5600, LocalDate.now());

        Book book = new Book(null, "My Fav Subject", 5600, LocalDate.now());

        bookService.addBook(bookRequest);
        //bookService.addBook(bookRequest);
        //Mockito.verify(bookRepository,Mockito.times(2)).save(book); .. this is for exact 2 times

        Mockito.verify(bookRepository, Mockito.atLeast(2)).save(book);
        Mockito.verify(bookRepository, Mockito.atMost(2)).save(book);
        Mockito.verify(bookRepository, Mockito.atLeastOnce()).save(book);
        Mockito.verify(bookRepository, Mockito.atMostOnce()).save(book);

                                                       // this is for atLeast 2 times
    }
}
