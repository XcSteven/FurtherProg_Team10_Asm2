package service;
import model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class StudentService {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Student> getAllStudents(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		return criteria.list();
	}
	public int saveStudent(Student student){
		sessionFactory.getCurrentSession().save(student);
		return student.getId();
	}
}
