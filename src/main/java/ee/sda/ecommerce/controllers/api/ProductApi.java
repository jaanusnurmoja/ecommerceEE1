package ee.sda.ecommerce.controllers.api;

import ee.sda.ecommerce.dto.ProductDTO;
import ee.sda.ecommerce.entities.Product;
import ee.sda.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    ProductService service;

    @GetMapping("/all")
    List<ProductDTO> getProducts(){
        return service.findAllDTO();
    }
}
