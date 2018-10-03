package com.core;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class MainSet {
	public static void main(String[] args) {
		
		
		Set<Student> stuSet = new HashSet<Student>();
		
		Student s1 = new Student("ABC",101, 166);
		Student s2 = new Student("ABCD",102, 676);
		Student s3 = new Student("ABCEFG",1034, 366);
		Student s4 = new Student("ABSSC",10451, 66);
	
		stuSet.add(s1);
		stuSet.add(s2);
		stuSet.add(s3);
		stuSet.add(s4);
		
		System.out.println(stuSet.size());
		System.out.println(stuSet);
	}
}
