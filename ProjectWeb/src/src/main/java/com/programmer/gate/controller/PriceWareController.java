package com.programmer.gate.controller;

import java.util.Map;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Ware;

import com.programmer.gate.domain.PriceWare;

import com.programmer.gate.service.WareService;
import com.programmer.gate.service.PriceWareService;



@Controller
public class PriceWareController {

	private PriceWareService priceWareService;
	@Autowired	
	public void setPriceWareService(PriceWareService priceWareService) {

		this.priceWareService = priceWareService;
	}

	private WareService wareService;
	@Autowired
	public void setWareService(WareService wareService) {

		this.wareService = wareService;
	}


	@GetMapping("/priceWare")
	public String PriceWare(Map<String, Object> model ) {

		List<PriceWare> priceWares = priceWareService.findAll();

		model.put("priceWares", priceWares);

		return "priceWare";
	}

	@GetMapping("/editPriceWare/{id}")
	public String editSale(@PathVariable Integer id, Model model,Map<String, Object> model2, Map<String, Object> model3) {


		List<Ware> wares=wareService.findAll();
		model2.put("wares", wares);	

		PriceWare priceWare = priceWareService.getPriceWareById(id);
		model.addAttribute("priceWare", priceWare);

		return "operations/priceWare/editPriceWare";
	}	

	@GetMapping("/newPriceWare")
	public String newWare(Map<String, Object> model) {

		List<Ware> wares=wareService.findAll();  	
		model.put("wares", wares);  	

		return "operations/priceWare/newPriceWare";        
	}


	@PostMapping("/PriceWare")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<PriceWare> priceWares = priceWareService.findAll();
		model.put("priceWares", priceWares);

		List<Ware> wares=wareService.findAll();
		model2.put("wares", wares);	

		return "priceWares";
	}

	@PostMapping("/updatePriceWare")

	public String savePriceWare(@RequestParam Integer id, @RequestParam String dbeg,  @RequestParam String dend, @RequestParam BigDecimal price, @RequestParam (name="ware") int ware_id 
			) {

		Ware ware=wareService.getWareById(ware_id);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date convertedDateBeg = new Date();
		Date convertedDateEnd = new Date();

		try {
			convertedDateBeg = dateFormat.parse(dbeg);
			convertedDateEnd = dateFormat.parse(dend);			
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		priceWareService.updatePriceWare(id, convertedDateBeg, convertedDateEnd, price, ware);

		return "redirect:/priceWare";
	}	

	@GetMapping("/deletePriceWare/{id}")
	public String delete(@PathVariable Integer id) {

		priceWareService.deletePriceWare(id);
		
		return "redirect:/priceWare";
	}
	
	@PostMapping("/savePriceWare")
	public String updateSupply(@RequestParam String dbeg,  @RequestParam String dend, @RequestParam BigDecimal price, @RequestParam (name="ware") int ware_id) {

		Ware ware=wareService.getWareById(ware_id);    	

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date convertedDateBeg = new Date();
		Date convertedDateEnd = new Date();

		try {
			convertedDateBeg = dateFormat.parse(dbeg);
			convertedDateEnd = dateFormat.parse(dend);			
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		priceWareService.savePriceWare(new PriceWare(convertedDateBeg, convertedDateEnd, price, ware));

		return "redirect:/priceWare";
	}





}
