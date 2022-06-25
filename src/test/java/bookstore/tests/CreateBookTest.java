package bookstore.tests;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public void testCreateBook() {
        String book = "{\n" +
                "  \"author\": \"Mark Twain\",\n" +
                "  \"category\": \"Adventures\",\n" +
                "  \"count\": 10,\n" +
                "  \"description\": \"The story about Tom Sawyer.\",\n" +
                "  \"price\": 250,\n" +
                "  \"title\": \"The Adventures of Tom Sawyer\"\n" +
                "}";

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

