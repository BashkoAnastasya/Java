package com.programmer.gate.service;
import com.programmer.gate.domain.RestHist;

import java.util.Date;
import java.util.List;

public interface RestHistService {

	List<RestHist> findAll();	
	List <RestHist> filter(String wareName,Date dbeg, Date dend);
	
	}


