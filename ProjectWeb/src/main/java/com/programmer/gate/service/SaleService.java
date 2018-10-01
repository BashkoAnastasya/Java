package com.programmer.gate.service;
import com.programmer.gate.domain.Client;
import com.programmer.gate.domain.Sale;
import com.programmer.gate.domain.State;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SaleService {
	
	   Sale getSaleById(Integer id);
	   void saveSale(Sale Sale);
	   void updateSale(Integer id, String num, Date dt,Client client,State state, BigDecimal discount);
	   void deleteSale (Integer id);
	   List<Sale> findAll();
	   
}
