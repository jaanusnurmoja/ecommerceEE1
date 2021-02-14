package ee.sda.ecommerce.controllers;

import ee.sda.ecommerce.entities.Category;
import ee.sda.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping( "/create")
    String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "createCategoryGet";
    }

    @PostMapping("/create")
    RedirectView createCategoryPost(Category category){
        service.createOrUpdate(category);
        return new RedirectView("/product/all");
    }
}
