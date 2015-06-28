package com.sunny.entity101;

// default package



/**
 * Student100 entity. @author MyEclipse Persistence Tools
 */

public class Student100  implements java.io.Serializable {


    // Fields    

     private Integer sno;
     private String name;


    // Constructors

    /** default constructor */
    public Student100() {
    }

	/** minimal constructor */
    public Student100(Integer sno) {
        this.sno = sno;
    }
    
    /** full constructor */
    public Student100(Integer sno, String name) {
        this.sno = sno;
        this.name = name;
    }

   
    // Property accessors

    public Integer getSno() {
        return this.sno;
    }
    
    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}