package com.programmer.gate.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_Sequence")
	@SequenceGenerator(name = "supplier_Sequence", sequenceName = "SUPPLIER_SEQ")
	private Integer id;

	@Column(name = "moniker")
	private String moniker;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "supplier")
	private List<Supply> supplys;

	public Supplier() {
	}

	public Supplier(String name, String moniker) {
		this.name = name;
		this.moniker = moniker;
	}

	public Supplier(String name) {
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

	public List<Supply> getSupplys() {
		return supplys;
	}

}