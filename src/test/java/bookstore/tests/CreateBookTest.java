package bookstore.tests;

import rest.client.TestClient;
import rest.enums.Category;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import rest.model.Book;
import props.TestConfig;

import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public void testCreateBook() {
        Book book = new Book("Mark Twain",
                Category.Adventures,
                10,
                "The story about Tom Sawyer.", 250,
                "The Adventures of Tom Sawyer");

        TestClient testClient = new TestClient();

        testClient.create(book).assertThat().
                statusCode(201).
                body("id", Matchers.notNullValue()).
                body("title", Matchers.equalTo("The Adventures of Tom Sawyer")).
                body("description", Matchers.equalTo("The story about Tom Sawyer.")).
                body("author", Matchers.equalTo("Mark Twain")).
                body("price", Matchers.equalTo(250)).
                body("count", Matchers.equalTo(10)).
                log().all();


    }
}

