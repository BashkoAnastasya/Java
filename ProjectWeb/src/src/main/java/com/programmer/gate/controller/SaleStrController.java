package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.SaleStr;
import com.programmer.gate.domain.Ware;

import com.programmer.gate.service.SaleStrService;
import com.programmer.gate.service.SaleService;
import com.programmer.gate.service.WareService;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class SaleStrController {

	private SaleStrService saleStrService;
	@Autowired	
	public void setSupplierService(SaleStrService saleStrService) {
		this.saleStrService = saleStrService;
	}

	private SaleService saleService;
	@Autowired
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}

	private WareService wareService;
	@Autowired
	public void setWareService(WareService wareService) {
		this.wareService = wareService;
	}

	@GetMapping("/saleStr")
	public String saleStr(Map<String, Object> model,Map<String, Object> model2) {

		List<SaleStr> saleStrs = saleStrService.findAll();

		model.put("saleStrs", saleStrs);

		return "saleStr";
	}

	@GetMapping("/editSaleStr/{id}")
	public String editSaleStr(@PathVariable Integer id, Model model,Map<String, Object> model2, Map<String, Object> model3) {

		List<Ware> wares=wareService.findAll();
		model3.put("wares", wares);	

		List<Sale> sales=saleService.findAll();
		model2.put("sales", sales);	

		SaleStr saleStr = saleStrService.getSaleStrById(id);

		model.addAttribute("saleStr", saleStr);

		return "operations/saleStr/editSaleStr";
	}


	@PostMapping("/updateSaleStr")
	public String updateSaleStr(@RequestParam Integer id,   @RequestParam String num, @RequestParam Integer qty,  @RequestParam BigDecimal discount, @RequestParam (name="sale") int sale_id,  @RequestParam (name="ware") int ware_id
			) {
		Ware ware= wareService.getWareById(ware_id);		

		Sale sale=saleService.getSaleById(sale_id); 		

		saleStrService.updateSaleStr(id,num,qty,ware,sale,discount);		
		
		return "redirect:/saleStr";		
	}

	@PostMapping("/saveSaleStr")
	public String saveSale(@RequestParam String num, @RequestParam Integer qty,  @RequestParam BigDecimal discount, @RequestParam (name="sale") int sale_id,  @RequestParam (name="ware") int ware_id) {

		Ware ware= wareService.getWareById(ware_id);		

		Sale sale=saleService.getSaleById(sale_id); 

		try{
			saleStrService.saveSaleStr(new SaleStr(num,qty,ware,sale,discount));
		}catch (Exception  ex ){
			System.out.println("The document can not be changed");          
		}

		return "redirect:/saleStr";
	}


	@GetMapping("/newSaleStr")
	public String newSaleStr(Map<String, Object> model,Map<String, Object> model2) {

		List<Sale> sale=saleService.findAll();
		model2.put("sale", sale);	

		List<Ware> wares=wareService.findAll();
		model.put("wares", wares);

		return "operations/saleStr/newSaleStr";        
	}

	@GetMapping("/deleteSaleStr/{id}")
	public String delete(@PathVariable Integer id) {

		saleStrService.deleteSaleStr(id);

		return "redirect:/saleStr";
	}
	@PostMapping("/saleStr")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<SaleStr> saleStrs = saleStrService.findAll();
		model.put("saleStrs", saleStrs);

		List<Ware> wares=wareService.findAll();
		model2.put("wares", wares);	

		return "saleStr";
	}

}
