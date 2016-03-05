package main;



import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;


import domain.Exam;
import domain.Student;
import domain.Subject;

public class Main {
	static Configuration config;
	public static void main(String[] args) {
		
		try {
			config = new Configuration().configure("hibernate.cfg.xml");
			//addToBase(new Subject("testNameSubjectWithOutKey","testProffesorName21",2111));
	updateStudent("Mladen", "Test");
			//deleteByYear(2111);
			listAllSubject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static void addToBase(Object o){
		if(o instanceof Student || o instanceof Exam || o instanceof Subject){
			Session session = config.buildSessionFactory().openSession(); 
			session.beginTransaction();
			session.persist(o);
			session.getTransaction().commit();
			session.close();
			System.out.println("Added to DB!");
		}
		
	}
	public static void listAllSubject(){
		
		Session session = config.buildSessionFactory().openSession();
		session.beginTransaction();
		List result = session.createQuery("FROM Subject").list();
		System.out.println("No of results: " + result.size());
		for (int i = 0; i < result.size(); i++) {
			Subject s = null;
			s = (Subject) result.get(i);
			System.out.println(s.toString());
		}
		session.close();
		
	}
	public static void deleteByYear(int year){
		
		Session session = config.buildSessionFactory().openSession();
		session.beginTransaction();
		String s = "delete Subject where year ='" + year + "'";
		Query que = session.createQuery(s);
		//que.setInteger("yearPar", year);
		int res =que.executeUpdate();
		System.out.println(res);
		session.close();
	}
	public static void updateStudent(String name, String surname){
		Session session = config.buildSessionFactory().openSession();
		session.beginTransaction();
		Query que = session.createQuery("update Student set surname = '"+surname+"'  where name = '"+name+"'");
		//que.setString("namePar", name);
		//que.setString("surnamePar", surname);
		que.executeUpdate();
		session.close();
	}

}
