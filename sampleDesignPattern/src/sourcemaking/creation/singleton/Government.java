package sourcemaking.creation.singleton;

public class Government {

	private Government() {

	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static Government instance;

	public static Government getInstance() {
		if (instance == null) {
			instance = new Government();
		}
		return instance;
	}
}
