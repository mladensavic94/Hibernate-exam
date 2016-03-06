package domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {
	@Id
	@Column(name = "indeks")
	private int index;
	public Student(){
		super();
	}
	public Student(int index, String name, String surname, String birthPlace, char gender) {
		this.index = index;
		this.name = name;
		this.surname = surname;
		this.birthPlace = birthPlace;
		this.gender = gender;
	}
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
	@Override
	public String toString() {
		return "Student [index=" + index + ", name=" + name + ", surname=" + surname + ", birthPlace=" + birthPlace
				+ ", gender=" + gender + "]";
	}
	
	
}
