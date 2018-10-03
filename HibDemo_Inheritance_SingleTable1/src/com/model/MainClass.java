package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		Transaction t = session.getTransaction();
		t.begin();
	
		Car c = new Car("Maruti");
		session.save(c);
		
		SportsCar sc = new SportsCar("Farari");
		sc.setSpeed("200");
		session.save(sc);
		
		HatchBack hb = new HatchBack("Hyndai");
		hb.setSpace("5");
		session.save(hb);
		
		t.commit();
		session.close();
		
		System.out.println("Data Saved ");
	}
}
