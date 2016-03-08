package main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import dao.StudentDao;
import domain.Exam;
import domain.Gender;
import domain.Student;
import domain.Subject;

public class Main {
	static Configuration config;
	static Session session;

	public static void main(String[] args) {
		StudentDao s = new StudentDao();
		Student st = new Student(20130004, "TestName", "TestSurname", "TestBirthplace", Gender.MALE);
		s.insertNewStudent(st);
		/*
		 * List<Student> lista = s.listAllStudents(); for (int i = 0; i <
		 * lista.size(); i++) { System.out.println(lista.get(i).toString()); ; }
		 */
		System.out.println(s.findbyIndex(20130001).toString());

	}

	public static void addToBase(Object o) {
		if (o instanceof Student || o instanceof Exam || o instanceof Subject) {
			openSession();
			session.persist(o);
			session.getTransaction().commit();
			closeSession();
			System.out.println("Added to DB!");
		}
	}

	public static void listAllSubject() {
		openSession();
		@SuppressWarnings("unchecked")
		List<Subject> result = session.createQuery("FROM Subject").list();
		System.out.println("No of results: " + result.size());
		for (int i = 0; i < result.size(); i++) {
			Subject s = null;
			s = (Subject) result.get(i);
			System.out.println(s.toString());
		}
		closeSession();

	}

	public static Student findStudentByIndex(int index) {
		openSession();
		Student s = (Student) session.createQuery("FROM Student WHERE indeks =" + index).list().get(0);
		closeSession();
		return s;
	}

	public static List<Subject> findSubjectByName(String name) {
		openSession();

		String query = "FROM Subject " + "WHERE name = :name";

		@SuppressWarnings("unchecked")
		List<Subject> list = session.createQuery(query).setEntity("name", name).list();

		closeSession();
		return list;

	}

	public static void deleteByYear(int year) {
		openSession();
		String s = "delete Subject where year ='" + year + "'";
		Query que = session.createQuery(s);
		// que.setInteger("yearPar", year);
		int res = que.executeUpdate();
		System.out.println(res);
		closeSession();
	}

	public static void updateStudent(String name, String surname) {
		openSession();
		Query que = session.createQuery("update Student set surname = '" + surname + "'  where name = '" + name + "'");
		// que.setString("namePar", name);
		// que.setString("surnamePar", surname);
		que.executeUpdate();
		closeSession();
	}

	public static void openSession() {
		session = config.buildSessionFactory().openSession();
		session.beginTransaction();
	}

	public static void closeSession() {
		session.close();
		session.getSessionFactory().close();
	}

}
