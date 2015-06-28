package com.sunny.entity50;

import java.util.HashSet;
import java.util.Set;

/**
 * Clazz entity. @author MyEclipse Persistence Tools
 */

public class Clazz implements java.io.Serializable {

	// Fields

	private Integer classId;
	private String className;
	private Monitor monitor;

	// Constructors

	/** default constructor */
	public Clazz() {
	}

	/** full constructor */

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public Clazz(String className, Monitor monitor) {
		this.className = className;
		this.monitor = monitor;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

}