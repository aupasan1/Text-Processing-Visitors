package wordCount.dsForStrings;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public interface ObserverI {
	
	/**
	 * Updates the count with the given count value
	 * @param countIn
	 */
	public void update(int countIn);
}
