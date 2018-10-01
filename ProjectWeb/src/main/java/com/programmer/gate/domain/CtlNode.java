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
@Table (name="ctl_node")
public class CtlNode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ctlNode_Sequence")
	@SequenceGenerator(name = "ctlNode_Sequence", sequenceName = "CTLNODE_SEQ")
	private Integer id;

	@Column (name = "code")
	private String code;

	@Column (name="tree_code")
	private String treeCode;

	@Column (name="name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "parent_id", nullable = false)
	private CtlNode ctlNode;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CtlNode getCtlNode() {
		return ctlNode;
	}

	public void setCtlNode(CtlNode ctlNode) {
		this.ctlNode = ctlNode;
	}


}