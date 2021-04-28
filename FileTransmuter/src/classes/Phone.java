package classes;

public class Phone {

	public String mobile = "";
	public String landline = "";

	public Phone(String string) {
		if(!string.startsWith("T|")) 
			throw new IllegalArgumentException("The string must start with T|");
		
		String[] splitted = Splitter.Split(string);
		
		addMobile(splitted);
		addLandline(splitted);
	}

	private void addMobile(String[] splitted) {
		if(splitted.length < 2) return;
		mobile = splitted[1];
	}
	
	private void addLandline(String[] splitted) {
		if(splitted.length < 3) return;
		landline = splitted[2];
	}

	public String getMobileXml() {
		return String.format("<mobile>%s</mobile>", mobile);
	}

	public String getLandlineXml() {
		return String.format("<landline>%s</landline>", landline);
	}
	
	public String toString() {
		return String.format("<phone>%s%s</phone>", getMobileXml(),getLandlineXml());
	}
}
