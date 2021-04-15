package JunitTestingWIthoutMockito.Service;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.Repository.BookRepository;

public class FakeBookService {

    private BookRepository bookRepository;


    // the below constructor is for the FakeTest1WithoutMockito test class
    /*public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    // the below constructor is for the DummyTest1WithoutMockito test class
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

        bookRepository.save(book);
    }

    public int findNumberofBooks(){

        return bookRepository.findAll().size();
    }
}
