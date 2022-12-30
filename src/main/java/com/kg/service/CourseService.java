package com.kg.service;

import com.kg.model.entity.Course;
import com.kg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void delAllCourse() {
        courseRepository.deleteAll();
    }

    public Course getCourseByName(String name) {
        return courseRepository.findFirstByName(name);
    }

    public Course addCourse(String name) {
        return courseRepository.save(Course.builder().name(name).build());
    }

    public void delCourse(String name){
        courseRepository.delete(getCourseByName(name));
    }
}
