package runtime.di;

public class People {
	private String name;

	/* (non-Javadoc)
	 * @see runtime.di.aa#getName()
	 */
	public String getName() {
		return name;
	}


	/* (non-Javadoc)
	 * @see runtime.di.aa#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}


	public People() {
		super();
	}
	

	public People(String name) {
		super();
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see runtime.di.aa#say()
	 */
	public void say() {
		System.out.println("My name is " + name);
	}
}
