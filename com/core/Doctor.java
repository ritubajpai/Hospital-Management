package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor implements Serializable{
	private static int count=100;
	private int docId;
	private String dname,email,degree;
	private LocalDate joiningDate;
	private Department dept;
	private double salary;
	private int experience;
	public Doctor(String dname, String email, String degree, LocalDate joiningDate, Department dept,
			double salary, int experience) {
		super();
		count++;
		this.docId = count;
		this.dname = dname;
		this.email = email;
		this.degree = degree;
		this.joiningDate = joiningDate;
		this.dept = dept;
		this.salary = salary;
		this.experience = experience;
	}
	
	
	public String getDname() {
		return dname;
	}
	public String getEmail() {
		return email;
	}
	public String getDegree() {
		return degree;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public Department getDept() {
		return dept;
	}
	public double getSalary() {
		return salary;
	}
	public int getExperience() {
		return experience;
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", dname=" + dname + ", email=" + email + ", degree=" + degree
				+ ", joiningDate=" + joiningDate + ", dept=" + dept + ", salary=" + salary + ", experience="
				+ experience + "]"+"\n";
	}
	
	
	
	

}
