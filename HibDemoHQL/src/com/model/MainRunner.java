package com.model;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MainRunner {

	Scanner sc = new Scanner(System.in);
	DatabaseOperations dbOperation = new DatabaseOperations();
	
	public static void main(String[] args) {
		
		MainRunner obj = new MainRunner();
		while(true)
		{
			try {
				
				System.out.println("\n\n ====== MENU =======");
				System.out.println("0. EXIT");
				System.out.println("1. Add Instructor ");
				System.out.println("2. Retrieve Instructor By Name and ID");
				System.out.println("3. Retrieve Instructor By Course");
				System.out.println("4. Retrieve Course By Duration");
				System.out.println("5. Retrieve Course By Duration Using Pegination");
				System.out.println("6. Retrieve Instructor By City Using Criteria API ");
				System.out.println("7. Retrieve Instructor By States Using Criteria Multi Ristrictions ");
				
				
				System.out.println("\n\n Enter Ur Choice :- ");
				int choice = Integer.parseInt(obj.sc.nextLine());
				
				switch (choice) {
				case 0:
					obj.appClosing();
				case 1:
					obj.getInstructorFromUser();
					break;
				case 2:
					obj.searchInstructorByNameAndID();
					break;
					
				case 3:
					obj.searchInstructorByCourse();
					break;
					
				case 4:
					obj.searchCoursesByDuration();
					break;
				case 5:
					obj.searchCoursesByDuration_Pegination();
					break;
					
				case 6:
					obj.searchInstructorByCity_Criteria();
					break;
					
				case 7:
					obj.searchInstructorByCity_Criteria_Multi();
					break;
					
					
				default:
					System.out.println("\n Wrong Input, Pls. Try Again");
					break;
				}
				
				
			} //end try
			catch (NumberFormatException e)   
			{
				System.out.println(e.getMessage());
				System.out.println("Try Again");
			}
			catch (Exception e)   
			{
				System.out.println(e.getMessage());
				System.out.println("Try Again");
			}
			
		}//end while
	
	}//end main
	
	
	public void searchCoursesByDuration_Pegination()
	{
		String msg = "Search Courses Where Duration > {duration} ";
		System.out.println("Focus on Demo Query \n[ "+msg+" ]\nEnter Duration :- ");
		int duration = Integer.parseInt(sc.nextLine());
		
		List<Course> courses = dbOperation.getCourseByDuration_Pegination_1(duration);
		displayCourses(courses, "<<<< Below Are the Courses where Duration is greater than "+duration+" >>>>");
		
	}

	
	
	public void searchCoursesByDuration()
	{
		String msg = "Search Courses Where Duration > {duration} ";
		System.out.println("Focus on Demo Query \n[ "+msg+" ]\nEnter Duration :- ");
		int duration = Integer.parseInt(sc.nextLine());
		
		List<Course> courses = dbOperation.getCourseByDuration(duration);
		displayCourses(courses, "<<<< Below Are the Courses where Duration is greater than "+duration+" >>>>");
		
	}
	
	
	public void searchInstructorByCity_Criteria()
	{
		System.out.println("Enter Search City : ");
		String city = sc.nextLine();
		
		List<Instructor> instructor = dbOperation.getInstructorByCity_Criteria(city);
		display(instructor);
	}
		
	
	public void searchInstructorByCity_Criteria_Multi()
	{
		System.out.println("Enter Present State to Search Instructor: ");
		String state1 = sc.nextLine();
		
		System.out.println("Enter Permanent State to Search Instructor: ");
		String state2 = sc.nextLine();
		
		
		List<Instructor> instructor = dbOperation.getInstructorByCity_Criteria_2States(state1, state2);
		display(instructor);
	}
	
	
	public void searchInstructorByCourse()
	{
		System.out.println("Enter Search Course : ");
		String name = sc.nextLine();
		
		List<Instructor> instructor = dbOperation.getInstructorByCourse(name);
		display(instructor);
	}
	
	
	public void searchInstructorByNameAndID()
	{
		System.out.println("Enter Instructor ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Instructor Name : ");
		String name = sc.nextLine();
		
		List<Instructor> instructor = dbOperation.getInstructorByNameandId(name, id);
		display(instructor);
	}
	
	
	public void display(List<Instructor> instructors)
	{
		for (Instructor instructor : instructors) {
			
			System.out.println("Instructor Details \t "+instructor+"");
			Set<Course> courses = instructor.getCourses();
			
			displayCourses(courses, "");
			
			System.out.println("Instructor Present Address \t"+instructor.getPresentAddress());
			System.out.println("Instructor Permanent Address \t"+instructor.getPermanentAddress());
			
			System.out.println("\n\n===========================================================================");
		}
		
	}
	
	
	public void displayCourses(Collection<Course> courses,String tag)
	{
		if(!tag.equals("")) System.out.println("\n"+tag+"\n");
		for (Course course : courses) {
			System.out.println(course);
			System.out.println("----------------------------------------------------------------------------");
		}
		
	}
	
	
	public void appClosing()
	{
		System.out.print("\nApplication Closing");
		for(int i=0;i<7;i++)
		try {
			System.out.print("..");
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("\n\n ===== APP CLOSED @ "+new Date()+"=====");
		System.exit(0);
	}
	
	public void getInstructorFromUser()
	{
		Instructor instructor = null;
		System.out.println("Enter Instructor Name ");
		String name = sc.nextLine();
		
		System.out.println("Enter "+name+"'s Email");
		String email = sc.nextLine();
		
		instructor = new Instructor(name, email);
		
		// --- Populating values in Instructor 
		
		instructor.setPresentAddress(getAddressFromUser("Present"));
		instructor.setPermanentAddress(getAddressFromUser("Permanent"));
		Set<Course> courses = new LinkedHashSet<Course>();
		int yes = 1;
		do
		{
			System.out.println("Enter Course Details for "+name);
			courses.add(getCourseFromUser());
			System.out.println("Want to add more course <0/1>");
			yes = Integer.parseInt(sc.nextLine());
		}while(yes != 0);
		instructor.setCourses(courses);
		
		// ---------- Passing Instrctor to Hibernate -------
		dbOperation.createData(instructor);
		System.out.println(" ====>> [INFO] :- \t "+name+" Added in D/B ");
	}
	
	public Address getAddressFromUser(String tag)
	{
		Address address = null;
		System.out.println("Enter "+tag+" House Number ");
		String houseNumber = sc.nextLine();
		System.out.println("Enter "+tag+" City ");
		String city = sc.nextLine();
		System.out.println("Enter "+tag+" State ");
		String state = sc.nextLine();
		
		address = new Address(houseNumber, city, state);
		return address;
	}
	
	public Course getCourseFromUser()
	{
		
		Course course = null;
		System.out.println("Enter Course Name ");
		String courseName = sc.nextLine();
		
		System.out.println("Enter "+courseName+" Duration");
		int duration = Integer.parseInt(sc.nextLine());
		
		course = new Course(courseName, duration);
		return course;
	}
	
	
}//end class
