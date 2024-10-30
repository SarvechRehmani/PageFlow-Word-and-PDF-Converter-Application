package com.pageflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/more")
    public String more(){
        return "moreOptions.html";
    }

}
