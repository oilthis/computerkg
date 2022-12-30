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

    public void delAllKnowledgeUnit() {
        knowledgeUnitRepository.deleteAll();
    }

    public KnowledgeUnit getKnowledgeUnitByName(String name) {
        return knowledgeUnitRepository.findFirstByName(name);
    }

    public KnowledgeUnit addKnowledgeUnit(String name) {
        return knowledgeUnitRepository.save(KnowledgeUnit.builder().name(name).build());
    }

    public void delKnowledgeUnit(String name){
        knowledgeUnitRepository.delete(getKnowledgeUnitByName(name));
    }
}
