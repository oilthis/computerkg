package com.kg.service;

import com.kg.model.entity.KnowledgeUnit;
import com.kg.repository.KnowledgeUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeUnitService {
    
    @Autowired
    KnowledgeUnitRepository knowledgeUnitRepository;
    public List<KnowledgeUnit> getAllKnowledgeUnit() {
        return knowledgeUnitRepository.findAll();
    }

    public int delAllKnowledgeUnit() {
        knowledgeUnitRepository.deleteAll();
        if(knowledgeUnitRepository.findAll().isEmpty()) return 1;
        else return 0;
    }

    public KnowledgeUnit getKnowledgeUnitByName(String name) {
        return knowledgeUnitRepository.findFirstByName(name);
    }

    public KnowledgeUnit addKnowledgeUnit(String name) {
        return knowledgeUnitRepository.save(KnowledgeUnit.builder().name(name).build());
    }

    public int delKnowledgeUnit(String name){
        knowledgeUnitRepository.delete(getKnowledgeUnitByName(name));
        if(knowledgeUnitRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }
}
