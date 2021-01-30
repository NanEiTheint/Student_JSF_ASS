package com.mmit.entity;


import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mmit.entity.Student.Year;
@Entity
@Table(name="student")
@NamedQuery(name = "Student.getAll",query = "SELECT s FROM Student s")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private int age;
	@Enumerated(STRING)
	private Year year;
	private String address;
	private LocalDate dob;
	
	public enum Year{First,Second,Third,Fouth,Fifth}
	
	@Transient
	public Year[] years;

	public Year[] getYears() {
		return Year.values();
	}
	public void setYears(Year[] years) {
		this.years = years;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
