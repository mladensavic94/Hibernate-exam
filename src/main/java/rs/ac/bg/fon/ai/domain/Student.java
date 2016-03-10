package rs.ac.bg.fon.ai.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 6952079255059847992L;

	@Id
	@Column(name = "indeks")
	private int index;
	private String name;
	private String surname;
	private String birthPlace;
	private Gender gender;

	public Student() {
		super();
	}

	public Student(int index, String name, String surname, String birthPlace, Gender gender) {
		this.index = index;
		this.name = name;
		this.surname = surname;
		this.birthPlace = birthPlace;
		this.gender = gender;
	}

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [index=" + index + ", name=" + name + ", surname=" + surname + ", birthPlace=" + birthPlace
				+ ", gender=" + gender + "]";
	}

}
