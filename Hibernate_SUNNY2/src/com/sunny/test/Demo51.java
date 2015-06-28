package com.sunny.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity51.Card;
import com.sunny.entity51.Student;

/**
 * 一对一配置、共享主键
 * @author Administrator
 *
 */
public class Demo51 {
public static void main(String[] args) {
	fun1();
}
public static void fun1(){
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans  = session.beginTransaction();
	Student stu = new Student();
	stu.setStudentName("tomcat");
	session.save(stu);
	Card c  = new Card();
	c.setCardNum("123456");
	
	c.setStudent(stu);
	session.save(c);
	
	
	trans.commit();
	
}
}
