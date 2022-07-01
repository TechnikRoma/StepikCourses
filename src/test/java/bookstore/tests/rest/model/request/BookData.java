package bookstore.tests.rest.model.request;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import rest.enums.Category;

public class BookData {
    @DataProvider
    public static Object[][] positive() {
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