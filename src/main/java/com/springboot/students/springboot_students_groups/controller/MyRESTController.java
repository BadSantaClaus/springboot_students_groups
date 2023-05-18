package com.springboot.students.springboot_students_groups.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MyRESTController {

    @RequestMapping("/")
    public String getMessage(){
        return "Use /students/ or /groups/";
    }
}
