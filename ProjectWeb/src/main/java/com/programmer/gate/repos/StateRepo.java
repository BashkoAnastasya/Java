package com.programmer.gate.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.State;


public interface StateRepo extends CrudRepository<State, Integer>{	
	List<State> findAll();	
 
}
