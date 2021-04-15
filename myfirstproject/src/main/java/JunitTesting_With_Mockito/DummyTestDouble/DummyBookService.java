package JunitTesting_With_Mockito.DummyTestDouble;

public class DummyBookService {

    private BookRepository bookRepository;
    private EmailService emailService;


    public DummyBookService() {
    }

    // the below constructor is for the DummyTest1WithoutMockito test class
    public DummyBookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public int findNumberofBooks(){

        return bookRepository.findAll().size();
    }
}
