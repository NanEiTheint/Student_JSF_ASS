package com.mmit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Student;

@Stateless
public class StudentService{
	
	@PersistenceContext
	private EntityManager em;

	public void saveStudent(Student student) {
		if(student.getId()==0)
			em.persist(student);
		else
			em.merge(student);
		
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Student.getAll", Student.class).getResultList();
	}

	public void removeStudent(int id) {
		Student student=em.find(Student.class, id);
		
		em.remove(student);
		
	}

	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	
	

}
