package ee.sda.ecommerce.services;

import ee.sda.ecommerce.entities.Category;
import ee.sda.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements GenericService<Category>{

    @Autowired
    CategoryRepository repository;


    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void createOrUpdate(Category object) {
        repository.save(object);
    }

    @Override
    public Category read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Category object) {
        repository.delete(object);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
