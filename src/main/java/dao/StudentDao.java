package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.Student;
import main.HibernateUtil;

public class StudentDao {

	@SuppressWarnings("unchecked")
	public void insertNewStudent(Student student) {

		List<Student> result = listAllStudents();
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		boolean exist = false;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getIndex() == student.getIndex()) {
				System.out.println("Student with index: " + student.getIndex() + " already exists");
				exist = true;
			}

		}
		if (!exist) {
			session.save(student);
			session.getTransaction().commit();
			System.out.println("New student added");
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
