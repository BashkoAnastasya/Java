package com.programmer.gate.service;
import com.programmer.gate.domain.Client;

import java.util.List;

public interface ClientService {
	
	   Client getClientById(Integer id);
	   void saveClient(Client client);
	   void updateClient(Integer id, String name,String moniker,String isVip,String town);
	   void deleteClient (Integer id);	   
	   List<Client> findAll();
	   List<Client> findByName(String name);
	   List<Client> filter(String filterName,String filterMoniker);
}


