package com.kg.controller;

import com.kg.model.CommonResult;
import com.kg.model.entity.Course;
import com.kg.service.CourseService;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("8080")
    private String serverPort;//添加serverPort

    @GetMapping("/get_all")
    public CommonResult getAllCourse() {
        List<Course> result = courseService.getAllCourse();
        StringBuilder resultbuilder = new StringBuilder();
        for(Course C:result) resultbuilder.append(C);
        log.info("*****查看全部课程结果：" + resultbuilder);

        if (result != null) {
            return new CommonResult(200, "获取全部课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的课程", null);
        }
    }

    @DeleteMapping("/del_all")
    public CommonResult delAllCourse() {
        int result = courseService.delAllCourse();
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除全部课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,课程不存在", null);
        }
    }

    @GetMapping("/get")
    public CommonResult getCourse(@RequestParam("name") String name) {
        Course result = courseService.getCourseByName(name);
        log.info("*****查看全部课程结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的课程", null);
        }
    }

    @PostMapping("/add")
    public CommonResult addCourse(@RequestParam("name") String name, @RequestParam("Course_code") String course_code, @RequestParam("Course_hours") String course_hours, @RequestParam("Course_credit") String course_credit) {
        Course result = courseService.addCourse(name, course_code, course_hours, course_credit);
        log.info("*****添加课程结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @GetMapping("/del")
    public CommonResult deleteCourse(@RequestParam("name") String name) {
        int result = courseService.delCourse(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,课程不存在", null);
        }
    }

    @PostMapping("/addrel_c2k")
    public CommonResult addRelCourse2KnowledgeUnit(@RequestParam("courseName") String courseName, @RequestParam("knowledgeUnitName") String knowledgeUnitName) {
        Course result = courseService.addRelCourse2KnowledgeUnit(courseName, knowledgeUnitName);
        log.info("*****添加课程-知识点关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程-知识点关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @PostMapping("/addrel_c2m")
    public CommonResult addRelCourse2Major(@RequestParam("courseName") String courseName, @RequestParam("majorName") String majorName) {
        Course result = courseService.addRelCourse2Major(courseName, majorName);
        log.info("*****添加课程-专业关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程-专业关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @PostMapping("/addrel_c2t")
    public CommonResult addRelCourse2Teacher(@RequestParam("courseName") String courseName, @RequestParam("teacherName") String teacherName) {
        Course result = courseService.addRelCourse2Teacher(courseName, teacherName);
        log.info("*****添加课程-教师关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程-教师关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @PostMapping("/addrel_c2tb")
    public CommonResult addRelCourse2Textbook(@RequestParam("courseName") String courseName, @RequestParam("textbookName") String textbookName) {
        Course result = courseService.addRelCourse2Textbook(courseName, textbookName);
        log.info("*****添加课程-教材关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程-教材关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @PostMapping("/addrel_cbc")
    public CommonResult addRelCourseBeforeCourse(@RequestParam("course1Name") String course1Name, @RequestParam("course2Name") String course2Name) {
        Course result = courseService.addRelCourseBeforeCourse(course1Name, course2Name);
        log.info("*****添加先修关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加先修关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @PostMapping("/addrel_ctc")
    public CommonResult addRelCourseTogetherWithCourse(@RequestParam("course1Name") String course1Name, @RequestParam("course2Name") String course2Name) {
        Course result = courseService.addRelCourseTogetherWithCourse(course1Name, course2Name);
        log.info("*****添加同修关系结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加同修关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }
}
