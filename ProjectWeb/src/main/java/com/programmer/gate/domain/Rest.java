package com.programmer.gate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name="rest")
public class Rest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rest_Sequence")
	@SequenceGenerator(name = "rest_Sequence", sequenceName = "rest_SEQ")
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ware_id", nullable = false)
	private Ware ware;
	
	@Column(name = "qty")
	private Number qty;	

	public Rest() {
		
	}	

	public Integer getId() {
		return id;
	}

	public Ware getWare() {
		return ware;
	}

	public Number getQty() {
		return qty;
	}

	

}