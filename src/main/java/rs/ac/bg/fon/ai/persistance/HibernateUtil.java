package rs.ac.bg.fon.ai.persistance;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Configuration config;
	public static SessionFactory sessionFactory;
	public static HibernateUtil instance;

	public HibernateUtil() {
		try {
			config = new Configuration();
			config.configure("hibernate.cfg.xml");
			config.setProperties(getProperties());
			sessionFactory = config.buildSessionFactory();
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

	// TODO: extract to a separate class HibernateConfig
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		p.put("hibernate.connection.url", "jdbc:mysql://localhost/examrecord");
		p.put("hibernate.connection.user", "examrecord");
		p.put("hibernate.connection.password", "examrecord");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;

	}
}
