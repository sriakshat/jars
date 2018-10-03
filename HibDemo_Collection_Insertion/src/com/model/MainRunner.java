package com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MainRunner {

	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		Transaction t = session.getTransaction();
		t.begin();
	
		Address a1 = new Address("ABC-1", "New Delhi","Delhi");
		Address a2 = new Address("ABC-2", "New Delhi","Delhi");
		Address a3 = new Address("ABC-3", "New Delhi","Delhi");
		
		Set<Address> addresses = new HashSet<Address>(); 
		
		addresses.add(a1);
		addresses.add(a2);
		addresses.add(a3);
		
		Instructor i1 = new Instructor("Ramesh", "ramesh@gmail.com");
		i1.setAddresses(addresses);
		
		session.save(i1);
		
		t.commit();
		session.close();
		System.out.println("All done");
		
		
	}
}
