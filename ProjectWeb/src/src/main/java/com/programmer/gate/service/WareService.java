package com.programmer.gate.service;

import com.programmer.gate.domain.Models;
import com.programmer.gate.domain.Ware;

import java.util.List;

public interface WareService {

	   Ware getWareById(Integer id);
	   void saveWare(Ware ware);
	   void updateWare(Integer id,Models models, String moniker, String name, String szOrig, String szRus);
	   void deleteWare (Integer id);
	   List<Ware> findAll();
	   List <Ware> filter(String name, String moniker, String szOrig,  String szRus );
}
