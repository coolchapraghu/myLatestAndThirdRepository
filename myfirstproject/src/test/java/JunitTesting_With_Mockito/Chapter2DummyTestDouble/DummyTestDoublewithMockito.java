package JunitTesting_With_Mockito.Chapter2DummyTestDouble;

import JunitTesting_With_Mockito.DummyTestDouble.Book;
import JunitTesting_With_Mockito.DummyTestDouble.BookRepository;
import JunitTesting_With_Mockito.DummyTestDouble.DummyBookService;
import JunitTesting_With_Mockito.DummyTestDouble.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DummyTestDoublewithMockito {

    @Test
    public void dummyTestWithMockito() {

        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        //Book book;

        DummyBookService bookService = new DummyBookService(bookRepository, emailService);

        Book book1 = new Book("1234", "Junit in Action", 250, LocalDate.now());
        Book book2 = new Book("2345", "Mockito in Action", 250, LocalDate.now());

        Collection<Book> bookCollection = new ArrayList<>();
        bookCollection.add(book1);
        bookCollection.add(book2); // .. these two lines obviously work..

        bookService.addBook(book1);
        bookService.addBook(book2);  /// these two lines are needed to mock test and see
                                     /// if bookRepository.save is called

        Mockito.when(bookRepository.findAll()).thenReturn(bookCollection);

        Mockito.verify(bookRepository).save(book1);

        Assertions.assertEquals(2, bookService.findNumberofBooks());

    }
}
