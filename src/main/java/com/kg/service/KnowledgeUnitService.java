package com.kg.service;

import com.kg.model.entity.KnowledgeUnit;
import com.google.common.collect.Lists;
import com.kg.repository.KnowledgeUnitRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<String> getRelationshipByName(String name){
        List<String> pathStrings = new ArrayList<>();

        for (PathValue p : knowledgeUnitRepository.getRelationShipByName(name)){
            Path path = p.asPath();
            List<Node> nodes = Lists.newArrayList(path.nodes());
            List<Relationship> relationships = Lists.newArrayList(path.relationships());

            String s = nodes.get(0).get("name").toString().substring(1, nodes.get(0).get("name").toString().length()-1) +
                    "-" +
                    relationships.get(0).type() +
                    "-" +
                    nodes.get(1).get("name").toString().substring(1, nodes.get(1).get("name").toString().length()-1);

            pathStrings.add(s);
        }
        return pathStrings;
    }
}
