package domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = -2635547975890332072L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String date;
	private int score;
	private Subject subject;
	private Student student;;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
