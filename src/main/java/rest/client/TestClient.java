package rest.client;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import props.TestConfig;
import rest.model.Book;

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

    public ValidatableResponse create (Book book) {
        ValidatableResponse response = getRequestSpec(book).when().
                post("/books").
                then().log().all();

        return response;
    }
}

