package JunitTestingWithoutMockito.SpyTests;

import JunitTestingWIthoutMockito.Model.Book;

public class SpyBookRepository implements JunitTestingWIthoutMockito.Spy.SpyBookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {

        saveCalled++;
        lastAddedBook = book;

    }

    public int timesCalled(){

        return saveCalled;
    }

    public  boolean calledWith(Book book){

        return lastAddedBook.equals(book);
    }

}
