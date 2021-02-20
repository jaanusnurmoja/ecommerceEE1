package ee.sda.ecommerce.repositories;

import ee.sda.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByNameContains(String name);
}
