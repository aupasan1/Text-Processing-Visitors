package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.List;

import wordCount.util.DebugLevel;
import wordCount.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class BSTNode implements Cloneable, SubjectI, ObserverI {
	private String value;
	private int count;
	private BSTNode left;
	private BSTNode right;
	private List<ObserverI> observers;
	
	/**
	 * Constructor of the BST Node visitor
	 * @param valueIn
	 */
	public BSTNode(String valueIn) {
		value = valueIn;
		count = 1;
		left = null;
		right = null;
		observers = new ArrayList<ObserverI>();
		
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		
		BSTNode tree = null;
		try {
			tree = (BSTNode)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
		tree.left = null;
		tree.right = null;
		
		return tree;
	}

	/* (non-Javadoc)
	 * @see wordCount.dsForStrings.ObserverI#update(int)
	 */
	@Override
	public void update(int countIn) {
		this.setCount(countIn);
	}

	/* (non-Javadoc)
	 * @see wordCount.dsForStrings.SubjectI#registerObserver(wordCount.dsForStrings.ObserverI)
	 */
	@Override
	public void registerObserver(ObserverI observerIn) {
		observers.add(observerIn);
	}

	/* (non-Javadoc)
	 * @see wordCount.dsForStrings.SubjectI#removeObserver(wordCount.dsForStrings.ObserverI)
	 */
	@Override
	public void removeObserver(ObserverI observerIn) {
		observers.remove(observerIn);
	}

	/* (non-Javadoc)
	 * @see wordCount.dsForStrings.SubjectI#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		for(ObserverI ob : observers) {
			ob.update(this.getCount());
		}
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String valueIn) {
		value = valueIn;
	}
	
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * @param count the count to set
	 */
	public void setCount(int countIn) {
		count = countIn;
	}
	
	/**
	 * @return the left
	 */
	public BSTNode getLeft() {
		return left;
	}
	
	/**
	 * @param left the left node to set
	 */
	public void setLeft(BSTNode leftIn) {
		left = leftIn;
	}
	
	/**
	 * @return the right
	 */
	public BSTNode getRight() {
		return right;
	}
	
	/**
	 * @param right the right node to set
	 */
	public void setRight(BSTNode rightIn) {
		right = rightIn;
	}
	
	/**
	 * @return the observers
	 */
	public List<ObserverI> getObservers() {
		return observers;
	}

	/**
	 * @param observers the observers to set
	 */
	public void setObservers(List<ObserverI> observersIn) {
		observers = observersIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BSTNode [value=" + value + ", count=" + count + ", left="
				+ left + ", right=" + right + ", observers=" + observers + "]";
	}
}
