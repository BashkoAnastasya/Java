package com.programmer.gate.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="sale_str")
public class SaleStr {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleStr_Sequence")
	@SequenceGenerator(name = "saleStr_Sequence", sequenceName = "saleSTR_SEQ")
	private Integer id;

	@Column(name = "qty")
	private Integer qty;

	@Column(name = "num")
	private String num;

	@Column (name="price")
	private BigDecimal price;
	
	@Column (name="disc_price")
	private BigDecimal disc_price;

	@Column (name="summa")
	private BigDecimal summa;	

	@Column (name="nds")
	private BigDecimal nds;	
	

	@Column (name="discount")
	private BigDecimal discount;


	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "sale_id", nullable = false)
	private Sale sale;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ware_id", nullable = false)
	private Ware ware;
	
	public SaleStr () {
		
	}
	
	public SaleStr (String num, Integer qty, Ware ware,Sale sale,BigDecimal discount) {
		this.num=num;
		this.qty=qty;
		this.sale=sale;
		this.ware=ware;
		this.discount=discount;
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

	public Number getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty=qty;
	}

	public Sale getSale() {
		return sale;		
	}
	public void setSale(Sale sale) {
		this.sale=sale;
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
	
	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDisc_price() {
		return disc_price;
	}

}


