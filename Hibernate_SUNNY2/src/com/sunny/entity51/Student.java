package com.sunny.entity51;



/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer studentId;
     private String studentName;
     private Card card;


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(String studentName, Card card) {
        this.studentName = studentName;
        this.card = card;
    }

   
    // Property accessors

    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Card getCard() {
        return this.card;
    }
    
    public void setCard(Card card) {
        this.card = card;
    }
   
}