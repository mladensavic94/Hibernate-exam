package domain;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
	@Id 
	@GeneratedValue
	@Column(name = "index")
	private int index;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "birth_place")
	private String birthPlace;
	@Column(name = "gender")
	private char gender;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
