package com.programmer.gate.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Ware;

public interface WareRepo extends CrudRepository<Ware, Integer> {
	
	   List<Ware> findAll();
	   
}
