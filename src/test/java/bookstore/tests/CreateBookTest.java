package bookstore.tests;

import enums.Category;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import model.Book;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public void testCreateBook() {
        Book book = new Book("Mark Twain",
                Category.Adventures,
                10,
                "The story about Tom Sawyer.",250,
                "The Adventures of Tom Sawyer");


        given().baseUri("http://localhost:8080").
                basePath("/rest-api").
                contentType(ContentType.JSON).
                body(book).
                log().all().
                when().post("books").
                then().assertThat().statusCode(201).
                body("id", Matchers.notNullValue()).
                body("title", Matchers.equalTo("The Adventures of Tom Sawyer")).
                body("description", Matchers.equalTo("The story about Tom Sawyer.")).
                body("author", Matchers.equalTo("Mark Twain")).
                body("price", Matchers.equalTo(250)).
                body("count", Matchers.equalTo(10)).
                log().all();


    }
}

