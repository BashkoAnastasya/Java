
package com.programmer.gate.domain;

import java.math.BigDecimal;
import java.util.*;

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
@Table (name="sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_Sequence")
	@SequenceGenerator(name = "sale_Sequence", sequenceName = "sale_SEQ")
	private Integer id;

	@Column(name = "num")
	private String num;
	
	@Column (name="dt")
	private Date dt;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "state_id", nullable = false)
	private State state;

	@Column (name="summa")
	private BigDecimal summa;
	
	@Column (name="nds")
	private BigDecimal nds;
	
	@Column (name="discount")
	private BigDecimal discount;
	

	public Sale() {
	}

	public Sale(String code, String num,Client client,Date dt, State state, BigDecimal discount) {		
		this.state=state;
		this.dt=dt;
	    this.client=client;
		this.num = num;		
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

	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client=client;		
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


	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	
	
}
