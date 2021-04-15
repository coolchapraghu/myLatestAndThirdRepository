package JunitTesting_With_Mockito.Chapter19CreatingSpyUsingAnnotations;

import JunitTesting_With_Mockito.Chapter18ArgumentCaptorWithAnnotations.BookRepository;
import JunitTesting_With_Mockito.Chapter18ArgumentCaptorWithAnnotations.BookRequest;

import java.util.List;

public class BookService {


    public Book findBook(String bookId) {

        return null;
    }

    public int getAppliedDiscount(Book book, int discountRate) {

        System.out.println("In getAppliedDiscount");

        int price = book.getPrice();
        return price - price * discountRate / 100;
    }
}
