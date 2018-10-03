package com.p2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.p1.Employee;

public class ReadValues {
	public static void main(String[] args) {
		
		
		// 1 Connection
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		System.out.println(" --- Step 1 "+factory);
		Session session = factory.openSession();
		
		
		Employee e = (Employee)session.get(Employee.class,4);
		System.out.println(e);
		
		session.close();
		System.out.println(" --- Step 5 Session Close ");
	
	}
}








