package classes;

import java.util.Objects;

public class Family {
	public String Name = "";
	public String Born = "";
	public Phone Phone;
	public Adress Adress;
	
	public Family(String string) {
		if(!string.startsWith("F|")) 
			throw new IllegalArgumentException("The string must start with F|");

		String[] splitted = Splitter.Split(string);
		
		addName(splitted);
		addBorn(splitted);
	}
	
	private void addName(String[] splitted) {
		if(splitted.length < 2) return;
		Name = splitted[1];
	}
	
	private void addBorn(String[] splitted) {
		if(splitted.length < 3) return;
		Born = splitted[2];	
	}
	
	public void addAdress(Adress adress) {
		this.Adress = adress;
	}
	
	public void addPhone(Phone phone) {
		this.Phone = phone;
	}
	
	public String toString() {
		return String.format("<family>%s%s%s%s</family>",getNameToXml(),getBornToXml(),Objects.toString(Phone, ""),Objects.toString(Adress, ""));
	}

	public String getNameToXml() {
		return (Name == "") ? "" : String.format("<name>%s</name>", Name);
	}
	
	public String getBornToXml() {
		return (Born == "") ? "" : String.format("<born>%s</born>", Born);
	}
}
