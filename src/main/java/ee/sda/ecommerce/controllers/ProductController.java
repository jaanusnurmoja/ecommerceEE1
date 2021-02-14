package ee.sda.ecommerce.controllers;

import ee.sda.ecommerce.entities.Product;
import ee.sda.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/*
Its adviced to use constructor instead of autowired.
Autowired only works for spring and constructor you can use the class also outside spring
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    // localhost:8080/product/create
    @GetMapping("/create")
    String createProductGet(Model model){
        model.addAttribute("product", new Product());
        return "createProductGet";
    }

    @PostMapping("/create")
    RedirectView createProductPost(Product product){
        service.createOrUpdate(product);
        return new RedirectView("/all");
    }

    //Model is injected by Spring
    //The string returned is the view name on that case: allProducts.html on templates folder
    @GetMapping("/all")
    String allProducts(Model model){
         List<Product> productList = service.findAll();
        model.addAttribute("products", productList);
        return "allProducts";
    }






}
