package JunitTesting_With_Mockito.MockTestDouble;

public class MockBookService {

    private MockBookRepository mockBookRepository;

    public MockBookService(MockBookRepository bookRepository) {
        this.mockBookRepository = bookRepository;
    }

    public void addBook(Book book){

        if(book.getPrice() > 5500) return;
        mockBookRepository.save(book);
    }

}
