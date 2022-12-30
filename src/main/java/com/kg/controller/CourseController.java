package com.kg.controller;

import com.kg.model.entity.Course;
import com.kg.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/get_all")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @DeleteMapping("/del_all")
    public void delAllCourse() {
        courseService.delAllCourse();
    }

    @GetMapping("/get")
    public Course getCourse(@RequestParam("name") String name) {
        return courseService.getCourseByName(name);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestParam("name") String name) {
        return courseService.addCourse(name);
    }

    @DeleteMapping("/del")
    public void deleteCourse(@RequestParam("name") String name) {
        courseService.delCourse(name);
    }
}
