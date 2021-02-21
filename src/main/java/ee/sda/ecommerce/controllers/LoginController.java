package ee.sda.ecommerce.controllers;

import ee.sda.ecommerce.entities.UserEE1;
import ee.sda.ecommerce.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/login")
    String login(){
        return "login";
    }

    @GetMapping("/user/create")
    String createUser(Model model){
        model.addAttribute("user", new UserEE1());
        return "createUser";
    }

    @PostMapping("/user/create")
    RedirectView createUserPost(UserEE1 userEE1){
        userDetailsService.createUser(userEE1);
        return new RedirectView("/product/all");
    }
}
