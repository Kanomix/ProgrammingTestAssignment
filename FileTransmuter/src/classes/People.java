package classes;

import java.util.ArrayList;

public class People {

	public ArrayList<Person> Persons;

	public void addPerson(Person person) {
		if(Persons == null) 
			Persons = new ArrayList<Person>();
	
		Persons.add(person);
	}

	public String personsToXml(){
		if(Persons == null) return "";
		
		return ListHelper.toString(Persons);
	}
	
	public String generateXml() {
		return String.format("<people>%s</people>", personsToXml());
	}

}
