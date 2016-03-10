package rs.ac.bg.fon.ai.persistance;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	private Configuration config;

	public HibernateConfig() {
		try {
			config = new Configuration();
			config.configure("hibernate.cfg.xml");
			config.setProperties(getProperties());
			// config.addClass(Exam.class);
			// config.addClass(Student.class);
			// config.addClass(Subject.class);

		} catch (Exception e) {
			System.err.println("Configuration failed");
		}
	}

	public Configuration getConfig() {
		return config;
	}

	public Properties getProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		p.put("hibernate.connection.url", "jdbc:mysql://localhost/examrecord");
		p.put("hibernate.connection.user", "admin");
		p.put("hibernate.connection.password", "admin");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;

	}

}
