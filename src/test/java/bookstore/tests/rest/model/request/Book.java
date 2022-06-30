package bookstore.tests.rest.model.request;


import lombok.*;
import rest.enums.Category;

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
}
