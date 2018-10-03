package com.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainProjectClass {

	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.getTransaction();
		t.begin();
		


		
		Project p = new Project();
		p.setClientName("ICICI");
		p.setHeadCount(10);
		p.setProjectName("Web Integration");
		p.setProjectid(2010);
		
		Project p4 = new Project();
		p4.setClientName("LIC");
		p4.setHeadCount(29);
		p4.setProjectName("pension plan");
		p4.setProjectid(2012);
		
		
		session.save(p);
		session.save(p4);
		
		System.out.println(" Project "+p+"Data Saved");
		
		
		t.commit(); // object of project is in persistent state
		session.close();  // All object get detached
		
		
	}
}
