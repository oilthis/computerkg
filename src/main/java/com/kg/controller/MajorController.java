package com.kg.controller;

import com.kg.model.CommonResult;
import com.kg.model.entity.Major;
import com.kg.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
@Slf4j
public class MajorController {

    @Autowired
    MajorService majorService;

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @GetMapping("/get_all")
    public CommonResult getAllMajor() {
        List<Major> result = majorService.getAllMajor();
        StringBuilder resultbuilder = new StringBuilder();
        for(Major C:result) resultbuilder.append(C);
        log.info("*****查看全部通知结果：" + resultbuilder);

        if (result != null) {
            return new CommonResult(200, "获取全部专业成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的专业", null);
        }
    }

    @DeleteMapping("/del_all")
    public CommonResult delAllMajor() {
        int result = majorService.delAllMajor();
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除全部专业成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,专业不存在", null);
        }
    }

    @GetMapping("/get")
    public CommonResult getMajor(@RequestParam("name") String name) {
        Major result = majorService.getMajorByName(name);
        log.info("*****查看全部专业结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取专业成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的专业", null);
        }
    }

    @PostMapping("/add")
    public CommonResult addMajor(@RequestParam("name") String name) {
        Major result = majorService.addMajor(name);
        log.info("*****添加专业结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加专业成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @DeleteMapping("/del")
    public CommonResult deleteMajor(@RequestParam("name") String name) {
        int result = majorService.delMajor(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除专业成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,专业不存在", null);
        }
    }
}
