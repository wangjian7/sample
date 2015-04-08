package core.type.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberTest {
	public static void main(String... arge) {
		double double1 = 10.1230;
		double double2 = 10.01556;
		double double3 = 10.01123;

		Double double4 = new Double("10.0123");
		Double double5 = new Double("10.01434");
		Double double6 = new Double("10.01889");

		BigDecimal bd1 = new BigDecimal("10.0123");
		BigDecimal bd2 = new BigDecimal("10.0123");
		BigDecimal bd3 = new BigDecimal("10.0253");

		System.out.println(double1 + double2 + double3);
		System.out.println(formatToCardinalStringAmount(double4)
				+ formatToCardinalStringAmount(double5)
				+ formatToCardinalStringAmount(double6));
		System.out.println(bd1.add(bd2).add(bd3));

		// Sample 1
		Double double7 = new Double(double1);
		System.out.println(double7);
		// 10.123
		BigDecimal bd7 = new BigDecimal(double1);
		System.out.println(bd7);
		// 10.1229999999999993320898283855058252811431884765625
		BigDecimal bd8 = BigDecimal.valueOf(double1);
		System.out.println(bd8);
		// 10.123
		double double8 = bd1.doubleValue();
		System.out.println(double8);
		// 10.0123

		// Sample 2
		System.out.println(formatToBigDecimal(double4).add(
				formatToBigDecimal(double5)).add(formatToBigDecimal(double6)));
	}

	public static BigDecimal formatToBigDecimal(final Double amount) {
		final DecimalFormat df = new DecimalFormat("#.00");
		// df.setRoundingMode(RoundingMode.FLOOR);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return BigDecimal.valueOf(Double.parseDouble((df.format(amount))));
	}

	public static double reverseFormatToDouble(final BigDecimal amount) {
		return 0;

	}

	/**
	 * format amount to Cardinal String format
	 *
	 * @param amount
	 * @return
	 */
	public static String formatToCardinalStringAmount(final Double amount) {
		final NumberFormat format = DecimalFormat.getInstance();
		// format.setRoundingMode(RoundingMode.FLOOR);
		format.setRoundingMode(RoundingMode.HALF_UP);
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setGroupingUsed(false);
		return format.format(amount).replace(".", "");
	}

	/**
	 * format amount to Cardinal Double format
	 *
	 * @param amount
	 * @return
	 */
	public static Double formatToCardinalDoubleAmount(final Double amount) {
		final DecimalFormat df = new DecimalFormat("#.00");
		// df.setRoundingMode(RoundingMode.FLOOR);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return Double.valueOf(df.format(amount));
	}
}
