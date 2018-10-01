package com.programmer.gate.repos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.programmer.gate.domain.Client;


public interface ClientRepo extends CrudRepository<Client, Integer> {
   
	List<Client> findByName(String name);
	List<Client> findAll();
	Optional<Client> findById(Integer id);

}