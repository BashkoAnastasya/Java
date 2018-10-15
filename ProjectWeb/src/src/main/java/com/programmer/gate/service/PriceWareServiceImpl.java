package com.programmer.gate.service;

import  org.springframework.beans.factory.annotation.Autowired;
import  com.programmer.gate.domain.PriceWare;
import com.programmer.gate.domain.Ware;

import  org.springframework.stereotype.Service;
import  com.programmer.gate.repos.PriceWareRepo;

import java.math.BigDecimal;
import java.util.Date;
import  java.util.List;

@Service
public class PriceWareServiceImpl implements PriceWareService{

	private PriceWareRepo repository;

	@Autowired
	public void setProductRepository(PriceWareRepo repository) {
		this.repository = repository;
	}

	@Override
	public PriceWare getPriceWareById(Integer id) {
		return repository.findById(id).orElse(new PriceWare()); 
	}

	@Override
	public void savePriceWare(PriceWare PriceWare) {
		repository.save(PriceWare);
	}

	@Override
	public void updatePriceWare (Integer id,Date dbeg,Date dend,BigDecimal price,Ware ware )  {
		PriceWare updated = repository.findById(id).orElse(new PriceWare()); 		
		updated.setDbeg(dbeg);
		updated.setDend(dend);
		updated.setPrice(price);
		updated.setWare(ware);
		repository.save(updated);
	}

	@Override
	public void deletePriceWare(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<PriceWare> findAll() {
		return repository.findAll();
	}
	

	

}


