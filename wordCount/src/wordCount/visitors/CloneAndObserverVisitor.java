package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.BSTNode;
import wordCount.util.DebugLevel;
import wordCount.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class CloneAndObserverVisitor implements DSProcessingVisitorI{
	
	private BST tree;

	/**
	 * Constructor of the Clone and Observer visitor
	 */
	public CloneAndObserverVisitor() {
		
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.DSProcessingVisitorI#visit(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visit(BST treeIn) {
		tree = treeIn;
		createBackUp();
	}

	/**
	 * Creates the back up trees for original tree
	 */
	private void createBackUp() {
		createBackUp(tree.getRoot());
	}

	/**
	 * @param node
	 */
	private void createBackUp(BSTNode node) {
		if (node != null) {
			//Clone the original node
			BSTNode cloneNode = (BSTNode) node.clone();
			Logger.writeMessage("Node cloned in Tree !!", DebugLevel.CLONE);
			
			//Setup the subject and listener relationship
			node.registerObserver(cloneNode);
			
			//Add the cloned node to back up tree
			tree.insertBackup(cloneNode);
			createBackUp(node.getLeft());
			createBackUp(node.getRight());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CloneAndObserverVisitor [tree=" + tree + "]";
	}
}
