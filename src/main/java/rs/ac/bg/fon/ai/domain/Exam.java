package rs.ac.bg.fon.ai.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = -2635547975890332072L;

	@Id	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String date;
	private int score;
	
	@OneToOne
	private Subject subject;

	@OneToOne
	private Student student;

	public Exam() {
		super();

	}

	public Exam(String date, int score, Subject subject, Student student) {
		super();
		this.date = date;
		this.score = score;
		this.subject = subject;
		this.student = student;
	}

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

	@Override
	public boolean equals(Object obj) {
		Exam e = (Exam) obj;
		if (e.getDate().equals(this.getDate()) && e.getScore() == this.getScore()
				&& e.getStudent().equals(this.getStudent()) && e.getSubject().equals(this.getSubject())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Exam [date=" + date + ", score=" + score + ", subject=" + subject + ", student=" + student + "]";
	}

}
