package ee.sda.ecommerce.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

/*
@Getter
@Setter
 */
@Data
@Entity
public class Product {

    @GeneratedValue
    @Id
    Long id;
    @Length(max = 12, message = "Product name bigger than expected")
    String name;
    String description;
    Date updatedAt;
    @Max(value = 10, message = "Price must be lower than 10")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "product_category")
    Category category;




}
