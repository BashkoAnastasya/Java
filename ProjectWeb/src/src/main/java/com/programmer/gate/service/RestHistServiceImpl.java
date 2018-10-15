package com.programmer.gate.service;

import  org.springframework.beans.factory.annotation.Autowired;
import  com.programmer.gate.domain.RestHist;

import  org.springframework.stereotype.Service;
import  com.programmer.gate.repos.RestHistRepo;

import java.util.Date;
import  java.util.List;

@Service
public class RestHistServiceImpl implements RestHistService{

	private RestHistRepo repository;

	@Autowired
	public void setProductRepository(RestHistRepo repository) {
		this.repository = repository;
	}

	@Override
	public List<RestHist> findAll() {
		return repository.findAll();
	}

	@Override
	public List<RestHist> filter(String wareName, Date dbeg, Date dend) {
		
		return repository.filter(wareName, dbeg, dend);
	}
		

	

}


