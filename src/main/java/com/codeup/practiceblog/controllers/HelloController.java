package com.codeup.practiceblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
