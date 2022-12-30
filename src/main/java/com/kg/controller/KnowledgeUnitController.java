package com.kg.controller;

import com.kg.model.entity.KnowledgeUnit;
import com.kg.service.KnowledgeUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledgeUnit")
@Slf4j
public class KnowledgeUnitController {

    @Autowired
    KnowledgeUnitService knowledgeUnitService;

    @GetMapping("/get_all")
    public List<KnowledgeUnit> getAllKnowledgeUnit() {
        return knowledgeUnitService.getAllKnowledgeUnit();
    }

    @DeleteMapping("/del_all")
    public void delAllKnowledgeUnit() {
        knowledgeUnitService.delAllKnowledgeUnit();
    }

    @GetMapping("/get")
    public KnowledgeUnit getKnowledgeUnit(@RequestParam("name") String name) {
        return knowledgeUnitService.getKnowledgeUnitByName(name);
    }

    @PostMapping("/add")
    public KnowledgeUnit addKnowledgeUnit(@RequestParam("name") String name) {
        return knowledgeUnitService.addKnowledgeUnit(name);
    }

    @DeleteMapping("/del")
    public void deleteKnowledgeUnit(@RequestParam("name") String name) {
        knowledgeUnitService.delKnowledgeUnit(name);
    }
}
