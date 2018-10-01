
package com.programmer.gate.domain;

import java.util.*;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="supply")
public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supply_Sequence")
	@SequenceGenerator(name = "supply_Sequence", sequenceName = "SUPPLY_SEQ")
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "num")
	private String num;
	
	@Column (name="dt")
	private Date dt;
	
	@Column (name="summa")
	private BigDecimal summa;
	
	@Column (name="nds")
	private BigDecimal nds;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "state_id", nullable = false)
	private State state;


	public Supply() {
	}

	public Supply(String code, String num,Supplier supplier,Date dt, State state) {
		this.code = code;
		this.state=state;
		this.dt=dt;
	    this.supplier=supplier;
		this.num = num;		
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code=code;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier=supplier;		
	}
	public Date getDt() {
		return dt;
	}

	public void setDt (Date dt) {
		this.dt=dt;
	}

	public State getState() {
		return state;
	}

	public void setState (State state) {
		this.state=state;
	}

	public BigDecimal getSumma() {
		return summa;
	}

	public BigDecimal getNds() {
		return nds;
	}
	
	
	
}
