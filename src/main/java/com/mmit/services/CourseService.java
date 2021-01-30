package com.mmit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Course;

@Stateless
public class CourseService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Course> findAll() {

		return em.createNamedQuery("Course.getAll", Course.class).getResultList();
	}

	public void saveCourse(Course course) {
		if(course.getId()==0)
			em.persist(course);
		else
			em.merge(course);
		
	}

	public void removeCourse(int id) {
		Course course=em.find(Course.class, id);
		em.remove(course);
		
	}

	public Course findById(String id) {
		// TODO Auto-generated method stub
		return em.find(Course.class, Integer.parseInt(id));
	}
	
	

}
