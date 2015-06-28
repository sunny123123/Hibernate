package com.sunny.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Demo201 {
	public static void main(String[] args) {
		initCreateTable();
	}
	public static void initCreateTable(){
		Configuration cfg = new Configuration().configure();
		//SessionFactory sf=new Configuration().configure().buildSessionFactory();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true,true);
	}
}
