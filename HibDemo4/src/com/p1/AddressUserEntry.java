package com.p1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateUtil;

public class AddressUserEntry {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getHibernateSession();
		Transaction t = session.getTransaction();
		t.begin();
		
		Address a = new Address("New Delhi","Delhi");
		session.save(a);
		
		t.commit();
		session.evict(a);
	}
}







