package runtime.di;

public class OrganizationMain {

	public static void main(String[] args) {
		People kid = new Kid("YoYo");
		City city = new City("001");
Organization kindergarten = new Kindergarten(kid,city);
kindergarten.showInfo();
	}

}
