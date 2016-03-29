package rs.ac.bg.fon.ai.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class SubjectDao {
	public static Logger log = Logger.getLogger(SubjectDao.class);

	public void insertNewSubject(Subject subject) {
		Long count = countByName(subject.getName());
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		if (count == 0) {

			session.persist(subject);
			session.getTransaction().commit();
			HibernateUtil.getInstance().closeFactory();
			log.info("Subject added to db");
		} else
			log.info("Subject already exists");

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

	@SuppressWarnings("unchecked")
	public List<Subject> listSubjectsByName(String name) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		String hql = "FROM Subject WHERE name= :nameSubject";
		Query q = session.createQuery(hql);
		q.setString("nameSubject", name);
		List<Subject> list = q.list();
		return list;
	}

	public Long countByName(String name) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "SELECT count(s.name)FROM Subject s WHERE name= :nameParam";
		Query q = session.createQuery(sql);
		q.setString("nameParam", name);
		Long l = (Long) q.uniqueResult();
		HibernateUtil.getInstance().closeFactory();
		return l;
	}

}
