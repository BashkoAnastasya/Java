package com.programmer.gate.service;
import com.programmer.gate.domain.Supplier;
import com.programmer.gate.domain.Supply;
import com.programmer.gate.domain.State;

import java.util.Date;
import java.util.List;

public interface SupplyService {
	
	   Supply getSupplyById(Integer id);
	   void saveSupply(Supply supply);
	   void updateSupply(Integer id, String num, String code, Date dt,Supplier supplier,State state);
	   void deleteSupply (Integer id);
	   List<Supply> findAll();

}
