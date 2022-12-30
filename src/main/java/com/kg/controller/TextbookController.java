package com.kg.controller;

import com.kg.model.CommonResult;
import com.kg.model.entity.Textbook;
import com.kg.model.entity.Textbook;
import com.kg.service.TextbookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/textbook")
@Slf4j
public class TextbookController {

    @Autowired
    TextbookService textbookService;

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @GetMapping("/get_all")
    public CommonResult getAllTextbook() {
        List<Textbook> result = textbookService.getAllTextbook();
        StringBuilder resultbuilder = new StringBuilder();
        for(Textbook C:result) resultbuilder.append(C);
        log.info("*****查看全部通知结果：" + resultbuilder);

        if (result != null) {
            return new CommonResult(200, "获取全部教材成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的教材", null);
        }
    }

    @DeleteMapping("/del_all")
    public CommonResult delAllTextbook() {
        int result = textbookService.delAllTextbook();
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除全部教材成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,教材不存在", null);
        }
    }

    @GetMapping("/get")
    public CommonResult getTextbook(@RequestParam("name") String name) {
        Textbook result = textbookService.getTextbookByName(name);
        log.info("*****查看全部教材结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取教材成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的教材", null);
        }
    }

    @PostMapping("/add")
    public CommonResult addTextbook(@RequestParam("name") String name) {
        Textbook result = textbookService.addTextbook(name);
        log.info("*****添加教材结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加教材成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @DeleteMapping("/del")
    public CommonResult deleteTextbook(@RequestParam("name") String name) {
        int result = textbookService.delTextbook(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除教材成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,教材不存在", null);
        }
    }
}
