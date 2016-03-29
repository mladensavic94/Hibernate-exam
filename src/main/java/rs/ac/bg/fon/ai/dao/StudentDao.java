package rs.ac.bg.fon.ai.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class StudentDao {
	public static Logger log = Logger.getLogger(StudentDao.class);

	public void insertNewStudent(Student student) {

		Long count = countByName(student.getName());
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		if (count == 0) {
			session.save(student);
			session.getTransaction().commit();
			log.info("New student added");
		} else {
			log.info("Student already exists");
		}

		HibernateUtil.getInstance().closeFactory();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List listAllStudents() {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> result = session.createQuery("FROM Student").list();
		log.info("All students listed!");
		HibernateUtil.getInstance().closeFactory();
		return result;
	}

	public Student findbyIndex(int index) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Student WHERE indeks= :indexParam";
		Query q = session.createQuery(sql);
		q.setInteger("indexParam", index);
		Student s = (Student) q.uniqueResult();
		HibernateUtil.getInstance().closeFactory();
		return s;

	}

	public Student findByName(String name) {
		log.trace("Opening connection");
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Student WHERE name= :nameParam";
		Query q = session.createQuery(sql);
		q.setString("nameParam", name);
		Student s = (Student) q.uniqueResult();
		HibernateUtil.getInstance().closeFactory();
		log.trace("Closing connection");
		return s;
	}

	public List<Student> listStudentsByName(String name) {
		log.trace("Opening connection");
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Student WHERE name= :nameParam";
		Query q = session.createQuery(sql);
		q.setString("nameParam", name);
		@SuppressWarnings("unchecked")
		List<Student> list = q.list();
		HibernateUtil.getInstance().closeFactory();
		log.trace("Closing connection");
		return list;
	}

	public Long countByName(String name) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "SELECT count(s.name)FROM Student s WHERE name= :nameParam";
		Query q = session.createQuery(sql);
		q.setString("nameParam", name);
		Long l = (Long) q.uniqueResult();
		HibernateUtil.getInstance().closeFactory();
		return l;
	}

}
