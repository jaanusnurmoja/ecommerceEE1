package ee.sda.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    Long id;
    String name;
    String description;
    Integer price;
    String image;
}
