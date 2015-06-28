package com.sunny.entity202;



/**
 * SC entity. @author MyEclipse Persistence Tools
 */

public class SC  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Student200 student200;
     private Course200 course200;
     private Integer score;


    // Constructors

    /** default constructor */
    public SC() {
    }

	/** minimal constructor */
    public SC(Student200 student200, Course200 course200) {
        this.student200 = student200;
        this.course200 = course200;
    }
    
    /** full constructor */
    public SC(Student200 student200, Course200 course200, Integer score) {
        this.student200 = student200;
        this.course200 = course200;
        this.score = score;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
   








}