package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Supplier;
import com.programmer.gate.domain.Supply;
import com.programmer.gate.domain.State;
import com.programmer.gate.service.SupplierService;
import com.programmer.gate.service.SupplyService;
import com.programmer.gate.repos.StateRepo;


import java.text.*;
import java.util.Date;
import java.util.List;

@Controller
public class SupplyController {

	private SupplierService supplierService;
	@Autowired	
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	private SupplyService supplyService;
	@Autowired
	public void setSupplyService(SupplyService supplyService) {
		this.supplyService = supplyService;
	}

	@Autowired
	private StateRepo stateRepo;
	
	@GetMapping("/supply")
	public String supply(Map<String, Object> model,Map<String, Object> model2 ) {

		List<Supply> supplys = supplyService.findAll();

		model.put("supplys", supplys);

		return "supply";
	}

	@GetMapping("/editSupply/{id}")
	public String editSupply(@PathVariable Integer id,  Model model,Map<String, Object> model2, Map<String, Object> model3) {

		List<State> states=stateRepo.findAll();
		model3.put("states", states);	

		List<Supplier> suppliers=supplierService.findAll();
		model2.put("suppliers", suppliers);	

		Supply supply = supplyService.getSupplyById(id);
        
		model.addAttribute("supply", supply);

		return "operations/supply/editSupply";
	}

	@PostMapping("/updateSupply")
	public String saveSupplier(@RequestParam Integer id, @RequestParam String num,  @RequestParam String code, @RequestParam String dt, @RequestParam (name="supplier") int supplier_id, @RequestParam ("state") int state_id
			) {
		State state= stateRepo.findById(state_id).orElse(new State());
		Integer s_id= Integer.valueOf(supplier_id);

		Supplier supplier=supplierService.getSupplierById(s_id); 

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		Date convertedDate = new Date();

		try {
			convertedDate = dateFormat.parse(dt);
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		supplyService.updateSupply(id, num,code,convertedDate,supplier,state);

		return "redirect:/supply";
	}


	@GetMapping("/newSupply")
	public String newSupply(Map<String, Object> model,Map<String, Object> model2) {


		List<Supplier> suppliers=supplierService.findAll();
		model2.put("suppliers", suppliers);	

		List<State> states=stateRepo.findAll();
		model.put("states", states);

		return "operations/supply/newSupply";        
	}

	@GetMapping("/deleteSupply/{id}")
	public String delete(@PathVariable Integer id) {

		supplyService.deleteSupply(id);

		return "redirect:/";
	}

	@PostMapping("/saveSupply")
	public String updateSupply(@RequestParam String code,@RequestParam String num,@RequestParam String dt,@RequestParam ("supplier") int  supplier_id) {


		State state = stateRepo.findById(1).orElse(new State());

		Supplier supplier=supplierService.getSupplierById(supplier_id);    	

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		Date convertedDate = new Date();

		try {
			convertedDate = dateFormat.parse(dt);
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		supplyService.saveSupply(new Supply(code,num, supplier,convertedDate,state));

		return "redirect:/supply";
	}


	@PostMapping("/supply")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<Supply> supplys = supplyService.findAll();
		model.put("supplys", supplys);

		List<Supplier> suppliers=supplierService.findAll();
		model2.put("supplier", suppliers);	

		return "supply";
	}

}
