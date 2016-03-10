package rs.ac.bg.fon.ai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class SubjectDao {

	@SuppressWarnings("unchecked")
	public void insertNewSubject(Subject subject) {
		List<Subject> list = getAllSubjects();
		boolean exist = false;
		for (Subject sub : list) {
			if (sub.getName().equals(subject.getName())) {
				exist = true;
				System.out.println("Subject with that name already exist");
				break;
			}

		}
		if (!exist) {

			Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(subject);
			System.out.println("Subject: " + subject.getName() + " added to database");
			session.getTransaction().commit();
			HibernateUtil.getInstance().closeFactory();

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllSubjects() {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		String hql = "FROM Subject";
		Query q = session.createQuery(hql);
		List<Subject> list = q.list();
		HibernateUtil.getInstance().closeFactory();
		return list;

	}

	public Subject getSubjectByName(String name) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		String hql = "FROM Subject WHERE name= :nameSubject";
		Query q = session.createQuery(hql);
		q.setString("nameSubject", name);
		Subject sub = (Subject) q.uniqueResult();
		return sub;
	}

}
