package com.mmit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.mmit.entity.Student;
import com.mmit.services.StudentService;

@Named
@RequestScoped
public class StudentBean {
	
	private Student student;
	private List<Student> studentList;
	
	@Inject
	private StudentService service;
	
	
	@PostConstruct
	public void init()
	{
		String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("studentId");
		if(id!=null)
			student=service.findById(Integer.parseInt(id));
		else
			student=new Student();
		studentList=service.findAll();
	}
	
	public String save()
	{
		service.saveStudent(student);
		return "student?faces-redirect=true";
	}
	
	public String delete(int id)
	{
		service.removeStudent(id);
		return "student?faces-redirect=true";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
