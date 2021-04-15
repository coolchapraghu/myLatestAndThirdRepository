package JunitTestingWithoutMockito.MockTests;

import JunitTestingWIthoutMockito.Mock.MockBookService;
import JunitTestingWIthoutMockito.Model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTestWithoutMockito {

    @Test
    public void demoMock(){

        MockBookRepositoryClass mockBookRepository = new MockBookRepositoryClass();
        MockBookService bookService = new MockBookService(mockBookRepository);

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now());
        Book book2 = new Book( "Chemistry", "The ultimate science", 6500, LocalDate.now()) ;

        bookService.addBook(book1);
        bookService.addBook(book2);

        mockBookRepository.verify(book2, 1 );
        mockBookRepository.verify(book1, 2);

    }

}
