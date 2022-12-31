package com.kg.controller;

import com.kg.model.CommonResult;
import com.kg.model.entity.Teacher;
import com.kg.model.entity.Teacher;
import com.kg.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Value("8080")
    private String serverPort;//添加serverPort

    @GetMapping("/get_all")
    public CommonResult getAllTeacher() {
        List<Teacher> result = teacherService.getAllTeacher();
        StringBuilder resultbuilder = new StringBuilder();
        for(Teacher C:result) resultbuilder.append(C);
        log.info("*****查看全部教师结果：" + resultbuilder);

        if (result != null) {
            return new CommonResult(200, "获取全部教师成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的教师", null);
        }
    }

    @DeleteMapping("/del_all")
    public CommonResult delAllTeacher() {
        int result = teacherService.delAllTeacher();
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除全部教师成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,教师不存在", null);
        }
    }

    @GetMapping("/get")
    public CommonResult getTeacher(@RequestParam("name") String name) {
        Teacher result = teacherService.getTeacherByName(name);
        log.info("*****查看全部教师结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取教师成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的教师", null);
        }
    }

    @PostMapping("/add")
    public CommonResult addTeacher(@RequestParam("name") String name) {
        Teacher result = teacherService.addTeacher(name);
        log.info("*****添加教师结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加教师成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @GetMapping("/del")
    public CommonResult deleteTeacher(@RequestParam("name") String name) {
        int result = teacherService.delTeacher(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除教师成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,教师不存在", null);
        }
    }

    @GetMapping("/get_rel")
    public CommonResult getRelationshipByName(@RequestParam("name") String name) {
        List<String> result = teacherService.getRelationshipByName(name);
        log.info("*****查看全部知识单元结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取关系成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的关系", null);
        }
    }
}
