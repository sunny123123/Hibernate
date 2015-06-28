package com.sunny.entity250;

/**
 * SC entity. @author MyEclipse Persistence Tools
 */

public class SC implements java.io.Serializable {

	// Fields

	private SCId id;
	private Integer score;

	// Constructors

	/** default constructor */
	public SC() {
	}

	/** minimal constructor */
	public SC(SCId id) {
		this.id = id;
	}

	/** full constructor */
	public SC(SCId id, Integer score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public SCId getId() {
		return this.id;
	}

	public void setId(SCId id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}