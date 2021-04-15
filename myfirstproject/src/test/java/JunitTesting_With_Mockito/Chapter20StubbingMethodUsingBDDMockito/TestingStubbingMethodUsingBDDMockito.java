package JunitTesting_With_Mockito.Chapter20StubbingMethodUsingBDDMockito;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestingStubbingMethodUsingBDDMockito {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscount_Then_NewBooksWithAppliedDiscountIsReturned(){

        // Arrange - Given
        Book book1 = new Book("Physics", " My Fav Subject", 4000, LocalDate.now() );
        Book book2 = new Book("Chemistry", "The ultimate science", 6500, LocalDate.now());

        List<Book> bookList = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);

        int days = 7;

        BDDMockito.given(bookRepository.findNewBooks(days)).willReturn(bookList);

        // Act - When
        List<Book> discountBooks = bookService.getNewBooksWithAppliedDiscount(10, days);

        // Assert - Then

        // lets import AssertJ to implement BDD Assertions
        // add AssetJ library

        BDDAssertions.then(discountBooks).isNotNull();
        BDDAssertions.then(discountBooks.size()).isEqualTo(2);
        BDDAssertions.then(discountBooks.get(0).getPrice()).isEqualTo(3600);


    }

    @Test
    public void testingVerifyNoInteractionWithMockusingTraditionalMockito(){

        Book book = new Book("Physics", "My Fav Subject", 5500, LocalDate.now());

        Mockito.when(bookRepository.findBookById("Physics")).thenReturn(book);
        bookService.updatePrice("Physics", 5500);

        Mockito.verify(bookRepository).findBookById("Physics");
        //Mockito.verify(bookRepository).save(book);
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void testingVerifyNoInteractiUsingBDDMockito(){

        // Arrange
        Book book = new Book("Physics", "My Fav Subject", 5500, LocalDate.now());

        BDDMockito.given(bookRepository.findBookById("Physics")).willReturn(book);

        // Act
        bookService.updatePrice("Physics", 5500);

        // Assert/Verify
        BDDMockito.then(bookRepository).should().save(book);
    }

}
