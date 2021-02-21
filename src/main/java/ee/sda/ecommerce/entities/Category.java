package ee.sda.ecommerce.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/*
@Getter
@Setter
 */
@Getter
@Setter
@Entity
public class Category {

    @GeneratedValue
    @Id
    Long id;
    String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    List<Product> productList;


}
