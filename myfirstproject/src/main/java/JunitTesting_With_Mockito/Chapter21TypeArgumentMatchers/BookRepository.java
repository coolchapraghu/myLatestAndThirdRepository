package JunitTesting_With_Mockito.Chapter21TypeArgumentMatchers;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
