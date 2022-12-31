package com.kg.service;

import com.kg.model.entity.*;
import com.kg.model.relationship.*;
import com.kg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    KnowledgeUnitRepository knowledgeUnitRepository;
    @Autowired
    MajorRepository majorRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TextbookRepository textbookRepository;

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

    public Course addCourse(String name, String course_code, String course_hours, String course_credit) {
        return courseRepository.save(Course.builder().name(name).Course_code(course_code).Course_hours(course_hours).Course_credit(course_credit).build());
    }

    public int delCourse(String name){
        courseRepository.delete(getCourseByName(name));
        if(courseRepository.findFirstByName(name) != null) return 0;
        else return 1;
    }

    public Course addRelCourse2KnowledgeUnit(String courseName, String knowledgeUnitName){
        Course course = courseRepository.findFirstByName(courseName);
        KnowledgeUnit knowledgeUnit = knowledgeUnitRepository.findFirstByName(knowledgeUnitName);

        for (Course2KnowledgeUnit b : course.getCourse2KnowledgeUnits()){
            if (b.getKnowledgeUnit().getName().equals(knowledgeUnitName)){
                return course;
            }
        }
        course.getCourse2KnowledgeUnits().add(Course2KnowledgeUnit.builder().knowledgeUnit(knowledgeUnit).build());
        return courseRepository.save(course);
    }

    public Course addRelCourse2Major(String courseName, String majorName){
        Course course = courseRepository.findFirstByName(courseName);
        Major major = majorRepository.findFirstByName(majorName);

        for (Course2Major b : course.getCourse2Majors()){
            if (b.getMajor().getName().equals(majorName)){
                return course;
            }
        }
        course.getCourse2Majors().add(Course2Major.builder().major(major).build());
        return courseRepository.save(course);
    }

    public Course addRelCourse2Teacher(String courseName, String teacherName){
        Course course = courseRepository.findFirstByName(courseName);
        Teacher teacher = teacherRepository.findFirstByName(teacherName);

        for (Course2Teacher b : course.getCourse2Teachers()){
            if (b.getTeacher().getName().equals(teacherName)){
                return course;
            }
        }
        course.getCourse2Teachers().add(Course2Teacher.builder().teacher(teacher).build());
        return courseRepository.save(course);
    }

    public Course addRelCourse2Textbook(String courseName, String textbookName){
        Course course = courseRepository.findFirstByName(courseName);
        Textbook textbook = textbookRepository.findFirstByName(textbookName);

        for (Course2Textbook b : course.getCourse2Textbooks()){
            if (b.getTextbook().getName().equals(textbookName)){
                return course;
            }
        }
        course.getCourse2Textbooks().add(Course2Textbook.builder().textbook(textbook).build());
        return courseRepository.save(course);
    }

    public Course addRelCourseBeforeCourse(String course1Name, String course2Name){
        Course course1 = courseRepository.findFirstByName(course1Name);
        Course course2 = courseRepository.findFirstByName(course2Name);

        for (CourseBeforeCourse b : course1.getCourseBeforeCourses()){
            if (b.getCourse().getName().equals(course2Name)){
                return course1;
            }
        }
        course1.getCourseBeforeCourses().add(CourseBeforeCourse.builder().course(course2).build());
        return courseRepository.save(course1);
    }

    public Course addRelCourseTogetherWithCourse(String course1Name, String course2Name){
        Course course1 = courseRepository.findFirstByName(course1Name);
        Course course2 = courseRepository.findFirstByName(course2Name);

        for (CourseTogetherWithCourse b : course1.getCourseTogetherWithCourses()){
            if (b.getCourse().getName().equals(course2Name)){
                return course1;
            }
        }
        course1.getCourseTogetherWithCourses().add(CourseTogetherWithCourse.builder().course(course2).build());
        return courseRepository.save(course1);
    }
}
