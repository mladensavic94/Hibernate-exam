package domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = -8506052895380466541L;

	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String name;
	private String leadProffesor;
	private int year;

	public Subject() {
		super();
	}

	public Subject(String name, String leadProffesor, int year) {
		this.name = name;
		this.leadProffesor = leadProffesor;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeadProffesor() {
		return leadProffesor;
	}

	public void setLeadProffesor(String leadProffesor) {
		this.leadProffesor = leadProffesor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Subject: " + name + "\tProffesor: " + leadProffesor + "\tYear of enrollment: " + year;
	}

}
