package com.programmer.gate.repos;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.programmer.gate.domain.Client;



public interface ClientRepo extends CrudRepository<Client, Integer> {
   
	List<Client> findByName(String name);
	List<Client> findAll();
	Optional<Client> findById(Integer id);
	/**

	 * Filtering Client

	 */	
	@Query("select c from Client c where c.name like %?1% and c.moniker like %?2% and c.isVip like %?3% and c.town like %?4%" )
	List <Client> filter(String name,String moniker,String isVip, String town);

}