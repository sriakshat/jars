package com.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyMainClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		System.out.println("------->> 1 "+cfg);
		
		SessionFactory factory = cfg.configure().buildSessionFactory();
		System.out.println("------->> 2 "+factory);
		
		Session session = factory.openSession();
		System.out.println("------>>  3 "+session);
		
		Transaction t = session.getTransaction();
		System.out.println("------>>  4 "+t);
		
		t.begin();
		session.save(new Student("103","Ramesh"));
		t.commit();
		System.out.println("------>>  DB commited ");
		
		session.close();
		System.out.println("------>>  Done ");
	}//end main
}//end class
