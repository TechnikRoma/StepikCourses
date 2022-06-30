package bookstore.tests;

import bookstore.tests.rest.client.TestClient;
import bookstore.tests.rest.model.BookValidatableResponse;
import rest.enums.Category;
import org.testng.annotations.Test;
import bookstore.tests.rest.model.request.Book;

import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public void testCreateBook() {
        Book book = new Book("Mark Twain",
                Category.Adventures,
                10,
                "The story about Tom Sawyer.", 250,
                "The Adventures of Tom Sawyer");

        TestClient client = new TestClient();

        BookValidatableResponse response = client.create(book).
                checkStatusCode(201).
                checkIdNotNull().
               checkLastUpdated().
                checkTitle().
               checkBook(book);

        client.read(response.getId()).checkStatusCode(200).checkId(response.getId()).checkLastUpdated().checkBook(book);



    }
}

