package domain;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
	@Id 
	@Column(name = "ID")
	private int ID;
	public Subject(){
		super();
		
	}
	public Subject( String name, String leadProffesor, int year) {
		this.name = name;
		this.leadProffesor = leadProffesor;
		this.year = year;
	}
	@Column(name = "name")
	private String name;
	@Column(name = "lead_proffesor")
	private String leadProffesor;
	@Column(name = "year")
	private int year;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
