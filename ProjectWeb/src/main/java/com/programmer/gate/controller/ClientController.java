package com.programmer.gate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programmer.gate.domain.Client;
import com.programmer.gate.domain.Dept;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.programmer.gate.service.ClientService;


@Controller
public class ClientController {

	private ClientService clientService;

	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}


	@GetMapping("/filterClient")
	public String filter(Map<String, Object> model) {

		List<Client> clients;

		clients = clientService.findAll();      

		model.put("clients", clients);

		return "operations/client/filter";
	}


	@PostMapping("/filterClient")
	public String filter(@RequestParam String filter_name, @RequestParam String filter_moniker, Map<String, Object> model) {

		Iterable<Client> clients;

		clients=clientService.filter(filter_name, filter_moniker);

		model.put("clients", clients);

		return "operations/client/filter";
	}


	@GetMapping("/editClient/{id}")
	public String edit(@PathVariable Integer id, Model model) {

		Client client = clientService.getClientById(id);

		model.addAttribute("client", client);

		return "operations/client/edit";
	}

	@PostMapping("/updateClient")
	public String saveClient(@RequestParam Integer id, @RequestParam String name,@RequestParam String moniker,
			@RequestParam String isVip,@RequestParam String town) {
		clientService.updateClient(id, name, moniker,isVip,town);

		return "redirect:/client";
	}


	@GetMapping("/newClient")
	public String newClient() {

		return "operations/client/new";        
	}
	
	@PostMapping("/saveClient")
	public String updateClient( @RequestParam String name,@RequestParam String moniker,
			@RequestParam String isVip,@RequestParam String town,@RequestParam Dept dept) {

		clientService.saveClient(new Client(name, moniker,dept,isVip,town));

		return "redirect:/operations/client/list";
	}

	@GetMapping("/deleteClient/{id}")
	public String delete(@PathVariable Integer id) {

		clientService.deleteClient(id);	

		return "redirect:/operations/client/list";
	}    




}