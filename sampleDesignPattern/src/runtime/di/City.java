package runtime.di;

public class City {
	private String code;

	public void showInfo() {
		System.out.println("city code" + code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public City() {
		super();
	}

	public City(String code) {
		super();
		this.code = code;
	}
}
