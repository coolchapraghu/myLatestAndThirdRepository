package JunitTesting_With_Mockito.Chapter10StubbingVoidMethods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestingStubbingVoidMethods {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testingStubbingVoidMethods(){

        Book book1 = new Book(null, " My Fav Subject", 4000, LocalDate.now() );
 //       Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        Mockito.doNothing().when(bookRepository).save(book1);

        bookService.addBook(book1);
    }

    // in the above method, there is a problem which will be Demonstrated below

    // I have created one more method in BookService class : public void addBook(BookRequest bookRequest)
    // just to demonstrate the problem

    // Also, I have created one more class BookRequest specifically for this purpose

    // Demo of PotentialStubbingException

    @Test
    public void testSaveBookWithBookRequest(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 4000, LocalDate.now());

        Book book = new Book(null, "My Fav Subject", 4000, LocalDate.now());
        // As can be seen here, here we are creating a new book.

        // But in the addBook(bookRequest) another method is getting created

        // when Mockito does equalsTo comparison on them, it will turn to be false..
        // even though they are having same values

        // one solution is to, override equalsTo method

        Mockito.doNothing().when(bookRepository).save(book);

        bookService.addBook(bookRequest);
    }
}
