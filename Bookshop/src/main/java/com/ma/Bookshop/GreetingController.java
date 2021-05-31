package com.ma.Bookshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/greeting")
    public class GreetingController {

        @GetMapping
        public String sayGreeting(Model model) {
            String name = System.getProperty("user.name");
            model.addAttribute("name", name);
            return "greeting";
        }
    }