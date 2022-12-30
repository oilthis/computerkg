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
    public CommonResult addCourse(@RequestParam("name") String name, @RequestParam("Course_code") String course_code, @RequestParam("Course_hours") String course_hours, @RequestParam("Course_credit") Double course_credit) {
        Course result = courseService.addCourse(name, course_code, course_hours, course_credit);
        log.info("*****添加课程结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @DeleteMapping("/del")
    public CommonResult deleteCourse(@RequestParam("name") String name) {
        int result = courseService.delCourse(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除课程成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,课程不存在", null);
        }
    }
}
