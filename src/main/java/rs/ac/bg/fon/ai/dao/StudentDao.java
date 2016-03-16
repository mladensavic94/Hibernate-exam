package rs.ac.bg.fon.ai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class StudentDao {

	public void insertNewStudent(Student student) {

		Student fromDB = findbyIndex(student.getIndex());
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		if (fromDB == null) {
			session.save(student);
			session.getTransaction().commit();
			System.out.println("New student added");
		} else {
			System.out.println("Student already exists");
		}

		HibernateUtil.getInstance().closeFactory();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List listAllStudents() {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> result = session.createQuery("FROM Student").list();

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

}
