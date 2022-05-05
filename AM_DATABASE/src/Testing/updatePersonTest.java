package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AVL;
import model.Person;
import model.PersonData;

class updatePersonTest {
	
	AVL<String>AVLnames = new AVL<>();
	public void setupStage1()  {	
		Person p= new Person("ANA", "F");
		PersonData.getPersonData().add(p);
		AVLnames.datas.add(p.getName());
	}
	@Test
	void updateNameTest() {
		setupStage1();
		String lastName=PersonData.getPersonData().get(0).getName();
		PersonData.getPersonData().get(0).setName("DIANA");
		String newName=PersonData.getPersonData().get(0).getName();
		AVLnames.remove(lastName);
		AVLnames.insert(newName);
		
		boolean a=AVLnames.datas.contains(newName);
		boolean b=AVLnames.datas.contains(lastName);
		
		assertNotEquals(a, b);
	}

}
