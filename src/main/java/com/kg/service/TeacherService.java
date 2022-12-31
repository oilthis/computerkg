package com.kg.service;

import com.google.common.collect.Lists;
import com.kg.model.entity.Teacher;
import com.kg.repository.TeacherRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public int delAllTeacher() {
        teacherRepository.deleteAll();
        if(teacherRepository.findAll().isEmpty()) return 1;
        else return 0;
    }

    public Teacher getTeacherByName(String name) {
        return teacherRepository.findFirstByName(name);
    }

    public Teacher addTeacher(String name) {
        return teacherRepository.save(Teacher.builder().name(name).build());
    }

    public int delTeacher(String name){
        teacherRepository.delete(getTeacherByName(name));
        if(teacherRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }

    public List<String> getRelationshipByName(String name){
        List<String> pathStrings = new ArrayList<>();

        for (PathValue p : teacherRepository.getRelationByName(name)){
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
