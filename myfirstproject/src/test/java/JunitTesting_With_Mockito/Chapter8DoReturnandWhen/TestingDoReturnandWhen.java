package JunitTesting_With_Mockito.Chapter8DoReturnandWhen;

import JunitTesting_With_Mockito.Chapter8DoReturnandWhen.Book;
import org.junit.jupiter.api.Assertions;
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
public class TestingDoReturnandWhen {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testDoReturnandWhen(){

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();
        List<String> bookIds = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        bookIds.add("Physics");
        bookIds.add("Chemistry");

        Mockito.doReturn(book1).when(bookRepository).findBookbyBookId("Physics");
        Mockito.doReturn(book2).when(bookRepository).findBookbyBookId("Chemistry");

        int actualCost = bookService.calculateTotalCost(bookIds);

        Assertions.assertEquals(10500, actualCost, "Some where the calculation is wrong");

    }
}
