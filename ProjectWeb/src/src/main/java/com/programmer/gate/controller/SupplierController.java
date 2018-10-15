package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Supplier;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.programmer.gate.service.SupplierService;

import oracle.jdbc.OracleDatabaseException;


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
	public String filter(@RequestParam String name, @RequestParam String moniker, Map<String, Object> model) {

		Iterable<Supplier> suppliers;

		suppliers=supplierService.findByNameAndMoniker(name,moniker);

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

		return "redirect:/filter";
	}


	@GetMapping("/new")
	public String newSupplier() {

		return "operations/supplier/new";        
	}

	@PostMapping("/save")
	public String updateSupplier(@RequestParam String name,@RequestParam String moniker) {

		supplierService.saveSupplier(new Supplier(name,moniker));

		return "redirect:/filter";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {

		try {
			supplierService.deleteSupplier(id);	
		} catch (DataIntegrityViolationException   ge) {			

			if(ge.getCause() != null && ge.getCause().getCause().getCause() instanceof OracleDatabaseException) {

				OracleDatabaseException se = (OracleDatabaseException)ge.getCause().getCause().getCause();
				if(se.getOracleErrorNumber() == 2292) {
					String errorMessage="Нельзя удалить, есть поражденные записи";
					model.addAttribute("errorMessage",errorMessage);
				}else{
					throw ge;
				}
			}else{
				throw ge;
			}
		}    
		return "redirect:/filter";
	}
}


