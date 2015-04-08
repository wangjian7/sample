package util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	// Define a static logger variable so that it references the
	// Logger instance named "MyApp".
	private static final Logger logger1 = LogManager.getLogger(LogTest.class);
	private static final Logger logger2 = LogManager.getLogger("payment");

	public static void main(String[] args) {

		// Set up a simple configuration that logs on the console.

		logger1.trace("Entering application.");
		Bar bar = new Bar();
		if (!bar.doIt()) {
			logger1.error("Didn't do it.");
		}
		logger1.trace("Exiting application.");

	}

}
