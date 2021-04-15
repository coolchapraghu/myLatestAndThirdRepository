package JunitTesting_With_Mockito.Chapter9StubbingMultipleCallstoSameMethod;

import JunitTesting_With_Mockito.Chapter9StubbingMultipleCallstoSameMethod.Book;
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
public class TestingMultipleCallstoSameMethod {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testingMultpleCallstoSameMethod(){

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();
        List<String> bookIds = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        bookIds.add("Physics");
        bookIds.add("Physics");


        //Book bookId;

        //Mockito.when(bookRepository.findBookbyBookId("Physics")).thenReturn(book1, book2, book2);

        // you can basically provide any number of arguments to the thenReturn method
        // it will simply start returning the objects in a sequence

        // the above line of code can also be written in the below way which is more readable

        Mockito.when(bookRepository.findBookbyBookId("Physics"))
                .thenReturn(book1)
                .thenReturn(book2);  // and so on.. u can continue to infinity


        Mockito.when(bookRepository.findBookbyBookId("Chemistry")).thenReturn(book2);

        int actualCost = bookService.calculateTotalCost(bookIds);

        Assertions.assertEquals(8000, actualCost, "Some where the calculation is wrong");

    }

}
