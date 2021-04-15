package JunitTestingWithoutMockito.SpyTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Spy.SpyBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTestWithoutMockito {

    @Test
    public void demoSpy(){

        SpyBookRepository spyBookRepository = new SpyBookRepository();
        SpyBookService bookService = new SpyBookService(spyBookRepository);

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now());
        Book book2 = new Book( "Chemistry", "The ultimate science", 6500, LocalDate.now()) ;

        bookService.addBook(book1);
        bookService.addBook(book2);

        Assertions.assertEquals(2, spyBookRepository.timesCalled());
        Assertions.assertTrue(spyBookRepository.calledWith(book2), () -> "This is not the last book called");




    }

}
