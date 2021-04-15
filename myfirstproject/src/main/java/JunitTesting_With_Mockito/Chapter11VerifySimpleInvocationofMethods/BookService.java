package JunitTesting_With_Mockito.Chapter11VerifySimpleInvocationofMethods;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest){

        if(bookRequest.getPrice() < 3000)
            return;
        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setTitle(bookRequest.getTitle());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }
}
