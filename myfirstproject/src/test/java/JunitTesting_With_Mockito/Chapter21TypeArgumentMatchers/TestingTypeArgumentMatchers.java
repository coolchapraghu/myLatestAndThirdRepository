package JunitTesting_With_Mockito.Chapter21TypeArgumentMatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestingTypeArgumentMatchers {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    @Test
    public void testVerifyNoMoreInteractions(){

        Book book1 = new Book("Physics", "My Fav Subject", 5500, LocalDate.now());

        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        //Mockito.when(bookRepository.findBookById("Physics")).thenReturn(book1);
        //Mockito.when(bookRepository.findBookById("Chemistry")).thenReturn(book2);
        Mockito.when(bookRepository.findBookById(any())).thenReturn(book1);
        //bookService.updatePrice("Physics", 5500);


        bookService.updatePrice("Raghu Rama Reddy", 6700);
        Mockito.verify(bookRepository).save(book1);

        bookService.updatePrice("Chemistry", 6700);
        Mockito.verify(bookRepository).save(book2);

    }
}
