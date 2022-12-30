package com.kg.service;

import com.kg.model.entity.Teacher;
import com.kg.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
