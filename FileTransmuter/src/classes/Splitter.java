package classes;

import java.util.regex.Pattern;

public class Splitter {

	public static String[] Split(String string) {
		String[] splitted = string.split(Pattern.quote("|"));
		return splitted;
	}
	
	
}
