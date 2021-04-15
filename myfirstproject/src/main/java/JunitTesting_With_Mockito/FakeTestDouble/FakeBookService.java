package JunitTesting_With_Mockito.FakeTestDouble;


public class FakeBookService {

    private BookRepository bookRepository;

    public FakeBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        System.out.println("In add book");
        bookRepository.save(book);
    }

    public int findNumberofBooks(){

        return bookRepository.findAll().size();
    }
}
