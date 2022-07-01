package bookstore.tests;

import bookstore.tests.rest.client.TestClient;

public class BookStoreTestBase {
    protected static TestClient testClient;

    static {
        testClient = new TestClient();

    }
}
