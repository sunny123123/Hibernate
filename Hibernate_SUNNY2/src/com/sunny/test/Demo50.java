package com.sunny.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.sunny.common.HibernateSessionFactory;
import com.sunny.entity50.Clazz;
import com.sunny.entity50.Monitor;

/**
 * 一对一配置,一边是one-to-one，一边是many-to-many，外键方式，共享主键方式见51中配置
 * @author Administrator
 *
 */
public class Demo50 {

	public static void main(String[] args) {
		fun1();
	}
	//删除数据
	public static void fun3(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Clazz c = (Clazz)session.get(Clazz.class,4);
		session.delete(c);
		trans.commit();
		session.close();	
	}
	//查询数据
	public static void fun2(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Clazz c = (Clazz)session.get(Clazz.class,1);
		//Monitor m = (Monitor)session.get(Monitor.class, 1);
		System.out.println(c.getMonitor().getMonitorName());
	}
	public static void fun5(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Clazz c = new Clazz();
		c.setClassName("应用数学");
		session.save(c);
		Monitor m = new Monitor();
		m.setMonitorId(2);
		m.setMonitorName("张攀");
		m.setClazz(c);
		session.save(m);
		trans.commit();
		trans.rollback();//测试地方
		session.close();
		
	}
	//添加数据
	public static void fun1(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		Clazz c = new Clazz();
		c.setClassName("应用数学");
		
		Monitor m = new Monitor();
		m.setMonitorName("张攀");
	//	m.setClazz(c);//关系班长维护了
		//c.getMonitor().setClazz(c);
		c.setMonitor(m);
		session.save(c);
		session.save(m);
		trans.commit();
		
		session.close();
		
	}
	public static void init(){
		Configuration cfg = new Configuration().configure();
		//SessionFactory sf=new Configuration().configure().buildSessionFactory();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true,true);
	}
}
