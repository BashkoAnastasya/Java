package com.programmer.gate.service;

import  org.springframework.beans.factory.annotation.Autowired;

import  com.programmer.gate.domain.Supplier;
import  org.springframework.stereotype.Service;
import  com.programmer.gate.repos.SupplierRepo;
import  java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{

	private SupplierRepo repository;

	@Autowired
	public void setProductRepository(SupplierRepo repository) {
		this.repository = repository;
	}

	@Override
	public Supplier getSupplierById(Integer id) {
		return repository.findById(id).orElse(new Supplier()); 
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		repository.save(supplier);
	}

	@Override
	public void updateSupplier (Integer id, String name,String moniker) {
		Supplier updated = repository.findById(id).orElse(new Supplier());     
		updated.setName(name);
		updated.setMoniker(moniker);
		repository.save(updated);
	}

	@Override
	public void deleteSupplier(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Supplier> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Supplier> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<Supplier> filter(String filterName,String filterMoniker) {
	       List<Supplier> suppliers;
	     

	        if (filterName != null && !filterName.isEmpty()) {
	        	suppliers = repository.findAll();
	        } else {
	        	suppliers = repository.findAll();
	        }
				
		return  suppliers;
	}
	
	@Override	
 public List<Supplier>  findByNameAndMoniker(String name,String moniker){
	 return repository.findByNameAndMoniker(name,moniker);
 }
 }




