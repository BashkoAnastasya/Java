package com.programmer.gate.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.domain.Ware;

public interface WareRepo extends CrudRepository<Ware, Integer> {
	
	   List<Ware> findAll();
		/**

		 * Filtering Client

		 */	
		@Query("select c from Ware c where c.name like %?1% and c.moniker like %?2% and c.szOrig like %?3% and c.szRus like %?4% " )
		List <Ware> filter(String name,String moniker, String szOrig,  String szRus );
		
	   
}
