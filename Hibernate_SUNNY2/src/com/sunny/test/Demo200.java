package com.sunny.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity102.Class100;
import com.sunny.entity102.Student100;
import com.sunny.entity200.Course200;
import com.sunny.entity200.Student200;
//多对多配置，中间表中没有其他字段
public class Demo200 {
public static void main(String[] args) {
	fun4();
}
//删除数据
public static void fun4(){
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	Course200 c = (Course200)session.get(Course200.class, 2);
	session.delete(c);
	trans.commit();
	session.close();
}
//更行数据
public static void fun3(){
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	Course200 c = (Course200)session.get(Course200.class, 1);
	c.setName("PHP");
	session.save(c);
	trans.commit();
	session.close();
}
//查询数据
public static void fun2(){
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Query query = session.createQuery("select s,s.name,c.name from Student200 s left join fetch s.courses c");
	List<Object[]> list = query.list();
	for(Object[] o : list){
		System.out.println(o[1]+" "+o[2]);
	}
}
//插入数据
public static void fun1(){
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	Student200 stu = new Student200();
	stu.setName("tomcat");
	Course200 c1 = new Course200();
	c1.setName("c++");
	stu.getCourses().add(c1);
	Course200 c2 = new Course200();
	c2.setName("java");
	stu.getCourses().add(c2);
	session.save(stu);
	session.save(c1);
	session.save(c2);
	trans.commit();
	session.close();
}
public static void initCreateTable(){
	Configuration cfg = new Configuration().configure();
	//SessionFactory sf=new Configuration().configure().buildSessionFactory();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
