package JunitTestingWIthoutMockito.Mock;

import JunitTestingWIthoutMockito.Model.Book;

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
