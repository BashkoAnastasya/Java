package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {
	
    @GetMapping("/")
    public String main(Map<String, Object> model) {    	               
        return "main";
    }
    
    @GetMapping("/snake")
    public String snake(Map<String, Object> model) {    	               
        return "snake";
    }
 
}