package classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListHelper {

	public static <T> String toString(ArrayList<T> toConvert) {
		return toConvert.stream().map(Object::toString).collect(Collectors.joining(""));
	}

}
