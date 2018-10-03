package com.model;

import java.util.ArrayList;
import java.util.List;

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
	
		Instructor i1 = new Instructor("Ramesh", "ramesh@gmail.com");
		Laptop l1 = new Laptop("HP-1");
		Laptop l2 = new Laptop("HP-2");
		List<Laptop> lapList1 = new ArrayList<Laptop>();
		lapList1.add(l1);
		lapList1.add(l2);
		i1.setLaptopList(lapList1);
		
		
		/*List<String> strList = new ArrayList<String>();
		strList.add("Java");
		strList.add("Java-2");
		strList.add("Java-3");
		
		i1.setSubjects(strList);
		*/		
		session.save(i1);
				
		t.commit();
		session.close();
		System.out.println("All done");
		
		
	}
}
