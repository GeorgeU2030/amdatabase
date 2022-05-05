package Testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import model.Person;
import model.PersonData;
import model.AVL;

class createPersonTest {
	
	public void setupStage1()  {
		AVL<String>AVLnames = new AVL<>();
		
		Person p= new Person("ANA", "F");
		PersonData.getPersonData().add(p);
		AVLnames.datas.add(p.getName());
	}
	

	@Test
	void test() {
		setupStage1();
		
	
		boolean empty=AVL.datas.isEmpty();
		assertFalse(empty);

}
}

