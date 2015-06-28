package com.sunny.entity201;

import java.util.HashSet;
import java.util.Set;

/**
 * Student200 entity. @author MyEclipse Persistence Tools
 */

public class Student200 implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private String name;
	private Set SCs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student200() {
	}

	/** full constructor */
	public Student200(String name, Set SCs) {
		this.name = name;
		this.SCs = SCs;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSCs() {
		return this.SCs;
	}

	public void setSCs(Set SCs) {
		this.SCs = SCs;
	}

}