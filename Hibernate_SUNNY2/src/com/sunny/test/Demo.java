package com.sunny.test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateUtil;
import com.sunny.entity.Student;

//数据更新时候fun6、fun7都更新了整行的 数据，在配置文件中 加dynamic-update="true"
public class Demo {
public static void main(String[] args) {
	fun7();
}
/**
 * 更新数据
 * 
 */
public static void fun7(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction trans =  session.beginTransaction();
	Student stu = (Student)session.get(Student.class, 1);
	stu.setName("apache");
	session.save(stu);
	trans.commit();
}
/**
 * 更新数据
 * 以下方式不同于fun5（），没有set的字段不会为null，但是会整行记录更新
 */
public static void fun6(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction trans =  session.beginTransaction();
	Student stu = (Student)session.get(Student.class, 1);
	stu.setName("tomcat");
	session.update(stu);
	trans.commit();
}
/**
 * 更新数据
 * 1、新建一个对象的id在表中存在好话，通过new一个对象，就可以更新，如果有的字段没有用set方法，将改字段跟新为null
 */
public static void fun5(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction trans =  session.beginTransaction();
	Student stu = new Student();//没有对address用set方法，那么address将变为null
	stu.setSno(1);
	stu.setName("apache");
	session.update(stu);
	trans.commit();
}
//查询数据
public static void fun4(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Query query = session.createQuery("select s.name from Student s where sno = ?");
	
	query.setInteger(0, 1);
	List<String> stus = query.list();
	for (String name : stus) {
		System.out.println(name);
	}
}
//查询数据
public static void fun3(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Query query = session.createQuery("from Student  where sno = ?");
	query.setInteger(0, 1);
	List<Student> stus = query.list();
	for (Student stu : stus) {
		System.out.println(stu);
	}
}
//向表中插入数据，要开启事务
public static void fun2(){
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	Transaction trans =  session.beginTransaction();
	Student stu = new Student();
	stu.setName("tomcat");
	stu.setAddress("nanjing");
	session.save(stu);
	System.out.println(stu.getSno());
	trans.commit();
	session.close();
}
//根据模型，自动生成表，注意，配置文件出错，这里不检查的
public static void init(){
	Configuration cfg = new Configuration().configure();
	//SessionFactory sf=new Configuration().configure().buildSessionFactory();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
