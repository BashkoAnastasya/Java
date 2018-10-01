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
@Table (name="ware")
public class Ware {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ware_Sequence")
	@SequenceGenerator(name = "ware_Sequence", sequenceName = "WARE_SEQ")
	private Integer id;

	@Column(name = "moniker")
	private String moniker;

	@Column (name="name")
	private String name;

	@Column (name="sz_orig")
	private String szOrig;

	@Column (name="sz_rus")
	private String szRus;

	@Column (name="price")
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "model_id", nullable = false)
	private Models model;

	public Ware() {
		
	}	

	public Ware(Models model,String moniker, String name, String szOrig, String szRus) {
	    
		this.model=model;
		this.moniker = moniker;
		this.name = name;
		this.szOrig = szOrig;
		this.szRus = szRus;		
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

	public String getSzOrig() {
		return szOrig;
	}

	public void setSzOrig(String szOrig) {
		this.szOrig = szOrig;
	}

	public String getSzRus() {
		return szRus;
	}

	public void setSzRus(String szRus) {
		this.szRus = szRus;
	}

	public Double getPrice() {
		return price;
	}


	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
		this.model = model;
	}

}
