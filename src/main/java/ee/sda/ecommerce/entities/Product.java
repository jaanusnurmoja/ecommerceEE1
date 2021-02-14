package ee.sda.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
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
    String name;
    String description;
    Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_category")
    Category category;




}
