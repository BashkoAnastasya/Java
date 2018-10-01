package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Models;
import com.programmer.gate.domain.Ware;

import com.programmer.gate.repos.ModelRepo;


import org.springframework.web.bind.annotation.*;
import com.programmer.gate.service.WareService;


@Controller
public class WareController {

	private WareService wareService;
	
	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	public void setWareService(WareService wareService) {
		this.wareService = wareService;
	}
		   
    @GetMapping("/ware")
    public String ware(Map<String, Object> model) {
    	
        Iterable<Ware> wares = wareService.findAll();
        
        model.put("wares", wares);
        
        return "ware";
    }
    
	@GetMapping("/editWare/{id}")
	public String editWare(@PathVariable Integer id, Model model) {
		
		Ware ware = wareService.getWareById(id);
		
		model.addAttribute("ware", ware);
		
		return "operations/ware/editWare";
	}
	
	@PostMapping("/updateWare")
	public String updateware(@RequestParam Integer id,@RequestParam (name="model") int model_id,@RequestParam String moniker,@RequestParam String name,@RequestParam String szOrig,@RequestParam String szRus) {
				
		Models model= modelRepo.findById(model_id).orElse(new Models());
		
		wareService.updateWare( id,  model,  moniker,  name,  szOrig,  szRus);
		
		return "redirect:/ware";
	}

	
    @GetMapping("/newWare")
    public String newWare() {
    	
        return "operations/ware/newWare";        
    }

    @PostMapping("/saveWare")
    public String saveWare(@RequestParam (name="model") int model_id,@RequestParam String moniker,@RequestParam String name,@RequestParam String szOrig,@RequestParam String szRus) {
    	
    	Models model= modelRepo.findById(model_id).orElse(new Models());
    	    	
    	wareService.saveWare( new Ware(model,  moniker,  name,  szOrig,  szRus));    	
    	
        return "redirect:/operations/ware/listWare";
    }
    
        
	@GetMapping("/deleteWare/{id}")
	public String deleteWare(@PathVariable Integer id) {
		
		wareService.deleteWare(id);	
		
		return "redirect:/operations/ware/listWare";
	}    
	
	


}