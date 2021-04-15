package JunitTesting_With_Mockito.Chapter1FakeTestDouble;

import JunitTesting_With_Mockito.FakeTestDouble.Book;
import JunitTesting_With_Mockito.FakeTestDouble.BookRepository;
import JunitTesting_With_Mockito.FakeTestDouble.FakeBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;

//  trying my first commit to GIt hub afte changes
// this is the first real kind of project I am commiting to Git
// my third comment line

public class FakeTestDoublewithMockito {

    @Test
    public void fakeTestWithMockito() {

        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        FakeBookService bookService = new FakeBookService(bookRepository);

        Book book1 = new Book("1234", "Junit in Action", 250, LocalDate.now());
        Book book2 = new Book("2345", "Mockito in Action", 250, LocalDate.now());

        Collection<Book>  books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        Assertions.assertEquals(2, bookService.findNumberofBooks(), "You did not correct number of books");

    }
}
