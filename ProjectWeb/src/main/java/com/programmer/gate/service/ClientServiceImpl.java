package com.programmer.gate.service;

import  org.springframework.beans.factory.annotation.Autowired;
import  com.programmer.gate.domain.Client;

import  org.springframework.stereotype.Service;
import  com.programmer.gate.repos.ClientRepo;
import  java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

	private ClientRepo repository;

	@Autowired
	public void setProductRepository(ClientRepo repository) {
		this.repository = repository;
	}

	@Override
	public Client getClientById(Integer id) {
		return repository.findById(id).orElse(new Client()); 
	}

	@Override
	public void saveClient(Client Client) {
		repository.save(Client);
	}

	@Override
	public void updateClient (Integer id, String name,String moniker,String isVip, String town) {
		Client updated = repository.findById(id).orElse(new Client()); 		
		updated.setName(name);
		updated.setMoniker(moniker);
		updated.setIsVip(isVip);
		updated.setTown(town);
		repository.save(updated);
	}

	@Override
	public void deleteClient(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Client> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<Client> filter(String filterName,String filterMoniker) {
	       List<Client> clients;

	        if (filterName != null && !filterName.isEmpty()) {
	        	clients = repository.findByName(filterName);
	        } else {
	        	clients = repository.findAll();
	        }
				
		return  clients;
	}
	
	

}


