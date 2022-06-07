package HW5.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductsResponseRequest {

    private Integer id;

    private String title;

    private Integer price;

    private String categoryTitle;

}
