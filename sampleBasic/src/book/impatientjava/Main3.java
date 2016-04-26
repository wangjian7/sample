package book.impatientjava;

import java.util.Arrays;

public class Main3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = new String[] { "1", "22", "101","33" };
		Arrays.sort(strings, new LengthComparator());
		System.out.println(Arrays.toString(strings));

	}
}
