package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.BSTNode;
import wordCount.util.DebugLevel;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class UpdateValueVisitor implements DSProcessingVisitorI {
	
	private BST tree;
	private FileProcessor fp;
	
	/**
 	 * Constructor of the Update value visitor
	 * @param fpIn
	 */
	public UpdateValueVisitor(FileProcessor fpIn) {
		fp = fpIn;
		
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see wordCount.visitors.DSProcessingVisitorI#visit(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visit(BST treeIn) {
		tree = treeIn;
		int updateVal = 1;
		
		//Update the tree using update value
		updateValue(updateVal);
		
		//Print both the trees
		tree.printTree(fp);
	}

	/**
	 * Updates the node counts by the update value given
	 * @param updateValueIn
	 */
	private void updateValue(int updateValueIn) {
		updateValue(tree.getRoot(), updateValueIn);
	}

	/**
	 * @param node
	 * @param updateValueIn
	 */
	private void updateValue(BSTNode node, int updateValueIn) {
		if (node != null) {
			//Update the original node count
			node.setCount(node.getCount() + updateValueIn);
			Logger.writeMessage("Node updated in Tree !!", DebugLevel.UPDATE);
			
			//Notify the observers about the update
			node.notifyObservers();
			
			updateValue(node.getLeft(), updateValueIn);
			updateValue(node.getRight(), updateValueIn);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateValueVisitor [tree=" + tree + ", fp=" + fp + "]";
	}
}