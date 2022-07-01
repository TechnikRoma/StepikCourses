package bookstore.tests.rest.model.request;


import lombok.*;
import lombok.experimental.Accessors;
import rest.enums.Category;

@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    private String author;
    private Category category;
    private Integer count;
    private String description;
    private Integer price;
    private String title;

    public Book(Book book) {
        this.author = book.author;
        this.category = book.category;
        this.count = book.count;
        this.description = book.description;
        this.price = book.price;
        this.title = book.title;
    }

    public static Book defaultOf() {
        return new Book("Mark Twain",
                Category.Adventures,
                10,
                "The story about Tom Sawyer.", 250,
                "The Adventures of Tom Sawyer");
    }
}
