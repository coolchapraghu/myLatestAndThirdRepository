package JunitTesting_With_Mockito.Chapter11VerifySimpleInvocationofMethods;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TestingVerifySimpleInvocationofMethods {

    @InjectMocks
    private BookService bookService;

    @Spy // for behaviour verification, @Spy and @Mock pretty much works each same way
         // they exhibit almost same functionality
    //@Mock
    private BookRepository bookRepository;

    @Test
    public void addBook(){

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );

        bookService.addBook(book1);
        Mockito.verify(bookRepository).save(book1);

    }

    @Test
    public void testSaveBookVerify(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 5500, LocalDate.now());

        Book book = new Book(null, "My Fav Subject", 5600, LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.times(1)).save(book);


    }

    @Test
    public void testVerifyInteractionNotOccurred(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 5500, LocalDate.now());

        Book book = new Book(null, "My Fav Subject", 5500, LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.never()).save(book);


    }
}
