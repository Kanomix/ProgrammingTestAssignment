package classes;

import java.util.ArrayList;
import java.util.Objects;

public class Person {


	public String FirstName;
	public String LastName;
	public Adress Adress;
	public Phone Phone;
	public ArrayList<Family> FamilyList;
	
	public Person(String string) {
		if(!string.startsWith("P|")) 
			throw new IllegalArgumentException("The string must start with P|");
		
		String[] splitted = Splitter.Split(string);
		
		addFirstName(splitted);
		addLastName(splitted);
	}

	private void addFirstName(String[] splitted) {
		FirstName = splitted[1];
	}

	private void addLastName(String[] splitted) {
		LastName = splitted[2];
	}

	public void addAdress(Adress adress) {
		Adress = adress;	
	}

	public void addPhone(Phone phone) {
		Phone = phone;
	}

	public void addFamily(Family family) {
		if(FamilyList == null) 
			FamilyList = new ArrayList<Family>();
		
		FamilyList.add(family);
	}
	
	public String toString() {
		return String.format("<person><firstname>%s</firstname><lastname>%s</lastname>%s%s%s</person>", FirstName, LastName, Objects.toString(Adress,""), Objects.toString(Phone, ""), familyToXml());
	}

	public String familyToXml() {
		if(FamilyList == null) 
			return "";
		
		return ListHelper.toString(FamilyList);
	}
}
