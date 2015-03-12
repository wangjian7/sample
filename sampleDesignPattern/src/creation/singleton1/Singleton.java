package creation.singleton1;

//http://www.tutorialspoint.com/java/java_using_singleton.htm
//File Name: Singleton.java
public class Singleton {

	private static Singleton singleton = new Singleton();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private Singleton() {
		System.out.println("Singleton created");
	}

	/* Static 'instance' method */
	public static Singleton getInstance() {
		return singleton;
	}

	/* Other methods protected by singleton-ness */
	protected void printName() {
		System.out.println(this.name);
	}
}