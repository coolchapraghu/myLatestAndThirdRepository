package JunitTesting_With_Mockito.Chapter15ExceptionHandlingWithNonVoidMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlingwithNonVoidMethods{

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void exceptionHandlingwithNonVoidMethods() throws SQLException {

        Mockito.when(bookRepository.findAllBooks()).thenThrow(SQLException.class);

        // The below line is the one that is being executed.. the below line is straight JUNit 5 code
        //  its can exist even without Mockito framework

        Assertions.assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
        //int totalPriceOfBooks = bookService.getTotalPriceOfBooks();

    }
}
