package com.programmer.gate.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

		return "operations/priseWare/editPriceWare";
	}

	@PostMapping("/PriceWare")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<PriceWare> priceWares = priceWareService.findAll();
		model.put("priceWares", priceWares);

		List<Ware> wares=wareService.findAll();
		model2.put("wares", wares);	

		return "priceWares";
	}

}
