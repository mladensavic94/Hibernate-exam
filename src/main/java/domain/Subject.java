package domain;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
	@Id 
	@GeneratedValue
	@Column(name = "ID")
	private int ID;
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
	
	
	
	
}
