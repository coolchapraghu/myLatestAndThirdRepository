package JunitTesting_With_Mockito.Chapter9StubbingMultipleCallstoSameMethod;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
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

    public int calculateTotalCost(List<String> bookIds){

        int total_amt = 0;
        Book book;

        for(String bookId: bookIds){

            book = bookRepository.findBookbyBookId(bookId);
            total_amt = total_amt + book.getPrice();
        }
        return total_amt;
    }
}
