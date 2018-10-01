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
@Table (name="dept")
public class Dept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_Sequence")
	@SequenceGenerator(name = "dept_Sequence", sequenceName = "Dept_SEQ")
	private Integer id;

	@Column (name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "parent_id", nullable = false)
	private Dept  dept ;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  Dept getdept() {
		return dept;
	}

	public void setdept(Dept dept) {
		this.dept = dept;
	}


}