package ee.sda.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
/*

 */

@ControllerAdvice
public class ErrorController {

    @Autowired
    ProductController productController;

    @ExceptionHandler(ConstraintViolationException.class)
    String constraintError(Model model, ConstraintViolationException e){
        List<String> message = new ArrayList<>();
        for(ConstraintViolation v : e.getConstraintViolations()){
            message.add(v.getMessage());
        }
        model.addAttribute("errorMessage", message);
        return productController.createProductGet(model);
    }
}
