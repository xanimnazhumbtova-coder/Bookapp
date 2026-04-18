package com.example.demo.controller;

import com.example.demo.model.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookController {

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book,
                           BindingResult result,
                           @RequestParam("coverImage") MultipartFile file) {

        if (result.hasErrors()) {
            return "add-book";
        }

        if (!file.isEmpty()) {
            System.out.println("File received: " + file.getOriginalFilename());
        }


        return "redirect:/add?success";
    }
}
