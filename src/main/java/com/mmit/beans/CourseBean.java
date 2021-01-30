package com.mmit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.mmit.entity.Course;
import com.mmit.entity.Teacher;
import com.mmit.services.CourseService;

@Named
@RequestScoped
public class CourseBean {
	
	private Course course;
	private List<Course> courseList;
	private Teacher teacher;
	
	@EJB
	private CourseService service;
	private String title="";
	
	@PostConstruct
	public void init()
	{
		//for active light page
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String action=origRequest.getServletPath();
		if(action.equals("/add-course.xhtml"))
		{
			title="add-c";
			//System.out.println("Url name:"+action);
		}
		else if(action.equals("/add-student.xhtml"))
			title="add-s";
		else if(action.equals("/student.xhtml"))
			title="s";
		
		//for add or edit
		String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("courseId");
		if(id!=null)
			course=service.findById(id);
		else
		{
			teacher=new Teacher();
			course=new Course();
			course.setTeacher(teacher);
		}
		
		courseList=service.findAll();
				
	}
	
	public String save()
	{
		service.saveCourse(course);
		return "index?faces-redirect=true";
	}
	
	public String delete(int id)
	{
		service.removeCourse(id);
		return "index?faces-redirect=true";
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	

}
