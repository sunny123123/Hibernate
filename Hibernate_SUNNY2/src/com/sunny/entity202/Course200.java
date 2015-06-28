package com.sunny.entity202;

import java.util.HashSet;
import java.util.Set;


/**
 * Course200 entity. @author MyEclipse Persistence Tools
 */

public class Course200  implements java.io.Serializable {


    // Fields    

     private Integer courseId;
     private String name;
     private Set SCs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course200() {
    }

    
    /** full constructor */
    public Course200(String name, Set SCs) {
        this.name = name;
        this.SCs = SCs;
    }

   
    // Property accessors

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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