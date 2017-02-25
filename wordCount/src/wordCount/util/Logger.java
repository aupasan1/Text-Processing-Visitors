package wordCount.util;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class Logger {

	private static DebugLevel debugLevel;

	/**
	 * Constructor of the Logger class
	 */
	public Logger() {
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Sets the current debug level
	 * @param levelIn the debug level to set
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.AVG_TIME;
			break;
		case 1:
			debugLevel = DebugLevel.DISPLAY;
			break;
		case 2:
			debugLevel = DebugLevel.UPDATE;
			break;
		case 3:
			debugLevel = DebugLevel.INSERT;
			break;
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 5:
			debugLevel = DebugLevel.CLONE;
		default:
			debugLevel = DebugLevel.AVG_TIME;
			break;
		}
	}

	/**
	 * This method prints the message passed as per the debug level
	 * 
	 * @param message the message to print
	 * @param levelIn the debug level set
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}