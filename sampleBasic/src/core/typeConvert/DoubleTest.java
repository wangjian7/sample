package core.typeConvert;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DoubleTest {

	public static void main(String[] args) {
		// Test 1 for convert Double to 2 decimal digit/places
		Double doubleNumber1 = new Double(13);
		Double doubleNumber2 = new Double(13.1);
		Double doubleNumber3 = new Double(13.123);
		Double doubleNumber4 = new Double(13.128);
		Double doubleNumber5 = new Double(13.00);
		//know the different with #.##
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.FLOOR);
		
		System.out.println(df.format(doubleNumber1));
		System.out.println(df.format(doubleNumber2));
		System.out.println(df.format(doubleNumber3));
		System.out.println(df.format(doubleNumber4));
		System.out.println(df.format(doubleNumber5));
		
		//Double.valueOf, Double.parseDoub
		Double temp1 = new Double(100);
		double temp2 = Double.parseDouble("100");
		double temp3 = temp1.doubleValue();
		Double temp4 = Double.valueOf("100");
		
		// normal round
		RoundingMode rm = RoundingMode.HALF_UP;

	}

}
