package ee.sda.ecommerce.services;

import ee.sda.ecommerce.entities.Category;

import java.util.List;
/*
Generic service for a crud
 */

public interface GenericService<T> {

    List<T> findAll();
    void createOrUpdate(T object);
    T read(Long id);
    void delete(T object);
    void delete(Long id);
}
