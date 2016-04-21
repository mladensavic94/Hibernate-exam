package rs.ac.bg.fon.ai.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import rs.ac.bg.fon.ai.domain.Exam;
import rs.ac.bg.fon.ai.persistance.HibernateUtil;

public class ExamsService {

	public static Logger log = Logger.getLogger(ExamsService.class);

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams(String query, String order, int limit, int page) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Exam e " + "WHERE date LIKE CONCAT(:query, '%') " + "ORDER BY e.id " + order;

		List<Exam> result = session.createQuery(sql)
				.setString("query", query)
				.setFirstResult((page - 1) * limit)
				.setMaxResults(limit).list();
		

		log.info("All exams listed!");
		HibernateUtil.getInstance().closeFactory();
		return result;
	}
}
