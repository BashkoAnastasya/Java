package com.programmer.gate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table (name="state")
public class State {
	
	@Id
	private Integer id;
	
	@Column (name="state")
	private String state;
	
	public Integer getId() {
		return id;
	}
	
	public String getState() {
		return state;
	}

}
