package JunitTesting_With_Mockito.Chapter19CreatingSpyUsingAnnotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TestingCreatingSpyUsingAnnotations {

    @InjectMocks
    private BookManager bookManager;

    //@Mock  -- does not actually call the method when the code is calling the method.
             // it simply returns the default values depending on type of return value
    @Spy     // it actually call the method and gets the code executed..

            // observe the behaviour of the below statement
            // int discountedPrice = bookService.getAppliedDiscount(book, discountRate)
            // applyDiscountOnBook method of the BookManager class
    private BookService bookService;

    @Test
    public void testMockitoSpyUsingAnnotations(){

        // we need to mock getBook of the BookService because it is communicating to database ( or not in our case it is just returning null)

        // we need to call getAppliedDiscount to use the logic written in it to calculate the discounted price

        Book book = new Book("Physics", "My Fav Subject", 6500, LocalDate.now());

        Mockito.doReturn(book).when(bookService).findBook("Physics");

        // with the Spy object the below given line works differently than with the Mock
        // It actually the calls the method and tries to execute it

        // with the Mock Object, as soon as it encounters bookService.findBook("Physics")
        // it immediately returns our book

        // To summarize, with the Spy objects, it better to use doReturn() than when- thenReturn combo

        //Mockito.when(bookService.findBook("Physics")).thenReturn(book);

        int actualPrice = bookManager.applyDiscountOnBook("Physics", 10);

        Assertions.assertEquals(5850, actualPrice, "Calculation went wrong");


    }
}
