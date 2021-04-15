package JunitTesting_With_Mockito.Chapter16ExceptionHandlingWithVoidMethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlingwithVoidMethods {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void exceptionHandlingwithVoidMethods() throws SQLException{

        Book book = new Book("Physics", "My Fav Subject", 5600, LocalDate.now());

        Mockito.doThrow(SQLException.class).when(bookRepository).save(book);


        Assertions.assertThrows(DatabaseWriteException.class,()-> bookService.addBook(book));

    }

}
