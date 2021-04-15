package JunitTestingWithoutMockito.FakeTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Repository.BookRepository;
import JunitTestingWIthoutMockito.Service.FakeBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FakeTest1WithoutMockito {

    @Test
    public void testFake(){
        BookRepository bookRepository = new FakeBookRepository();
        FakeBookService bookService = new FakeBookService(bookRepository);

        bookService.addBook(new Book("1234", "Junit in Action", 250, LocalDate.now() ));
        bookService.addBook(new Book("2345", "Mockito in Action", 250, LocalDate.now() ));

        Assertions.assertEquals(2, bookService.findNumberofBooks());
        //Assertions.a
    }
}
