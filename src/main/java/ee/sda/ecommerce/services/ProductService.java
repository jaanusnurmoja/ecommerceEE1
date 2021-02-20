package ee.sda.ecommerce.services;

import ee.sda.ecommerce.entities.Category;
import ee.sda.ecommerce.entities.Product;
import ee.sda.ecommerce.repositories.ProductRepository;
import ee.sda.ecommerce.utils.ProductDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
This class represent a bean for the product service
RequiredArgsConstructor creates a constructor where the parameters are all final properties
we can inject using autowired or constructor
 */
@Service
@RequiredArgsConstructor
public class ProductService implements GenericService<Product> {

    final private ProductRepository repository;
    final private ProductDateUtils dateUtils;

    @Override
    public List<Product> findAll() {
        List<Product> productList = repository.findAll();
        productList.forEach(product -> {
            Category emptyCategory = new Category();
            emptyCategory.setName("No Category");
            if(product.getCategory() == null){
                product.setCategory(emptyCategory);
            }
            });
        return productList;
    }

    public List<Product> findAllLessThanPrice(Integer value) {
        List<Product> productList = repository.findAll();
        productList.forEach(product -> {
            Category emptyCategory = new Category();
            emptyCategory.setName("No Category");
            if(product.getCategory() == null){
                product.setCategory(emptyCategory);
            }
        });
        return productList;
    }

    @Override
    @Transactional
    public void createOrUpdate(Product object) {
        dateUtils.updateTime(object);
        repository.save(object);
    }

    @Override
    public Product read(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Product object) {
        repository.delete(object);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Product> findProductsNameLike(String value) {
        List<Product> productList = repository.findProductByNameContains(value);
        productList.forEach(product -> {
            Category emptyCategory = new Category();
            emptyCategory.setName("No Category");
            if(product.getCategory() == null){
                product.setCategory(emptyCategory);
            }
        });
        return productList;
    }
}
