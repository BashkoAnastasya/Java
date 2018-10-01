package com.programmer.gate.domain;

import java.math.BigDecimal;

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
@Table (name="supply_str")
public class SupplyStr {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplyStr_Sequence")
	@SequenceGenerator(name = "supplyStr_Sequence", sequenceName = "SUPPLYSTR_SEQ")
	private Integer id;

	@Column(name = "qty")
	private Integer qty;

	@Column(name = "num")
	private String num;

	@Column (name="price")
	private BigDecimal price;

	@Column (name="summa")
	private BigDecimal summa;	

	@Column (name="nds")
	private BigDecimal nds;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "supply_id", nullable = false)
	private Supply supply;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ware_id", nullable = false)
	private Ware ware;
	
	public SupplyStr () {
		
	}
	
	public SupplyStr (String num, BigDecimal price, Integer qty, Ware ware,Supply supply) {
		this.num=num;
		this.price=price;
		this.qty=qty;
		this.supply=supply;
		this.ware=ware;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum (String num) {
		this.num=num;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price=price;
	}

	public Number getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty=qty;
	}

	public Supply getSupply() {
		return supply;		
	}
	public void setSupply(Supply supply) {
		this.supply=supply;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware=ware;		
	}

	public BigDecimal getSumma() {
		return summa;		
	}

	public BigDecimal getNds() {
		return nds;		
	}


}


