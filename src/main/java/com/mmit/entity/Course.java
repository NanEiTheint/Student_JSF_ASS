package com.mmit.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="course")
@NamedQuery(name="Course.getAll",query = "SELECT c FROM Course c ORDER BY c.id ASC")
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Enumerated(STRING)
	private Level level;
		
	private int price;
	private int duration;
	private LocalDate startDate;
	
	public enum Level{Basic,Intermediate,Advance};
	
	@Transient
	private Level[] levels;
	
	public Level[] getLevels()
	{
		return Level.values();
	}
	
	@Embedded
	private Teacher teacher;
	
	public int getId() {
		return id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	

}
