package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import control.MenuWindowController;
import model.Person;
import model.PersonData;
import model.AVL;

class deletePersonTest {
	public static Person p= new Person("ANA", "F");
	
	AVL<String>AVLnames = new AVL<>();
	
	public void setupStage1()  {
		
		PersonData.getPersonData().add(p);
		AVLnames.datas.add(p.getName());
		
	}
	

	@Test
	void deleteElement() {
		setupStage1();
		MenuWindowController.deletePerson(p);
		boolean a=PersonData.getPersonData().contains(p);
		
		assertEquals(a,false);

	}
	
	
	@Test
	void emptyList() {
		setupStage1();
		MenuWindowController.deletePerson(p);
		boolean empty=PersonData.getPersonData().isEmpty();
		
		assertEquals(empty,true);
		

	}
}
