package JunitTesting_With_Mockito.Chapter19CreatingSpyUsingAnnotations;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate){

        Book book = bookService.findBook(bookId); // we need to mock
        System.out.println("In applyDiscountOnBook method");
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate); // we need to actually call this in our test
        return discountedPrice;

        // when there are some methods that need to be actually called and when there are some methods that need to be mocked
        // then that is the situation we use spy
    }


}
