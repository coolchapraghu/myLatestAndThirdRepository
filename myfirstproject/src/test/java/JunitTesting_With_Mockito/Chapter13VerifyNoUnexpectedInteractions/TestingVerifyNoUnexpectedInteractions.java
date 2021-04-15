package JunitTesting_With_Mockito.Chapter13VerifyNoUnexpectedInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TestingVerifyNoUnexpectedInteractions {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void verifyNoUnexpectedInteractions(){

        Book book = new Book("Physics", "My Fav Subject", 5500, LocalDate.now());

        Mockito.when(bookRepository.findBookById("Physics")).thenReturn(book);
        bookService.updatePrice("Physics", 5500);

        Mockito.verify(bookRepository).findBookById("Physics");
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void verifyOrderofTransactions(){

        Book book = new Book("Physics", "My Fav Subject", 5500, LocalDate.now());

        Mockito.when(bookRepository.findBookById("Physics")).thenReturn(book);
        bookService.updatePrice("Physics", 5500);

        InOrder inOrder = Mockito.inOrder(bookRepository);

        /*inOrder.verify(bookRepository).findBookById("Physics");
        inOrder.verify(bookRepository).save(book); */

        inOrder.verify(bookRepository).save(book); // instead of calling Mockito.verify()
                                                     // we will call inOrder.verify()
        inOrder.verify(bookRepository).findBookById("Physics");

    }
}
