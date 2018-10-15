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

import java.util.*;

@Entity
@Table (name="price_model")
public class PriceModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceModel_Sequence")
	@SequenceGenerator(name = "priceModel_Sequence", sequenceName = "PRICEMODEL_SEQ")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "model_id", nullable = false)
	private Models models;
	
	@Column (name="dbeg")
	private Date dbeg;
	
	@Column (name="dend")
	private Date dend;
	
	@Column (name="price")
	private Double price;
	
	public Models getModel() {
		return models;
	}

	public void setModel(Models models) {
		this.models = models;
	}

	public Date getDbeg() {
		return dbeg;
	}

	public void setDbeg(Date dbeg) {
		this.dbeg = dbeg;
	}

	public Date getDend() {
		return dend;
	}

	public void setDend(Date dend) {
		this.dend = dend;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
