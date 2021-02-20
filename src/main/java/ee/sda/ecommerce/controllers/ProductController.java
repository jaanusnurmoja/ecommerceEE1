package ee.sda.ecommerce.controllers;

import ee.sda.ecommerce.entities.Product;
import ee.sda.ecommerce.services.CategoryService;
import ee.sda.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.jetbrains.annotations.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @Autowired
    CategoryService categoryService;

    // localhost:8080/product/create
    @GetMapping("/create")
    String createProductGet(Model model){

        if (model.getAttribute("errorMessage") == null){
            model.addAttribute("errorMessage", new ArrayList<String>());
        }
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "createProductGet";
    }

    @PostMapping("/create")
    RedirectView createProductPost(Product product){
        service.createOrUpdate(product);
        return new RedirectView("/product/all");
    }

    @GetMapping("/{id}")
    String getOneProduct(@NotNull Model model, @PathVariable("id") Long id){
        model.addAttribute("product", service.read(id));
        return "oneProductGet";
    }

    @GetMapping("/{id}/edit")
    String editProductGet(@NotNull Model model, @PathVariable("id") Long id){
        model.addAttribute("product", service.read(id));
        model.addAttribute("categories", categoryService.findAll());
        return "editProductGet";
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = {RequestMethod.PATCH, RequestMethod.PUT})
    RedirectView editProductPatch(Product product, @PathVariable("id") Long id){
        product = service.read(id);
        service.createOrUpdate(product);
        return new RedirectView("/product/all");
    }

    //Model is injected by Spring
    //The string returned is the view name on that case: allProducts.html on templates folder
    @GetMapping("/all")
    String allProducts(Model model){
         List<Product> productList = service.findAll();
        model.addAttribute("products", productList);
        return "allProducts";
    }

    @GetMapping("/value/{value}")
    String allProducts(Model model, @PathVariable("value") Integer value){
        List<Product> productList = service.findAllLessThanPrice(value);
        model.addAttribute("products", productList);
        return "allProducts";
    }

    @GetMapping("/search/{value}")
    String allProducts(Model model, @PathVariable("value") String value){
        List<Product> productList = service.findProductsNameLike(value);
        model.addAttribute("products", productList);
        return "allProducts";
    }







}
