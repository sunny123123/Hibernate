package com.sunny.entity51;



/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card  implements java.io.Serializable {


    // Fields    

     private Integer studentId;
     private Student student;
     private String cardNum;


    // Constructors

    /** default constructor */
    public Card() {
    }

	/** minimal constructor */
    public Card(Student student) {
        this.student = student;
    }
    
    /** full constructor */
    public Card(Student student, String cardNum) {
        this.student = student;
        this.cardNum = cardNum;
    }

   
    // Property accessors

    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCardNum() {
        return this.cardNum;
    }
    
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
   








}