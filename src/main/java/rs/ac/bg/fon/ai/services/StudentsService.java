package rs.ac.bg.fon.ai.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class StudentsService {
	public static Logger log = Logger.getLogger(StudentsService.class);

	@SuppressWarnings("unchecked")
	public List<Student> listAllStudents(String query, String order, int limit, int page) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Student s WHERE name LIKE CONCAT(:query, '%') ORDER BY s.id " + order;
		Query q = session.createQuery(sql);
		q.setString("query", query);
		q.setString("order", order);
		List<Student> result = q.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
		log.info("All students listed!");
		HibernateUtil.getInstance().closeFactory();
		return result;
	}

}
