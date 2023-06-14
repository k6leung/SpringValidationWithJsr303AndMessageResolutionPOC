package com.example.validationtest.controller;

import com.example.validationtest.model.DataForm;
import com.example.validationtest.validator.DataFormBusinessValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new DataFormBusinessValidator());
    }

    @GetMapping("/page/input")
    public String inputPage(Model model) {
        model.addAttribute("form", new DataForm());
        return "input";
    }

    @GetMapping("/page/success")
    public String success() {
        return "success";
    }

    @PostMapping("/page/submit")
    public String submit(@Valid @ModelAttribute("form")DataForm form,
                         BindingResult bindingResult,
                         Model model) {
        if(bindingResult.hasErrors()) {
            return "input";
        }

        return "redirect:/page/success";
    }
}
