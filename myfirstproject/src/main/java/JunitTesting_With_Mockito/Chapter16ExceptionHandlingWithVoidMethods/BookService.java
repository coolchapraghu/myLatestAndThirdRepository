package JunitTesting_With_Mockito.Chapter16ExceptionHandlingWithVoidMethods;

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

    public void addBook(Book book) throws DatabaseWriteException {

        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            throw new DatabaseWriteException("Unable to write" +
                    " to database");
        }

    }

}
