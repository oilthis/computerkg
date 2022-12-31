package com.kg.service;

import com.google.common.collect.Lists;
import com.kg.model.entity.Major;
import com.kg.repository.MajorRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {

    @Autowired
    MajorRepository majorRepository;
    public List<Major> getAllMajor() {
        return majorRepository.findAll();
    }

    public int delAllMajor() {
        majorRepository.deleteAll();
        if(majorRepository.findAll().isEmpty()) return 1;
        else return 0;
    }

    public Major getMajorByName(String name) {
        return majorRepository.findFirstByName(name);
    }

    public Major addMajor(String name) {
        return majorRepository.save(Major.builder().name(name).build());
    }

    public int delMajor(String name){
        majorRepository.delete(getMajorByName(name));
        if(majorRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }

    public List<String> getRelationshipByName(String name){
        List<String> pathStrings = new ArrayList<>();

        for (PathValue p : majorRepository.getRelationByName(name)){
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
