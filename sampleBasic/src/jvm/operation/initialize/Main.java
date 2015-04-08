//refer
//http://stackoverflow.com/questions/19058766/java-static-initialization-order
package jvm.operation.initialize;

public class Main {
	//public static Main m = new Main();
	{
		System.out.printf("NON-STATIC BLOCK\n");
	}

	static {
		System.out.printf("STATIC BLOCK\n");
	}

	public static Main m = new Main();
	// public Main m = new Main();

	public Main() {
		System.out.printf("MAIN CONSTRUCTOR\n");
	}

	public static void main(String... args) {
		// Main m = new Main();
		System.out.printf("MAIN METHOD\n");

	}
}
