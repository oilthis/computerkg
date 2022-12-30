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

    public void delAllTextbook() {
        textbookRepository.deleteAll();
    }

    public Textbook getTextbookByName(String name) {
        return textbookRepository.findFirstByName(name);
    }

    public Textbook addTextbook(String name) {
        return textbookRepository.save(Textbook.builder().name(name).build());
    }

    public void delTextbook(String name){
        textbookRepository.delete(getTextbookByName(name));
    }
}
