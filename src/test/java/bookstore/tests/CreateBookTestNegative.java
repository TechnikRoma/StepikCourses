package bookstore.tests;

import bookstore.tests.rest.model.BookResponse;
import bookstore.tests.rest.model.request.Book;
import bookstore.tests.rest.model.request.BookData;
import org.testng.annotations.Test;

public class CreateBookTestNegative extends BookStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());
    }
    }

