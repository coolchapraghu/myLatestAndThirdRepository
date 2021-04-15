package JunitTesting_With_Mockito.StubTestDouble;

import java.util.List;

public class StubBookService {

    private BookRepository bookRepository;

    public StubBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int dayz){

        List<Book> newBooks = bookRepository.findNewBooks(dayz);

        System.out.println(newBooks.size());

        for(Book book: newBooks){

            int price = book.getPrice();
            int newPrice = price - (discountRate * price) / 100;
            book.setPrice(newPrice);
        }

        return newBooks;

    }
}
