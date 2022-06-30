package bookstore.tests;

import bookstore.tests.rest.client.TestClient;
import bookstore.tests.rest.model.BookValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import rest.enums.Category;
import org.testng.annotations.Test;
import bookstore.tests.rest.model.request.Book;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test(dataProvider = "createBooks")
    public void testCreateBook(Book book) {


        TestClient client = new TestClient();

        BookValidatableResponse response = client.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkTitle().
                checkBook(book);

        client.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);

    }

    @DataProvider
    public Object[][] createBooks() {
        return new Object[][]{
                {Book.defaultOf()},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},
                {Book.defaultOf().setCategory(Category.Detective)},
                {Book.defaultOf().setCategory(Category.Horror)},
                {Book.defaultOf().setCategory(Category.Thriller)},
                {Book.defaultOf().setCount(0)},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},
                {Book.defaultOf().setPrice(0)},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},




                };
    }
    }
