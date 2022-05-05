package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import model.Person;
import model.PersonData;
import model.AVL;

class createPersonTest {
	AVL<String>AVLnames = new AVL<>();
	public void setupStage1()  {
		
		Person p= new Person("ANA", "F");
		PersonData.getPersonData().add(p);
		AVLnames.datas.add(p.getName());
	}
	

	@Test
	void emptyList() {
		setupStage1();
		boolean empty=AVL.datas.isEmpty();
		assertFalse(empty);

	}
	
	@Test
	void containsElement() {
		setupStage1();
		Person p2= new Person("SAMUEL", "M");
		PersonData.getPersonData().add(p2);
		AVLnames.datas.add(p2.getName());
		
		boolean contain=AVLnames.datas.contains(p2.getName());
		
		assertEquals(contain, true);

	}
}

