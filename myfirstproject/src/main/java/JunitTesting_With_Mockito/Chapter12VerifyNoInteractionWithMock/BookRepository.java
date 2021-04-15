package JunitTesting_With_Mockito.Chapter12VerifyNoInteractionWithMock;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
