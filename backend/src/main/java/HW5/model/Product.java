package HW5.model;

import file.db.model.Products;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Product extends Products {

    Integer id;

    String title;

    Integer price;

    String categoryTitle;

}
