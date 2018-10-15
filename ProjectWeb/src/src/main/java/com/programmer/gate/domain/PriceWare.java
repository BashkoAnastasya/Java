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
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table (name="price_ware")
public class PriceWare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceWare_Sequence")
	@SequenceGenerator(name = "priceWare_Sequence", sequenceName = "PRICEWARE_SEQ")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ware_id", nullable = false)
	private Ware ware;
	
	@Column (name="dbeg")
	private Date dbeg;
	
	@Column (name="dend")
	private Date dend;
	
	@Column (name="price")
	private BigDecimal price;	
	
	public PriceWare() {		
	
	}
	
	public PriceWare(Date dbeg, Date dend,BigDecimal price, Ware ware) {
		this.dbeg=dbeg;
		this.dend=dend;
		this.price=price;
		this.ware=ware;	
	}

	public Integer getId() {
		return id;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
