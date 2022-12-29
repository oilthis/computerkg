package com.kg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@Slf4j
public class Neo4jController {

    @GetMapping("/hello")
    public String handle01(){
        return "hello";
    }
}
