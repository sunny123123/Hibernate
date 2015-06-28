package com.sunny.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity100.Class100;
import com.sunny.entity100.Student100;
//双边的一对多，多对一实例
public class Demo100 {
public static void main(String[] args) {
	fun4();
}
//删除
public static void fun6(){
	
}
//利用班级给班级的学生填充数据
public static void fun5(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Class100 c = new Class100();
	c.setName("三年三班");
	Set<Student100 > students = new HashSet<Student100>();
	Student100 stu = new Student100();
	stu.setName("Jack");
	students.add(stu);
	c.setStudents(students);
	session.save(stu);
	session.save(c);
	session.getTransaction().commit();
}
//fetch的使用
public static void fun4(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	//如果使用了fetch，那么对象拥有者一定要出现在select之后，不然报错，这里要不要fetch都可以好像，有疑问的这里？？？？？
	Query query = session.createQuery("select c,c.name,s.name from Class100 c left join fetch c.students s");
	//Query query = session.createQuery("from Student100 s");
	List<Object[]> ss = query.list();
	for(Object[] s : ss){
		System.out.println(s[1]+" "+s[2]);
	}
}
public static void fun3(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	//Query query = session.createQuery("from Class100 c left join fetch c.students");
	
	Query query = session.createQuery("from Class100 c");
	List<Class100> cs = query.list();
	for(Class100 c : cs){
		System.out.println(c.getStudents());
	}
}
//查询
public static void fun2(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Query query = session.createQuery("from Student100");
	List<Student100> list = query.list();
	for(Student100 stu:list){
		System.out.println(stu.getClass100().getName());
	}
}
//插入数据，Class维护关系时
public static void fun1_1(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Student100 s1 = new Student100();
	s1.setName("apache");
	Class100 c = new Class100();
	c.setName("三年二班");
	//s1.setClass100(c);
	c.getStudents().add(s1);//Class维护关系
	session.save(s1);
	session.save(c);
	session.getTransaction().commit();
	session.close();	
}
//插入数据，Student维护关系时
public static void fun1(){
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	Student100 s1 = new Student100();
	Class100 c = new Class100();
	c.setName("三年二班");
	s1.setName("apache");
	s1.setClass100(c);//默认是多方维护关系，既关系由Student来维护
	session.save(c);
	session.save(s1); 
	session.getTransaction().commit();
	session.close();	
}
public static void initCreateTable(){
	Configuration cfg = new Configuration().configure();
	//SessionFactory sf=new Configuration().configure().buildSessionFactory();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
