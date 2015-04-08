package core.type.enums;

public enum PaypalRegion {
	NSW("New South Wales"), QLD("Queensland"), SA("South Australia"), VIC(
			"Victoria"), NT("Northern Territory"), ACT(
			"Australian Capital Territory"), WA("Western Australia");

	private String longName;

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	private PaypalRegion(String longName) {
		this.longName = longName;
	}

	public static String longName(PaypalRegion region) {
		switch (region) {
		case NSW:
		case QLD:
		case SA:
		case VIC:
		case NT:
		case ACT:
		case WA:
		}
		return "";
	}

	public static PaypalRegion shortName(String text) {
		if (text != null) {
			for (PaypalRegion r : PaypalRegion.values()) {
				if (text.equalsIgnoreCase(r.longName)) {
					return r;
				}
			}
		}
		return null;
	}

}
