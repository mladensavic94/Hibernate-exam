package rs.ac.bg.fon.ai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Exam;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class ExamDao {

	public void insertNewExam(Exam exam) {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(exam);
		session.getTransaction().commit();
		HibernateUtil.getInstance().closeFactory();
		System.out.println("Exam added to database");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAllExams() {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM Exam";
		Query q = session.createQuery(hql);
		List<Exam> list = q.list();
		return list;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAllPassed() {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM Exam AS e WHERE e.score > 5";
		Query q = session.createQuery(hql);
		List<Exam> list = q.list();
		return list;
	}

}
