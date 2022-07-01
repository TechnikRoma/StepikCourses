package bookstore.tests.rest.client;

import bookstore.tests.rest.model.BookValidatableResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import props.TestConfig;
import bookstore.tests.rest.model.request.Book;
import bookstore.tests.rest.model.BookValidatableResponse;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class TestClient {

    private String baseUri;
    private String basePath;

    public TestClient() {
        this(TestConfig.Uri.value, TestConfig.Path.value);
    }

    public RequestSpecification getRequestSpec() {
        return given().baseUri(baseUri).
                basePath(basePath).
                contentType(ContentType.JSON).
                log().all();

//config.properties
//uri=http://localhost:8080
//path=/rest-api/
    }

    public RequestSpecification getRequestSpec(Object book) {
        return getRequestSpec().
                body(book);
    }

    public BookValidatableResponse create(Book book) {
        Response response = getRequestSpec(book).when().
                post("/books");
        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse read(Integer id) {
        Response response = getRequestSpec().when().
                get("/books/{id}", id);

        response.then().log().all();
        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse update(Integer id, Book book) {
        Response response = getRequestSpec(book).when().
                put("/books/{id}", id);

        response.then().log().all();
        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse delete(Integer id) {
        Response response = getRequestSpec().when().
                delete("/books/{id}", id);

        response.then().log().all();
        return new BookValidatableResponse(response);
    }
}

