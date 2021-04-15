package JunitTestingWithoutMockito.DummyTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Repository.BookRepository;
import JunitTestingWIthoutMockito.Service.DummyBookService;
import JunitTestingWIthoutMockito.Service.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DummyTest1WithoutMockito {

    @Test
    public void testDummy(){
        BookRepository bookRepository = new DummyBookRepository();


        // here, we are testing BookService and bookRepository functionality
        // But, the constructor is demanding the Email JunitTestingWIthoutMockito.Service interface object as one of its parameters
        // In this case, we just create a Dummy object for the Email JunitTestingWIthoutMockito.Service and just pass it to
        // the constructor.
        // There is nothing concrete in that implementation

        EmailService emailService = new DummyEmailService();

        DummyBookService bookService = new DummyBookService(bookRepository, emailService);

        bookService.addBook(new Book("1234", "Junit in Action", 250, LocalDate.now() ));
        bookService.addBook(new Book("2345", "Mockito in Action", 250, LocalDate.now() ));

       Assertions.assertEquals(2, bookService.findNumberofBooks());
        //Assertions.a
    }
}
