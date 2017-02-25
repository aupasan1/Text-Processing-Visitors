package wordCount.dsForStrings;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public interface SubjectI {
	
	/**
	 * Register the given observer
	 * @param observerIn
	 */
	public void registerObserver(ObserverI observerIn);
	
	/**
	 * Remove the given observer
	 * @param observerIn
	 */
	public void removeObserver(ObserverI o);
	
	/**
	 * Notify the observers
	 */
	public void notifyObservers();
}
