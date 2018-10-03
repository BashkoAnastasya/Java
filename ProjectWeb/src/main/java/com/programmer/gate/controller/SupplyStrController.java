package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Supply;
import com.programmer.gate.domain.SupplyStr;
import com.programmer.gate.domain.Ware;

import com.programmer.gate.service.SupplyStrService;
import com.programmer.gate.service.SupplyService;
import com.programmer.gate.service.WareService;

import java.math.BigDecimal;

import java.util.List;

@Controller
public class SupplyStrController {

	private SupplyStrService supplyStrService;
	@Autowired	
	public void setSupplierService(SupplyStrService supplyStrService) {
		this.supplyStrService = supplyStrService;
	}

	private SupplyService supplyService;
	@Autowired
	public void setSupplyService(SupplyService supplyService) {
		this.supplyService = supplyService;
	}

	private WareService wareService;
	@Autowired
	public void setWareService(WareService wareService) {
		this.wareService = wareService;
	}

	@GetMapping("/supplyStr")
	public String supplyStr(Map<String, Object> model,Map<String, Object> model2) {

		List<SupplyStr> supplyStrs = supplyStrService.findAll();

		model.put("supplyStrs", supplyStrs);

		return "supplyStr";
	}

	@GetMapping("/editSupplyStr/{id}")
	public String editSupplyStr(@PathVariable Integer id, Model model,Map<String, Object> model2, Map<String, Object> model3) {

		List<Ware> wares=wareService.findAll();
		model3.put("wares", wares);	

		List<Supply> supplys=supplyService.findAll();
		model2.put("supplys", supplys);	

		SupplyStr supplyStr = supplyStrService.getSupplyStrById(id);

		model.addAttribute("supplyStr", supplyStr);

		return "operations/supplyStr/editSupplyStr";
	}


	@PostMapping("/updateSupplyStr")
	public String updateSupplyStr(@RequestParam Integer id,   @RequestParam String num, @RequestParam Integer qty,  @RequestParam BigDecimal price, @RequestParam (name="supply") int supply_id,  @RequestParam (name="ware") int ware_id
			) {
		Ware ware= wareService.getWareById(ware_id);		

		Supply supply=supplyService.getSupplyById(supply_id); 		

		supplyStrService.updateSupplyStr(id,num,price,qty,ware,supply);
		
		return "redirect:/supplyStr";		
	}


	@GetMapping("/newSupplyStr")
	public String newSupplyStr(Map<String, Object> modelSupply,Map<String, Object> modelWare) {


		List<Supply> supplys=supplyService.findAll();
		modelSupply.put("supplys", supplys);	

		List<Ware> wares=wareService.findAll();
		modelWare.put("wares", wares);

		return "operations/supplyStr/newSupplyStr";        
	}

	@GetMapping("/deleteSupplyStr/{id}")
	public String delete(@PathVariable Integer id) {

		supplyService.deleteSupply(id);

		return "redirect:/supplyStr";
	}

	@PostMapping("/saveSupplyStr")
	public String saveSupply(@RequestParam String num, @RequestParam Integer qty,  @RequestParam BigDecimal price, @RequestParam (name="supply") int supply_id,  @RequestParam (name="ware") int ware_id) {

		Ware ware= wareService.getWareById(ware_id);		

		Supply supply=supplyService.getSupplyById(supply_id); 

		try{
			supplyStrService.saveSupplyStr(new SupplyStr(num,price,qty,ware,supply));
		}catch (Exception  ex ){
			System.out.println("The document can not be changed");          
		}

		return "redirect:/supplyStr";
	}


	@PostMapping("/supplyStr")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<SupplyStr> supplyStrs = supplyStrService.findAll();
		model.put("supplyStrs", supplyStrs);

		List<Ware> wares=wareService.findAll();
		model2.put("wares", wares);	

		return "supplyStr";
	}

}
