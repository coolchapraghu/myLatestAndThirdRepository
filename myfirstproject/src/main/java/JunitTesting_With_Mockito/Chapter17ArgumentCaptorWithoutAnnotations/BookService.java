package JunitTesting_With_Mockito.Chapter17ArgumentCaptorWithoutAnnotations;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
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
        JunitTesting_With_Mockito.Chapter10StubbingVoidMethods.Book book;

        Book book1;

        for(String bookId: bookIds){

            book1 = bookRepository.findBookbyBookId(bookId);
            total_amt = total_amt + book1.getPrice();
        }
        return total_amt;
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest){

        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setTitle(bookRequest.getTitle());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }
}
