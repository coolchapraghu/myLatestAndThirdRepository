package JunitTesting_With_Mockito.Chapter14VerifyAtLeastNumberofTimes;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
