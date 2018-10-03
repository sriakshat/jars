package com.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainRunner {

	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		Transaction t = session.getTransaction();
		t.begin();
	
		//Query q = session.createQuery("from Instructor where id = :sid and name = :sname");
		Query q = session.getNamedQuery("getInstructor_byID");
		q.setInteger(0,10);
		
		
		List<Instructor> instructors =  q.list();
		
		System.out.println(instructors.size());
		System.out.println("All done");
		
		t.commit();
		session.close();
		
		
	}
}
