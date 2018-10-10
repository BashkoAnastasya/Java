package com.programmer.gate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Client;
import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.SaleStr;
import com.programmer.gate.domain.State;
import com.programmer.gate.service.ClientService;
import com.programmer.gate.service.SaleService;
import com.programmer.gate.service.SaleStrService;
import com.programmer.gate.repos.StateRepo;

import java.math.BigDecimal;
import java.text.*;
import java.util.Date;
import java.util.List;

@Controller
public class SaleController {

	private ClientService clientService;
	@Autowired	
	public void setclientService(ClientService clientService) {
		this.clientService = clientService;
	}

	private SaleService saleService;
	@Autowired
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	
	private SaleStrService saleStrService;
	@Autowired
	public void setSaleStrService(SaleStrService saleStrService) {
		this.saleStrService = saleStrService;
	}	

	@Autowired
	private StateRepo stateRepo;

	@GetMapping("/sale")
	public String Sale(Map<String, Object> model,Map<String, Object> model2 ) {

		List<Sale> sales = saleService.findAll();

		model.put("sales", sales);

		return "sale";
	}

	@GetMapping("/editSale/{id}")
	public String editSale(@PathVariable Integer id, Model model,Map<String, Object> model2, Map<String, Object> model3,Map<String, Object> model4 ) {

		List<State> states=stateRepo.findAll();
		model3.put("states", states);	

		List<Client> clients=clientService.findAll();
		model2.put("clients", clients);	

		Sale sale = saleService.getSaleById(id);
		model.addAttribute("sale", sale);
		
		List <SaleStr> saleStrs=saleStrService.findBySale(sale);
		model4.put("saleStrs", saleStrs);	

		return "operations/sale/editSale";
	}

	@PostMapping("/updateSale")
	public String saveclient(@RequestParam Integer id, @RequestParam String num,  @RequestParam String dt, @RequestParam (name="client") int client_id, @RequestParam ("state") int state_id, @RequestParam BigDecimal discount
			) {
		State state= stateRepo.findById(state_id).orElse(new State());	

		Client client=clientService.getClientById(client_id); 

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date convertedDate = new Date();

		try {
			convertedDate = dateFormat.parse(dt);
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		saleService.updateSale(id, num, convertedDate, client, state, discount);

		return "redirect:/sale";
	}

	@PostMapping("/saveSale")
	public String updateSale(@RequestParam String code,@RequestParam String num,@RequestParam String dt,@RequestParam ("client") int  client_id,@RequestParam ("state") int  state_id,@RequestParam BigDecimal discount) {


		State state = stateRepo.findById(state_id).orElse(new State());

		Client client=clientService.getClientById(client_id);    	

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date convertedDate = new Date();

		try {
			convertedDate = dateFormat.parse(dt);
		} catch (ParseException e) {	     
			e.printStackTrace();
		}

		saleService.saveSale(new Sale(code,num, client,convertedDate,state,discount));

		return "redirect:/Sale";
	}
	
	@GetMapping("/newSale")
	public String newSale(Map<String, Object> model,Map<String, Object> model2) {

		List<Client> clients=clientService.findAll();
		model2.put("clients", clients);	

		List<State> states=stateRepo.findAll();
		model.put("states", states);

		return "operations/Sale/newSale";        
	}

	@GetMapping("/deleteSale/{id}")
	public String delete(@PathVariable Integer id) {

		saleService.deleteSale(id);

		return "redirect:/";
	}

	@PostMapping("/Sale")
	public String add(Map<String, Object> model,Map<String, Object> model2 ) {

		List<Sale> Sales = saleService.findAll();
		model.put("Sales", Sales);

		List<Client> clients=clientService.findAll();
		model2.put("client", clients);	

		return "Sale";
	}

}
