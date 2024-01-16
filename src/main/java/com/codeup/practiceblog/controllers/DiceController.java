package com.codeup.practiceblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class DiceController {

    @GetMapping("")
    public String home() {
        return "dice";
    }

    @GetMapping("/{guess}")
    public String results(@PathVariable int guess, Model model) {
        int roll = (int)Math.floor(Math.random() * 6) + 1;
        model.addAttribute("roll", roll);
        model.addAttribute("guess", guess);
        if (roll == guess) {
            model.addAttribute("result", "correct");
        }
        else {
            model.addAttribute("result", "incorrect");
        }
        return "dice";
    }
}
