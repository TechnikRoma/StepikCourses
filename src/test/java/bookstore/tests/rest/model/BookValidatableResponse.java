package bookstore.tests.rest.model;

import bookstore.tests.rest.model.request.Book;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class BookValidatableResponse {

    private BookResponse model;
    private Response response;

    public BookValidatableResponse(Response response){
        this.response = response;
        model = response.as(BookResponse.class);

    }

    public BookValidatableResponse checkStatusCode(int statusCode){

        response.then().statusCode(statusCode);

        return this;
    }

    public BookValidatableResponse checkIdNotNull(){

        response.then().body("id", Matchers.notNullValue());

        return this;
    }
    public BookValidatableResponse checkLastUpdated(){

        response.then().body("lastUpdated", Matchers.notNullValue());

        return this;
    }
    public BookValidatableResponse checkTitle(){

        response.then().body("title", Matchers.notNullValue());

        return this;
    }
    public BookValidatableResponse checkBook(Book expected){
        Assert.assertEquals(new Book(model), expected);

        return this;
    }


}
