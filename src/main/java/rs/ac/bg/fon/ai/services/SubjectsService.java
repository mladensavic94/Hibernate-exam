package rs.ac.bg.fon.ai.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class SubjectsService {

	public static Logger log = Logger.getLogger(SubjectsService.class);

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects(String query, String order, int limit, int page) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Subject s " +
					 "WHERE name LIKE CONCAT(:query, '%') " + 
					 "ORDER BY s.id " + order;

		List<Subject> result = session.createQuery(sql)
				.setString("query", query)
				.setFirstResult((page - 1) * limit)
				.setMaxResults(limit)
				.list();

		log.info("All subjects listed!");
		HibernateUtil.getInstance().closeFactory();
		return result;
	}

}
