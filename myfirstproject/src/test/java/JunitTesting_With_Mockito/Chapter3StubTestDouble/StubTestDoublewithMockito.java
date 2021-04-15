package JunitTesting_With_Mockito.Chapter3StubTestDouble;

import JunitTesting_With_Mockito.StubTestDouble.Book;
import JunitTesting_With_Mockito.StubTestDouble.BookRepository;
import JunitTesting_With_Mockito.StubTestDouble.StubBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubTestDoublewithMockito {

    @Test
    public void dummyTestWithMockito() {

        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        StubBookService bookService = new StubBookService(bookRepository);

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        int days = 7;

        // Mockito.when(bookRepository.findNewBooks(7)).thenReturn(bookList);
        // The above line also works .. below line is more dynamic
        Mockito.when(bookRepository.findNewBooks(days)).thenReturn(bookList);

        List<Book> discountBooks = bookService.getNewBooksWithAppliedDiscount(10, days);

        Assertions.assertEquals(2, discountBooks.size());
        Assertions.assertEquals(3600, discountBooks.get(0).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");
        Assertions.assertEquals(5850, discountBooks.get(1).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");

    }
}
