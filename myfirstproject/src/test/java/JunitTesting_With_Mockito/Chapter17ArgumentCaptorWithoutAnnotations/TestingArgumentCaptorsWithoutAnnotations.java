package JunitTesting_With_Mockito.Chapter17ArgumentCaptorWithoutAnnotations;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TestingArgumentCaptorsWithoutAnnotations {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testArgCaptorsWithoutAnnotations(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 4000, LocalDate.now());

        /*Book book = new Book(null, "My Fav Subject", 4000, LocalDate.now());

        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository, Mockito.times(2)).save(book); */

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository).save(bookArgumentCaptor.capture());
        // the above line will capture the Book class argument passed to
        // bookRepository.save(book);

        Book book = bookArgumentCaptor.getValue();
        Assertions.assertEquals(bookRequest.getTitle(), book.getTitle(), "Title mismatch");
    }

}
