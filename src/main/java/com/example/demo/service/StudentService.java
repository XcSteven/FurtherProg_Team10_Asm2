package com.example.demo.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;

@Transactional
@Service
public class StudentService {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public int saveStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return student.getId();
	}
	
	public List<Student> getAllStudent(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		return criteria.list();
	}

}
