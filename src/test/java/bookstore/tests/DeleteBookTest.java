package bookstore.tests;

import bookstore.tests.rest.model.BookValidatableResponse;
import bookstore.tests.rest.model.request.Book;
import org.testng.annotations.Test;
import bookstore.tests.BookStoreTestBase;

import static bookstore.tests.BookStoreTestBase.testClient;

public class DeleteBookTest {

    @Test
    public void testDeleteBook() {
        BookValidatableResponse response = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.delete(response.getId()).
                checkStatusCode(200);

        testClient.read((response.getId())).
                checkStatusCode(404);



    }

    @Test
    public void testDeleteNotExistedBook(){
        testClient.delete(99999).
                checkStatusCode(304);
    }
}
