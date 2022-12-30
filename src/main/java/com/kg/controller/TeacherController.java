package com.kg.controller;

import com.kg.model.entity.Teacher;
import com.kg.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/get_all")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @DeleteMapping("/del_all")
    public void delAllTeacher() {
        teacherService.delAllTeacher();
    }

    @GetMapping("/get")
    public Teacher getTeacher(@RequestParam("name") String name) {
        return teacherService.getTeacherByName(name);
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestParam("name") String name) {
        return teacherService.addTeacher(name);
    }

    @DeleteMapping("/del")
    public void deleteTeacher(@RequestParam("name") String name) {
        teacherService.delTeacher(name);
    }
}
