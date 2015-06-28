package com.sunny.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity202.Course200;
import com.sunny.entity202.SC;
import com.sunny.entity202.Student200;

//对多对，中间表有其他字段
public class Demo202 {
	public static void main(String[] args) {
		fun2();
	}
	//删除数据
	public static void fun2(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction trans  = session.beginTransaction();
		Student200 stu = (Student200)session.get(Student200.class, 1);
		Set set = stu.getSCs();
		for(Object o: set){
			session.delete(o);
		}
		session.delete(stu);
		trans.commit();
		session.close();
	}
	//插入数据
	public static void fun1(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction trans  = session.beginTransaction();
		Student200 stu = new Student200();
		stu.setName("apache");
		Course200 c  = new Course200();
		c.setName("java");
		SC sc = new SC();
		sc.setCourse200(c);
		sc.setStudent200(stu);
		sc.setScore(99);
		session.save(stu);
		session.save(c);
		session.save(sc);
		trans.commit();
		session.close();
	}
}
