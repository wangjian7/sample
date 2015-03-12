package creation.singleton1;

public class LazySingleton {

	private static LazySingleton instance = null;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected LazySingleton() {
		// Exists only to defeat instantiation.
		System.out.println("LazySingleton created");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	/* Other methods protected by singleton-ness */
	protected void printName() {
		System.out.println(this.name);
	}
}
