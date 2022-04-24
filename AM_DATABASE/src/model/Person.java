package model;

import javafx.scene.image.Image;

public class Person {

	private String name;
	private String lastname;
	private String sex;
	private int age;
	private int height;
	private String birthDate;
	Image image1;
	public Person (String name,String sex) {
		image1= new Image("icons/bd.png");
		this.name=name;
		this.sex=sex;
		this.lastname="";
		this.age=0;
	}
	public Image getImage1() {
		return image1;
	}
	public void setImage1(Image image1) {
		this.image1 = image1;
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
	
	
	
}
