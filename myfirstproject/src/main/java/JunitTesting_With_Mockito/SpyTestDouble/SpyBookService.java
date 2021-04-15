package JunitTesting_With_Mockito.SpyTestDouble;



public class SpyBookService {

    private SpyBookRepository bookRepository;

    public SpyBookService(SpyBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){

        if(book.getPrice() > 5500) return;
        bookRepository.save(book);
    }

}
