package com.sphinix.challenge2;

import java.util.HashSet;
import java.util.Set;

public class FetchStudentData {

static Set<Student> sList = new HashSet<Student>();	
	
	public static void putMockData(){ 
		sList.add(new Student(12345,"Anoop","9561516568","South Arfica"));
		sList.add(new Student(12346,"Arjun","9165651354","India"));
		sList.add(new Student(12347,"Kiran","9476161316","Pakistan"));  
	}
	
	public static void getStudentData(){ 
		for (Student Student : sList) {
			System.out.println("Id :" + Student.getId() +"\n" 
				+"Name :" + Student.getName() +"\n"
				+"Phone :" + Student.getPhone() +"\n"
				+"Address :" + Student.getAddress() +"\n" 
					);   
		} 
	}
	
	public static void main(String args[]){
		putMockData(); 
		getStudentData();
	}
}