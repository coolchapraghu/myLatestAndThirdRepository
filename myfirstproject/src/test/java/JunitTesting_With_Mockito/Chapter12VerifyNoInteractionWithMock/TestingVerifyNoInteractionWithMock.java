package JunitTesting_With_Mockito.Chapter12VerifyNoInteractionWithMock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestingVerifyNoInteractionWithMock {

    @InjectMocks
    private BookService bookService;

    //@Spy // for behaviour verification, @Spy and @Mock pretty much works each same way
    // they exhibit almost same functionality
    @Mock
    private BookRepository bookRepository;

    @Test
    public void testingVerifyNoInteractionWithMock(){

       bookService.updatePrice(null, 7430);
        Mockito.verifyNoInteractions(bookRepository);

    }
}
