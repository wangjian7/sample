package creation.singleton;

public class GovernmentWrong {

	private GovernmentWrong() {

	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static GovernmentWrong instance;

	public static GovernmentWrong getInstance() {
		if (instance == null) {
			return new GovernmentWrong();
		}else{
			return instance;
		}
		
	}
}
