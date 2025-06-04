package com.example.finaltypeb.model;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/")
    public String checkThenDisplay(@Valid User user, BindingResult result, Model model){
        return "quiz";
    }
}
