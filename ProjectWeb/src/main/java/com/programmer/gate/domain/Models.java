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
@Table (name="model")
public class Models {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_Sequence")
	@SequenceGenerator(name = "model_Sequence", sequenceName = "MODEL_SEQ")
	private Integer id;

	@Column (name = "moniker")
	private String moniker;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "grp")
	private String grp;
	
	@Column (name = "subgrp")
	private String subgrp;
	
	@Column (name = "label")
	private String label;
	
	@Column (name = "price")
	private Double price;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "ctl_Node_id", nullable = false)
	private CtlNode ctlNode;
	
	
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

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getSubgrp() {
		return subgrp;
	}

	public void setSubgrp(String subgrp) {
		this.subgrp = subgrp;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getPrice() {
		return price;
	}


	public CtlNode getCtlNode() {
		return ctlNode;
	}

	public void setCtlNode(CtlNode ctlNode) {
		this.ctlNode = ctlNode;
	}

	
}
