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

    public List<Course> getAllCountry() {
        return courseRepository.findAll();
    }

    public Course getCourseByName(String name) {
        return courseRepository.findFirstByName(name);
    }
}
