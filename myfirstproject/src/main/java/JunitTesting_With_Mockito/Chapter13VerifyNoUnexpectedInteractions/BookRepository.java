package JunitTesting_With_Mockito.Chapter13VerifyNoUnexpectedInteractions;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
