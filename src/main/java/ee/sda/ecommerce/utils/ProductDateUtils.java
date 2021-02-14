package ee.sda.ecommerce.utils;

import ee.sda.ecommerce.entities.Product;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductDateUtils {

    public Product updateTime(Product product){
        product.setUpdatedAt(new Date());
        return product;
    }
}
