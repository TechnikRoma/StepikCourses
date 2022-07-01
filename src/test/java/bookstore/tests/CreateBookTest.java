package bookstore.tests;

import bookstore.tests.rest.client.TestClient;
import bookstore.tests.rest.model.BookValidatableResponse;
import bookstore.tests.rest.model.request.BookData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import rest.enums.Category;
import org.testng.annotations.Test;
import bookstore.tests.rest.model.request.Book;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book) {
        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkTitle().
                checkBook(book);

        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);

    }


}
