package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

	 @GetMapping
	    public Map<String, String> home() {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Hello, it is a test route");
	        return response;
	   }
}