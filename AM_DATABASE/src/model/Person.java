package model;

import javafx.scene.image.Image;

public class Person {

	private String name;
	private String lastname;
	private String sex;
	Image image1;
	public Person (String name,String sex) {
		image1= new Image("flags/bd.png");
		this.name=name;
		this.sex=sex;
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
	
	
}
