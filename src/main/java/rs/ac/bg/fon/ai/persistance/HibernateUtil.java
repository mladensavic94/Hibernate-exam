package rs.ac.bg.fon.ai.persistance;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static HibernateUtil instance;

	public HibernateUtil() {
		try {
			HibernateConfig configuration = new HibernateConfig();
			sessionFactory = configuration.getConfig().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void closeFactory() {
		getSessionFactory().close();
		instance = null;
	}

}
