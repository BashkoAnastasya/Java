package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Supplier;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.programmer.gate.service.SupplierService;


@Controller
public class SupplierController {

	private SupplierService supplierService;

	@Autowired
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
       
    @GetMapping("/filter")
    public String filter(Map<String, Object> model) {
    	
        Iterable<Supplier> suppliers;
        
       	suppliers = supplierService.findAll();      

        model.put("suppliers", suppliers);

        return "operations/supplier/filter";
    }
		
		
    @PostMapping("/filter")
    public String filter(@RequestParam String filter_name, @RequestParam String filter_moniker, Map<String, Object> model) {
    	
        Iterable<Supplier> suppliers;

        suppliers=supplierService.filter(filter_name, filter_moniker);

        model.put("suppliers", suppliers);

        return "operations/supplier/filter";
    }
    
    
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		
		Supplier supplier = supplierService.getSupplierById(id);
		
		model.addAttribute("supplier", supplier);
		
		return "operations/supplier/edit";
	}

	@PostMapping("/update")
	public String saveSupplier(@RequestParam Integer id, @RequestParam String name,@RequestParam String moniker
			) {
		supplierService.updateSupplier(id, name, moniker);
		
		return "redirect:/supplier";
	}

	
    @GetMapping("/new")
    public String newSupplier() {
    	
        return "operations/supplier/new";        
    }

    @PostMapping("/save")
    public String updateSupplier(@RequestParam String name,@RequestParam String moniker) {
    	
    	supplierService.saveSupplier(new Supplier(name,moniker));
    	
        return "redirect:/operations/supplier/list";
    }
            
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		supplierService.deleteSupplier(id);	
		
		return "redirect:/operations/supplier/list";
	}    
	
	


}