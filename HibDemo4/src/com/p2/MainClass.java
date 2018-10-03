package com.p2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.p1.Employee;

public class MainClass {

	public static void main(String[] args) {
		
		// 1 Connection
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		System.out.println(" --- Step 1 "+factory);
		// 2. Load Hibernate 
		Session session = factory.openSession();
		System.out.println(" --- Step 2 "+session);
		// 3. Create Domain Object 
		 
		Employee e = new Employee(102,"Suresh","Noida",2000);
		
		 
		 // 4. Pass Object to Hibernate 
		Transaction t = session.getTransaction();
		t.begin();
		session.save(e);
		e.setLocation("New York");
		System.out.println(" --- Step 3 data Saved");
		t.commit();
		
		
		System.out.println(" --- Step 4 After Commit");
		// 5. Close Hibernate
		
		session.close();
		System.out.println(" --- Step 5 Session Close ");
	
	
	}//end main
}//end class













