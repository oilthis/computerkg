package com.kg.controller;

import com.kg.model.CommonResult;
import com.kg.model.entity.KnowledgeUnit;
import com.kg.service.KnowledgeUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledgeUnit")
@Slf4j
public class KnowledgeUnitController {

    @Autowired
    KnowledgeUnitService knowledgeUnitService;

    @Value("8080")
    private String serverPort;//添加serverPort

    @GetMapping("/get_all")
    public CommonResult getAllKnowledgeUnit() {
        List<KnowledgeUnit> result = knowledgeUnitService.getAllKnowledgeUnit();
        StringBuilder resultbuilder = new StringBuilder();
        for(KnowledgeUnit C:result) resultbuilder.append(C);
        log.info("*****查看全部知识单元结果：" + resultbuilder);

        if (result != null) {
            return new CommonResult(200, "获取全部知识单元成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的知识单元", null);
        }
    }

    @DeleteMapping("/del_all")
    public CommonResult delAllKnowledgeUnit() {
        int result = knowledgeUnitService.delAllKnowledgeUnit();
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除全部知识单元成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,知识单元不存在", null);
        }
    }

    @GetMapping("/get")
    public CommonResult getKnowledgeUnit(@RequestParam("name") String name) {
        KnowledgeUnit result = knowledgeUnitService.getKnowledgeUnitByName(name);
        log.info("*****查看全部知识单元结果：" + result);

        if (result != null) {
            return new CommonResult(200, "获取知识单元成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "没有可获取的知识单元", null);
        }
    }

    @PostMapping("/add")
    public CommonResult addKnowledgeUnit(@RequestParam("name") String name) {
        KnowledgeUnit result = knowledgeUnitService.addKnowledgeUnit(name);
        log.info("*****添加知识单元结果：" + result);

        if (result != null) {
            return new CommonResult(200, "添加知识单元成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "添加失败", null);
        }
    }

    @DeleteMapping("/del")
    public CommonResult deleteKnowledgeUnit(@RequestParam("name") String name) {
        int result = knowledgeUnitService.delKnowledgeUnit(name);
        log.info("*****删除结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "删除知识单元成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "删除失败,知识单元不存在", null);
        }
    }
}
