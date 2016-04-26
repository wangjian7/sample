package book.impatientjava;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	public int compare(String first, String second) {
		return Integer.compare(first.length(), second.length());
	}
}
