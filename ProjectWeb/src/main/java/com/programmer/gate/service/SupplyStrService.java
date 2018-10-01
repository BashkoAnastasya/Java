package com.programmer.gate.service;

import java.math.BigDecimal;
import java.util.List;

import com.programmer.gate.domain.Supply;
import com.programmer.gate.domain.SupplyStr;
import com.programmer.gate.domain.Ware;

public interface SupplyStrService {
	SupplyStr getSupplyStrById(Integer id);
	   void saveSupplyStr(SupplyStr supplyStr);
	   void updateSupplyStr(Integer id, String num, BigDecimal price, Integer qty, Ware ware,Supply supply);
	   void deleteSupplyStr (Integer id);
	   List<SupplyStr> findAll();
}
