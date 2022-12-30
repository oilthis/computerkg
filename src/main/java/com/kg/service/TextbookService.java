package com.kg.service;

import com.kg.model.entity.Textbook;
import com.kg.repository.TextbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextbookService {

    @Autowired
    TextbookRepository textbookRepository;
    public List<Textbook> getAllTextbook() {
        return textbookRepository.findAll();
    }

    public int delAllTextbook() {
        textbookRepository.deleteAll();
        if(textbookRepository.findAll().isEmpty()) return 1;
        else return 0;
    }

    public Textbook getTextbookByName(String name) {
        return textbookRepository.findFirstByName(name);
    }

    public Textbook addTextbook(String name) {
        return textbookRepository.save(Textbook.builder().name(name).build());
    }

    public int delTextbook(String name){
        textbookRepository.delete(getTextbookByName(name));
        if(textbookRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }
}
