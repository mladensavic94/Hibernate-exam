package rs.ac.bg.fon.ai.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import rs.ac.bg.fon.ai.dao.StudentDao;
import rs.ac.bg.fon.ai.domain.Gender;
import rs.ac.bg.fon.ai.domain.Student;

public class Main {
	static Configuration config;
	static Session session;

	public static void main(String[] args) {
		StudentDao s = new StudentDao();
		Student st = new Student(20130123, "TestName", "TestSurname", "TestBirthplace", Gender.MALE);
		s.insertNewStudent(st);
		//
		// List<Student> lista = s.listAllStudents(); for (int i = 0; i <
		// lista.size(); i++) { System.out.println(lista.get(i).toString()); ;
		// }
		//
		// System.out.println(s.findbyIndex(20130001).toString());
		// Subject sub = new Subject("TestSubjectName3", "TestProffesor", 1234);
		// SubjectDao sd = new SubjectDao();
		// sd.insertNewSubject(sub);
		//
		//
		// List<Subject> list = sd.getAllSubjects(); for (Subject subject :
		// list) { System.out.println(subject); }
		//
		//
		// System.out.println(sd.getSubjectByName("TestSubjectName"));
		// Exam exam = new Exam("9.3.2016", 5, sub, st);
		// ExamDao ed = new ExamDao();
		// ed.insertNewExam(exam);
		//
		//
		// List<Exam> l = ed.getAllPassed(); for (Exam e : l) {
		// System.out.println(e); }
		//

	}

}
