package com.model;

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
	
		// PART 1
		/* Criteria is the replacement of HQL and Complete Java end Query language*/
		Criteria criteria = session.createCriteria(Instructor.class); // this gives us "select * from Instructor" result
		criteria.add(Restrictions.like("name","%esh")); // this gives us all records where name ends with esh
		// Restrictions are act like where clause
		
		List<Instructor> list = criteria.list();
		System.out.println(list.size());
		
		
		// PART 2
		criteria.add(Restrictions.like("name","%esh"))
				.add(Restrictions.eq("id",10)); 
		// sql select * from Instructor where name like '%esh' and id = 10;
		// we can add as many as .add(Restrictions)
		
		list = criteria.list();
		System.out.println(list.size());
		
		
		t.commit();
		session.close();
		System.out.println("All done");
		
		
	}
}
