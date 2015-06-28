package com.sunny.entity50;

/**
 * Monitor entity. @author MyEclipse Persistence Tools
 */

public class Monitor implements java.io.Serializable {

	// Fields

	private Integer monitorId;
	private Clazz clazz;
	private String monitorName;

	// Constructors

	/** default constructor */
	public Monitor() {
	}

	/** full constructor */
	public Monitor(Clazz clazz, String monitorName) {
		this.clazz = clazz;
		this.monitorName = monitorName;
	}

	// Property accessors

	public Integer getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}

	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getMonitorName() {
		return this.monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
}