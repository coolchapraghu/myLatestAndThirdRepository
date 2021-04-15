package JunitTestingWithoutMockito.StubTests;

import JunitTestingWIthoutMockito.Model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import JunitTestingWIthoutMockito.stub.BookRepository;
import JunitTestingWIthoutMockito.stub.StubBookService;

import java.util.List;

@DisplayName("Mockito Stub Testing")
public class StubTestWithoutMockito {

    @Test
    @DisplayName("Testing with Stub")
    public void demoStub(){

        BookRepository bookRepository = new StubBookRepository();
        StubBookService bookService = new StubBookService(bookRepository);

        List<Book> discountBooks  = bookService.getNewBooksWithAppliedDiscount(10, 7);

        Assertions.assertEquals(2, discountBooks.size());
        Assertions.assertEquals(3600, discountBooks.get(0).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");
        Assertions.assertEquals(5850, discountBooks.get(1).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");

    }
}
