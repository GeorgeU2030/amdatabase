package model;

import javafx.scene.image.Image;

public class Person {

	
	private String name;
	private String lastname;
	private String sex;
	private int age;
	private int height;
	private String birthDate;
	private String nationality;
	private String code;
	private String completename;
	public Person (String name,String sex) {
		this.name=name;
		this.sex=sex;
		this.lastname="";
		this.age=0;
		this.height=0;
		this.birthDate="";
		this.nationality="";
		this.code="";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompletename() {
		return completename;
	}
	public void setCompletename(String completename) {
		this.completename = completename;
	}
	
	
	
}
