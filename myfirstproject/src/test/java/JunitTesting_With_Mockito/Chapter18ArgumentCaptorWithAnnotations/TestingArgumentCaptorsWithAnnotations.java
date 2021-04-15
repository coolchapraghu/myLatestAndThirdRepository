package JunitTesting_With_Mockito.Chapter18ArgumentCaptorWithAnnotations;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TestingArgumentCaptorsWithAnnotations {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    public void testArgCaptorsWithoutAnnotations(){

        BookRequest bookRequest = new BookRequest("My Fav Subject", 4000, LocalDate.now());

        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository).save(bookArgumentCaptor.capture());
        // the above line will capture the Book class argument passed to
        // bookRepository.save(book);

        Book book = bookArgumentCaptor.getValue();
        Assertions.assertEquals(bookRequest.getTitle(), book.getTitle(), "Title mismatch");
    }

}
