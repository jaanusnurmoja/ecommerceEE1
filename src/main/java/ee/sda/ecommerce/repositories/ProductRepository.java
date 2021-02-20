package ee.sda.ecommerce.repositories;

import ee.sda.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Query method
    List<Product> findProductByNameContains(String name);

    List<Product> findProductByNameContainsAndDescriptionContains(String name, String description);

    //Query method
    List<Product> findProductByDescriptionContains(String name);

    //JPQL
    @Query("select p from Product p where p.price < :value")
    List<Product> getAllWithPricesLessThanValue(@Param("value") Integer price);


    //SQL
    @Query(value = "select * from product where price > :value1 and price < :value2", nativeQuery = true)
    List<Product> getbetweenValue(@Param("value1") Integer value1, @Param("value2") Integer value2);


}
