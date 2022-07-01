package bookstore.tests;

import bookstore.tests.rest.model.BookResponse;
import bookstore.tests.rest.model.request.Book;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest.enums.Category;

public class CreateBookTestNegative extends BookStoreTestBase {

    @Test(dataProvider = "createBooksNegative")
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());
    }

    @DataProvider
    public Object[][] createBooksNegative() {
        return new Object[][]{
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},
                {Book.defaultOf().setCategory(Category.Unknown)},
                {Book.defaultOf().setCount(-1)},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},
                {Book.defaultOf().setPrice(-1)},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))}

                //title >= 257
                //description < 2
                //description >513
                //author 2 101
                //price -1
                //count -1
                //category not from unknown
        };
    }
}
