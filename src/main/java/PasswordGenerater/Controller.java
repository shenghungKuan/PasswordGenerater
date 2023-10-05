package PasswordGenerater;

// Java Program to Illustrate Controller of Spring Application

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/jdbc")
public class Controller {

    @GetMapping
    public String get(Model model) {

        // Add object to be bound by user provided details
        model.addAttribute("obj", new UserDetails());
        return "template";
    }

    @PostMapping
    public String post(@ModelAttribute("obj") UserDetails user, Model model) {

        JDBC SQL = new JDBC();
        int result = SQL.insert(user);
        if(result == 1)
            model.addAttribute("message", "Successful JDBC connection and execution of SQL statement");
        else
            model.addAttribute("message", "Query not submitted!");
        return "Status";
    }
}
