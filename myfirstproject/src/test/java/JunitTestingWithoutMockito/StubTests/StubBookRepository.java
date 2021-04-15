package JunitTestingWithoutMockito.StubTests;

import JunitTestingWIthoutMockito.Model.Book;
import JunitTestingWIthoutMockito.stub.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// WIth this Stub, I am not going to database to get the list of Books

// I am just responding with an hard coded list

public class StubBookRepository  implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {

        List<Book> testBooks = new ArrayList<>();

        testBooks.add(new Book("Physics", " My Fav Subject", 4000, LocalDate.now() ));
        testBooks.add(new Book( "Chemistry", "The ultimate science", 6500, LocalDate.now()));

        return testBooks;
    }
}
