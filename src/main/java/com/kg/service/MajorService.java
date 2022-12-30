package com.kg.service;

import com.kg.model.entity.Major;
import com.kg.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    MajorRepository majorRepository;
    public List<Major> getAllMajor() {
        return majorRepository.findAll();
    }

    public void delAllMajor() {
        majorRepository.deleteAll();
    }

    public Major getMajorByName(String name) {
        return majorRepository.findFirstByName(name);
    }

    public Major addMajor(String name) {
        return majorRepository.save(Major.builder().name(name).build());
    }

    public void delMajor(String name){
        majorRepository.delete(getMajorByName(name));
    }
}