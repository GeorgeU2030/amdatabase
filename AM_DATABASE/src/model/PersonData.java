package model;

import java.util.ArrayList;

public class PersonData {

	private static ArrayList<Person>personData=new ArrayList<>();

	public static ArrayList<Person> getPersonData() {
		return personData;
	}

	public static void setPersonData(ArrayList<Person> personData) {
		PersonData.personData = personData;
	}
	
	
}
