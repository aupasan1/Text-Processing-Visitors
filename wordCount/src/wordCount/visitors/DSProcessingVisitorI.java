package wordCount.visitors;

import wordCount.dsForStrings.BST;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public interface DSProcessingVisitorI {
	
	/**
	 * @param treeIn
	 */
	public void visit(BST treeIn);
}
