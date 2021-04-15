package JunitTestingWIthoutMockito.Spy;

import JunitTestingWIthoutMockito.Model.Book;

public class SpyBookService {

    private SpyBookRepository bookRepository;

    public SpyBookService(SpyBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

}
