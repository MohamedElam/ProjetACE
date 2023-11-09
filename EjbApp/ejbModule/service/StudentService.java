package service;

import java.util.List;

import dao.IDao;
import Entities.Student;
import Entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name="ss")
public class StudentService  extends User implements IDao<Student>{
	  
		@PersistenceContext
		private EntityManager s;
		
	    /**
	     * @see User#User()
	     */
	    public StudentService() {
	        super();
	        // TODO Auto-generated constructor stub
	    }


	    @Override
		@PermitAll
		public Student create(Student o) {
			// TODO Auto-generated method stub
			s.persist(o);
			return o;
		}

	    @Override
	   	@PermitAll
		public void delete(Student o) {
			// TODO Auto-generated method stub
			s.remove(o);
		}

	    @Override
	   	@PermitAll
		public Student update(Student o) {
			// TODO Auto-generated method stub
	    	s.persist(o);
			return o;
		}

	    @Override
	   	@PermitAll
		public Student findById(int id) {
			// TODO Auto-generated method stub
	    	Student student = s.find(Student.class, id);
	        if(student == null) throw new RuntimeException("Student introuvable");
	        return student;
		}

	    @Override
	   	@PermitAll
		public List<Student> findAll() {
	    	 Query req= s.createQuery("select s from Student s");
	         return req.getResultList();
		}
}
