package sourcemaking.creation.singleton;

public class Main1Wrong {

	public static void main(String[] args) {
		GovernmentWrong government = GovernmentWrong.getInstance();
		government.setName("abc");
		System.out.println(government.getName());
		
		GovernmentWrong government2 = GovernmentWrong.getInstance();
		System.out.println(government2.getName());
		
	}

}
