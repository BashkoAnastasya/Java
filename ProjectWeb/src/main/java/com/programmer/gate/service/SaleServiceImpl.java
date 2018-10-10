package com.programmer.gate.service;
import com.programmer.gate.service.SaleService;
import com.programmer.gate.domain.Client;
import com.programmer.gate.domain.Sale;

import com.programmer.gate.repos.SaleRepo;
import com.programmer.gate.domain.State;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{
	private SaleRepo repository;

	@Autowired
	public void setProductRepository(SaleRepo repository) {
		this.repository = repository;
	}
	
	@Override
	public Sale getSaleById(Integer id) {		
		return repository.findById(id).orElse(new Sale());
	}	

	@Override
	public void saveSale(Sale Sale) {
		 repository.save(Sale);		
	}

	@Override
	public void updateSale(Integer id, String num, Date dt,Client client,State state,BigDecimal discount) {
		Sale saleUpdate=repository.findById(id).orElse(new Sale());		
		saleUpdate.setNum(num);
		saleUpdate.setDt(dt);
		saleUpdate.setClient(client);
		saleUpdate.setState(state);
		saleUpdate.setDiscount(discount);
		repository.save(saleUpdate);		
	}

	@Override
	public void deleteSale(Integer id) {
		repository.deleteById(id);		
	}
	
	@Override
	public List<Sale> findAll() {	
		return (List<Sale>) repository.findAll();
	}
	

	

}
