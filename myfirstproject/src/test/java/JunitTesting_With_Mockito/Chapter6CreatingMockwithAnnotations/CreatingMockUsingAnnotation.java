package JunitTesting_With_Mockito.Chapter6CreatingMockwithAnnotations;

import JunitTesting_With_Mockito.Chapter6CreatingMockwithAnnotations.Book;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.BDDAssertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

// Regarding @ExtendWith(MockitoExtension.class)
// for @Mock annotation to successfully create Mock Beans,
// you need to add @ExtendWith and extend our class with the MockitoExtension Class

// In Junit4, instead of @ExtendWith(MockitoExtension.class), you will say,  @RunWith(MockitoJUnitRunner.class)
// rest all, its same to same

// once you add above shown annotation and class it will start recognizing and creating Beans for us
// If you dont do it, you will get NullPointerException wherever Mock Beans are used

// Also, you cant directly extend our class with  "extends MockitoExtension " ..
// like class CreatingMockUsingAnnotation extends MockitoExtension ..
// it wont work that way
@ExtendWith(MockitoExtension.class)
public class CreatingMockUsingAnnotation {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testStubbinginTraditionalMockitoStyle(){

        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        int days = 7;

        Mockito.when(bookRepository.findNewBooks(days)).thenReturn(bookList);

        List<Book> discountBooks = bookService.getNewBooksWithAppliedDiscount(10, days);

        Assertions.assertEquals(2, discountBooks.size());
        Assertions.assertEquals(3600, discountBooks.get(0).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");
        Assertions.assertEquals(5850, discountBooks.get(1).getPrice(), () -> "Expected and Actual discount prices" +
                " are not matching");


    }

}
