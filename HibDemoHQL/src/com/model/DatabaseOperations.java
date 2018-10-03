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

public class DatabaseOperations {

	Session session;

	public DatabaseOperations() {
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		session = fac.openSession();
	}

	public void createData(Instructor instructor) {
		System.out.println(" ------>> " + instructor);
		Transaction t = session.getTransaction();
		t.begin();
		System.out.println(" ------->> " + t);
		session.save(instructor);

		t.commit();
	}

	public List<Course> getCourseByDuration_Pegination_1(int duration) {
		List<Course> courses = null;

		Transaction t = session.getTransaction();
		t.begin();

		String query = "from Course where duration > ?)";
		Query q = session.createQuery(query);
		q.setInteger(0, duration);

		// q.setFetchSize(2); // Not implemented by OracleDriver.
		q.setFirstResult(5);
		q.setMaxResults(3);

		courses = q.list();

		System.out.println(" Result Set Size : " + courses.size());

		t.commit();

		return courses;
	}

	public List<Course> getCourseByDuration(int duration) {
		List<Course> courses = null;

		Transaction t = session.getTransaction();
		t.begin();

		String query = "from Course where duration > ?)";
		Query q = session.createQuery(query);
		q.setInteger(0, duration);

		courses = q.list();

		System.out.println(" Result Set Size : " + courses.size());

		t.commit();

		return courses;
	}

	public List<Instructor> getInstructorByCity_Criteria(String city) {

		List<Instructor> instructors = null;

		Transaction t = session.getTransaction();
		t.begin();

		Criteria criteria = session.createCriteria(Instructor.class);
		criteria.add(Restrictions.eq("presentAddress.city", city));
		/* 
		  like 
		  isNull
		  Null
		  between
		  isNotNull
		  gt  : greter than only
		  le : less than and equal
		  ge
		  between
		 */
		instructors = criteria.list();

		System.out.println(" Result Set Size : " + instructors.size());
		
		t.commit();
		return instructors;
	}


	public List<Instructor> getInstructorByCity_Criteria_2States(String state1,String state2) {

		List<Instructor> instructors = null;

		Transaction t = session.getTransaction();
		t.begin();

		Criteria criteria = session.createCriteria(Instructor.class);
		criteria.add(Restrictions.eq("presentAddress.state", state1));
		criteria.add(Restrictions.eq("permanentAddress.state", state2));
		

		instructors = criteria.list();

		System.out.println(" Result Set Size : " + instructors.size());
		
		t.commit();
		return instructors;
	}

	public List<Instructor> getInstructorByCourse(String course) {
		List<Instructor> instructors = null;

		Transaction t = session.getTransaction();
		t.begin();

		/*
		  select * from instructor 
		  where instructor.id in (select
		  course.instructorinfo from course where course.coursename like
		  '%React%');
		  
		 */

		String query = 
"from Instructor where id in (select instructor from Course where courseName = ?)";
		Query q = session.createQuery(query);
		q.setString(0, course);

		instructors = q.list();

		System.out.println(" Result Set Size : " + instructors.size());

		t.commit();

		return instructors;
	}

	public List<Instructor> getInstructorByNameandId(String name, int id) {
		List<Instructor> instructors = null;

		Transaction t = session.getTransaction();
		t.begin();

		Query q = session.createQuery
				("from Instructor where id = ? and name = :sname");
		q.setInteger(0, id);
		q.setString("sname", name);

		instructors = q.list();

		System.out.println(" Result Set Size : " + instructors.size());

		t.commit();

		return instructors;
	}

	
	@Override
	protected void finalize() throws Throwable {
		session.close();
		super.finalize();
	}

}// end class
