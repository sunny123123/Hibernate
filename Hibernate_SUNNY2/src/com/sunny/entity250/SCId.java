package com.sunny.entity250;

/**
 * SCId entity. @author MyEclipse Persistence Tools
 */

public class SCId implements java.io.Serializable {

	// Fields

	private Student200 student200;
	private Course200 course200;

	// Constructors

	/** default constructor */
	public SCId() {
	}

	/** full constructor */
	public SCId(Student200 student200, Course200 course200) {
		this.student200 = student200;
		this.course200 = course200;
	}

	// Property accessors

	public Student200 getStudent200() {
		return this.student200;
	}

	public void setStudent200(Student200 student200) {
		this.student200 = student200;
	}

	public Course200 getCourse200() {
		return this.course200;
	}

	public void setCourse200(Course200 course200) {
		this.course200 = course200;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SCId))
			return false;
		SCId castOther = (SCId) other;

		return ((this.getStudent200() == castOther.getStudent200()) || (this
				.getStudent200() != null
				&& castOther.getStudent200() != null && this.getStudent200()
				.equals(castOther.getStudent200())))
				&& ((this.getCourse200() == castOther.getCourse200()) || (this
						.getCourse200() != null
						&& castOther.getCourse200() != null && this
						.getCourse200().equals(castOther.getCourse200())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudent200() == null ? 0 : this.getStudent200()
						.hashCode());
		result = 37 * result
				+ (getCourse200() == null ? 0 : this.getCourse200().hashCode());
		return result;
	}

}