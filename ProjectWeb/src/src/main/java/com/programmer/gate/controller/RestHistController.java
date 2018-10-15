package com.programmer.gate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.RestHist;

import com.programmer.gate.service.RestHistService;


@Controller
public class RestHistController {

	private RestHistService restHistService;

	@Autowired
	public void setRestHistService(RestHistService restHistService) {
		this.restHistService = restHistService;
	}

	@GetMapping("/restHist")
	public String filter(Map<String, Object> model) {

		List<RestHist> restHists;

		restHists = restHistService.findAll();      

		model.put("restHists", restHists);

		return "restHist";
	}

	@PostMapping("/restHist")
	public String filter(@RequestParam String wareName,@RequestParam String dbeg,@RequestParam String dend, Map<String, Object> model) {

		Iterable<RestHist> restHists;		
		restHists = restHistService.findAll(); 

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		Date convertedDbeg = new Date();
		Date convertedDbend = new Date();		


		try {
			if (dbeg==""){
				convertedDbeg=dateFormat.parse("1900-12-12");			
			}
			else
			{
				convertedDbeg = dateFormat.parse(dbeg);				
			}
			if (dend==""){
				convertedDbend=dateFormat.parse("2200-12-12");					
			}
			else
			{	
				convertedDbend = dateFormat.parse(dend);			
			}

		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		restHists=restHistService.filter(wareName, convertedDbeg, convertedDbend);

		model.put("restHists", restHists);

		return "restHist";
	}	

}