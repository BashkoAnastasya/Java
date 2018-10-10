package com.programmer.gate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Rest;

import com.programmer.gate.service.RestService;


@Controller
public class RestController {

	private RestService restService;

	@Autowired
	public void setRestService(RestService restService) {
		this.restService = restService;
	}


	@GetMapping("/rest")
	public String filter(Map<String, Object> model) {

		List<Rest> rests;

		rests = restService.findAll();      

		model.put("rests", rests);

		return "rest";
	}

	@PostMapping("/rest")
	public String filter(@RequestParam String ware, Map<String, Object> model) {

		Iterable<Rest> rests;
		
		rests = restService.findAll();  
		rests=restService.filter(ware);

		model.put("rests", rests);

		return "rest";
	}	

}