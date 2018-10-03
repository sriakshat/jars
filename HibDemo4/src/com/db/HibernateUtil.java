package com.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Session getHibernateSession()
	{
		// 1 Connection
				Configuration cfg = new AnnotationConfiguration();
				SessionFactory factory = cfg.configure().buildSessionFactory();
				System.out.println(" --- Step 1 "+factory);
				// 2. Load Hibernate 
				Session session = factory.openSession();
				
				return session;
	}
}
