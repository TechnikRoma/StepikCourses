package rest.model;


import rest.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    private String author;
    private Category category;
    private Integer count;
    private String description;
    private Integer price;
    private String title;


}
