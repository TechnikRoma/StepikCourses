package bookstore.tests.rest.model;

import bookstore.tests.rest.model.request.Book;
import lombok.*;

import java.time.OffsetDateTime;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class BookResponse extends Book {
    private Integer id;
    private OffsetDateTime lastUpdated;


}
