package com.programmer.gate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="rest_hist")
public class RestHist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restHist_Sequence")
	@SequenceGenerator(name = "restHist_Sequence", sequenceName = "RESTHIST_SEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ware_id", nullable = false)
	private Ware ware;
	
	
	@Column(name = "dbeg")
	private Date dbeg;	
	
	@Column(name = "dend")
	private Date dend;	
	
	@Column(name = "qty")
	private Integer qty;	

	public RestHist() {
		
	}

	public Integer getId() {
		return id;
	}

	public Ware getWare() {
		return ware;
	}

	public Date getDbeg() {
		return dbeg;
	}

	public Date getDend() {
		return dend;
	}

	public Number getQty() {
		return qty;
	}


	

}