package com.kg.controller;

import com.kg.model.entity.Major;
import com.kg.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
@Slf4j
public class MajorController {

    @Autowired
    MajorService majorService;

    @GetMapping("/get_all")
    public List<Major> getAllMajor() {
        return majorService.getAllMajor();
    }

    @DeleteMapping("/del_all")
    public void delAllMajor() {
        majorService.delAllMajor();
    }

    @GetMapping("/get")
    public Major getMajor(@RequestParam("name") String name) {
        return majorService.getMajorByName(name);
    }

    @PostMapping("/add")
    public Major addMajor(@RequestParam("name") String name) {
        return majorService.addMajor(name);
    }

    @DeleteMapping("/del")
    public void deleteMajor(@RequestParam("name") String name) {
        majorService.delMajor(name);
    }
}
