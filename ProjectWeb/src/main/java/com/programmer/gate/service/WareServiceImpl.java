package com.programmer.gate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.gate.domain.Models;
import com.programmer.gate.domain.Ware;
import com.programmer.gate.repos.WareRepo;

@Service
public class WareServiceImpl implements WareService{
	
	private WareRepo repository;
	@Autowired
	public void setProductRepository(WareRepo repository) {
		this.repository = repository;
	}

	@Override
	public Ware getWareById(Integer id) {
		
		return repository.findById(id).orElse(new Ware());
	}

	@Override
	public void saveWare(Ware ware) {
		repository.save(ware);		
	}

	@Override
	public void updateWare(Integer id, Models models, String moniker, String name, String szOrig, String szRus) {
	 Ware ware = repository.findById(id).orElse(new Ware());
	 ware.setModel(models);
	 ware.setMoniker(moniker);
	 ware.setName(name);
	 ware.setSzOrig(szOrig);
	 ware.setSzRus(szRus);
	 repository.save(ware);		
	}

	@Override
	public void deleteWare(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public List<Ware> findAll() {		
		return repository.findAll();
	}

}
