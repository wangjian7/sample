package runtime.di;

public class Kid extends People {

	public Kid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kid(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void say(){
		super.say();
		System.out.println("I am a kid");
	}

}
