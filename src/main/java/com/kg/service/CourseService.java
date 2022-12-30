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

    public int delAllCourse() {
        courseRepository.deleteAll();
        if(courseRepository.findAll().isEmpty()) return 1;
        else return 0;
    }

    public Course getCourseByName(String name) {
        return courseRepository.findFirstByName(name);
    }

    public Course addCourse(String name, String course_code, String course_hours, Double course_credit) {
        return courseRepository.save(Course.builder().name(name).Course_code(course_code).Course_hours(course_hours).Course_credit(course_credit).build());
    }

    public int delCourse(String name){
        courseRepository.delete(getCourseByName(name));
        if(courseRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }
}
