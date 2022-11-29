package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserService;
import com.example.demo.vo.Users;

@Controller    // This means that this class is a Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name2, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Users n = new Users();
        n.setName2(name2);
        n.setEmail(email);
        userService.userInsert(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.userSelect();
    }
}