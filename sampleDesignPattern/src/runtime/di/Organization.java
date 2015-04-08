package runtime.di;

public class Organization {
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public City getCity() {
		return city;
	}

	public Organization(People people, City city) {
		super();
		this.people = people;
		this.city = city;
	}

	public Organization() {
		super();
	}

	public void setCity(City city) {
		this.city = city;
	}

	private People people;
	private City city;
	
	public void showInfo() {
		people.say();
		city.showInfo();
	}
	
}
