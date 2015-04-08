package core.type.enums;

public class PaypalRegionTest {
	public static void main(String args[]) {
		String longName = "Northern Territory";
		if (longName.equals(PaypalRegion.NT.getLongName())) {
			System.out.println(PaypalRegion.NT);
		}

		System.out.println(PaypalRegion.shortName(longName));

	}
}
