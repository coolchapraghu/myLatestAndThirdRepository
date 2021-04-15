package JunitTesting_With_Mockito.Chapter7StubbingMethodWithWhenandThenReturn;

import JunitTesting_With_Mockito.Chapter7StubbingMethodwithWhenandThenReturn.Book;
import JunitTesting_With_Mockito.Chapter7StubbingMethodwithWhenandThenReturn.BookRepository;
import JunitTesting_With_Mockito.Chapter7StubbingMethodwithWhenandThenReturn.BookService;
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
public class TestingStubbingWithWhenandThenReturn {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService service;

    @Test
    public void testStubbingMethodWithWhenandThenReturn(){

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();
        List<String> bookIds = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        bookIds.add("Physics");
        bookIds.add("Chemistry");

        //Book bookId;

        Mockito.when(bookRepository.findBookbyBookId("Physics")).thenReturn(book1);
        Mockito.when(bookRepository.findBookbyBookId("Chemistry")).thenReturn(book2);

        int actualCost = service.calculateTotalCost(bookIds);

        Assertions.assertEquals(10500, actualCost, "Some where the calculation is wrong");

    }
}
