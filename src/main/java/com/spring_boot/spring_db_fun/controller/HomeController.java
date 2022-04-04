package com.spring_boot.spring_db_fun.controller;

import com.spring_boot.spring_db_fun.model.User;
import com.spring_boot.spring_db_fun.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    //dependency injection to use UserService class
    @Autowired
    private UserService userService;

    //get  the mapping for index page
    @GetMapping("/")
    //create a list of users @fetchAll() - add them to the model
    public String index(Model model) {
        List<User> userList = userService.fetchAll();
        model.addAttribute("users", userList);
        return "home/index";
    }

}
