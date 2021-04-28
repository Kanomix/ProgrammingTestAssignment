package classes;

public class Adress {
	public String Street = "";
	public String City = "";
	public String ZipCode = "";
	
	public Adress() {
		
	}
	
	public Adress(String string) {
		if(!string.startsWith("A|")) 
			throw new IllegalArgumentException("The string must start with A|");
		
		String[] splitted = Splitter.Split(string);
	
		addStreet(splitted);
		addCity(splitted);
		addZipCode(splitted);
	}
	
	public void addStreet(String[] splittedStr) {
		if(splittedStr.length < 2) return;
		Street = splittedStr[1];
	}
	
	public void addCity(String[] splittedStr) {
		if(splittedStr.length < 3) return;
		City = splittedStr[2];
	}
	
	public void addZipCode(String[] splittedStr) {
		if(splittedStr.length < 4) return;
		ZipCode = splittedStr[3];
	}
	
	public String getXmlForStreet() {
		if(Street == "") return "";
		return String.format("<street>%s</street>", Street);
	}
	
	public String getXmlForCity() {
		if(City == "") return "";
		return String.format("<city>%s</city>", City);
	}
	
	public String getXmlForZipCode() {
		
		if(ZipCode == "") return "";
		return String.format("<zipcode>%s</zipcode>", ZipCode);
	}
	
	public String toString() {
		return String.format("<adress>%s%s%s</adress>", getXmlForStreet(), getXmlForCity(), getXmlForZipCode());
	}
	
}
