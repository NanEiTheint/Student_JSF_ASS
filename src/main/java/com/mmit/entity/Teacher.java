package com.mmit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Teacher implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String teacher_name;
	private String phone;
	
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
