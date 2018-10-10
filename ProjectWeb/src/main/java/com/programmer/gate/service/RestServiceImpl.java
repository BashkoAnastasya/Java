package com.programmer.gate.service;

import  org.springframework.beans.factory.annotation.Autowired;
import  com.programmer.gate.domain.Rest;

import  org.springframework.stereotype.Service;
import  com.programmer.gate.repos.RestRepo;

import  java.util.List;

@Service
public class RestServiceImpl implements RestService{

	private RestRepo repository;

	@Autowired
	public void setProductRepository(RestRepo repository) {
		this.repository = repository;
	}

	@Override
	public List<Rest> findAll() {
		return repository.findAll();
	}
		
	@Override
	public List <Rest> filter(String ware)
	{	
		return   repository.filter(ware);
	}
	
	

}


