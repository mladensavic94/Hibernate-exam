package domain;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@Column(name = "examID")
	private int examID;
	@Column(name = "date")
	private String date;
	@Column(name = "score")
	private int score;
	@Column(name = "subjectID")
	private int subjectID;
	@Column(name = "studentIndex")
	private int studentIndex;
	
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
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
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public int getStudentIndex() {
		return studentIndex;
	}
	public void setStudentIndex(int studentIndex) {
		this.studentIndex = studentIndex;
	}
	
	
	
	
	
}
