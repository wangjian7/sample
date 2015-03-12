package creation.singleton;

public class GovernmentMain {

	public static void main(String[] args) {
		Government government = Government.getInstance();
		government.setName("abc");
		System.out.println(government.getName());
		
		Government government2 = Government.getInstance();
		System.out.println(government2.getName());
		
	}

}
