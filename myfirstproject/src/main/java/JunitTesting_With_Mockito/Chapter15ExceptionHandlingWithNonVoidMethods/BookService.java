package JunitTesting_With_Mockito.Chapter15ExceptionHandlingWithNonVoidMethods;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() throws DatabaseReadException {

        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            throw new DatabaseReadException("Unable to read" +
                    " from database");
        }
        int totalPrice = 0;
        for(Book book: books)
            totalPrice = totalPrice + book.getPrice();
        return totalPrice;
    }

}
