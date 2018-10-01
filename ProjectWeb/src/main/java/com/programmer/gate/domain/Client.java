package com.programmer.gate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_Sequence")
	@SequenceGenerator(name = "client_Sequence", sequenceName = "client_SEQ")
	private Integer id;

	@Column(name = "moniker")
	private String moniker;

	@Column(name = "name")
	private String name;	

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "dept_id", nullable = false)
	private Dept dept;
	
	@Column(name = "is_Vip")
	private String isVip;
	
	@Column(name = "town")
	private String town;
	
	public Client() {
		
	}

	public Client(String name, String moniker, Dept dept,String isVip, String town ) {		
		this.name = name;
		this.moniker = moniker;
		this.dept=dept;
		this.isVip=isVip;
		this.town=town;
	}

	public Client(String name) {
		this.name = name;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
			}

	public String getMoniker() {
		return moniker;
	}
	
	public void setMoniker(String moniker) {
		this.moniker = moniker;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}	

	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}


}