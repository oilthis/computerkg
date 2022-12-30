package com.kg.controller;

import com.kg.model.entity.Textbook;
import com.kg.service.TextbookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/textbook")
@Slf4j
public class TextbookController {

    @Autowired
    TextbookService textbookService;

    @GetMapping("/get_all")
    public List<Textbook> getAllTextbook() {
        return textbookService.getAllTextbook();
    }

    @DeleteMapping("/del_all")
    public void delAllTextbook() {
        textbookService.delAllTextbook();
    }

    @GetMapping("/get")
    public Textbook getTextbook(@RequestParam("name") String name) {
        return textbookService.getTextbookByName(name);
    }

    @PostMapping("/add")
    public Textbook addTextbook(@RequestParam("name") String name) {
        return textbookService.addTextbook(name);
    }

    @DeleteMapping("/del")
    public void deleteTextbook(@RequestParam("name") String name) {
        textbookService.delTextbook(name);
    }
}
