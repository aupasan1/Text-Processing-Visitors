package wordCount.dsForStrings;

import wordCount.util.DebugLevel;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class BST {

	private BSTNode root;
	private BSTNode backUpRoot;

	/**
	 * Constructor of the BST class
	 */
	public BST() {
		root = null;
		backUpRoot = null;
		
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Calls the visit () method of the given visitor
	 * @param visitor
	 */
	public void accept(DSProcessingVisitorI visitor) {
		visitor.visit(this);
	}

	/**
	 * 
	 * Inserts the node in the original tree
	 * @param valueIn
	 */
	public void insert(String valueIn) {
		root = insert(root, valueIn);
	}

	/**
	 * @param root
	 * @param valueIn
	 * @return
	 */
	private BSTNode insert(BSTNode root, String valueIn) {
		String value = valueIn;

		if (root == null) {
			root = new BSTNode(value);
			Logger.writeMessage("Node inserted in Tree !!", DebugLevel.INSERT);
		} else if (value.compareTo(root.getValue()) < 0) {
			root.setLeft(insert(root.getLeft(), value));
		} else if (value.compareTo(root.getValue()) > 0) {
			root.setRight(insert(root.getRight(), value));
		} else {
			root.setCount(root.getCount() + 1);
		}
		return root;
	}
	
	/**
	 * Inserts the node in back up tree
	 * @param node
	 */
	public void insertBackup(BSTNode node) {
		backUpRoot = insertBackup(backUpRoot, node);
	}

	/**
	 * @param backUpRoot
	 * @param node
	 * @return
	 */
	private BSTNode insertBackup(BSTNode backUpRoot, BSTNode node) {

		if (backUpRoot == null) {
			backUpRoot = node;
			Logger.writeMessage("Node inserted in Tree !!", DebugLevel.INSERT);
		} else if (node.getValue().compareTo(backUpRoot.getValue()) < 0) {
			backUpRoot.setLeft(insertBackup(backUpRoot.getLeft(), node));
		} else if (node.getValue().compareTo(backUpRoot.getValue()) > 0) {
			backUpRoot.setRight(insertBackup(backUpRoot.getRight(), node));
		}
		
		return backUpRoot;
	}

	/**
	 * Traverses the trees and prints the nodes using an 
	 * in order traversal
	 * and prints the nodes
	 * @param fp
	 * 
	 */
	public void printTree(FileProcessor fp) {
		printTree(root, fp, 1);
		printTree(backUpRoot, fp, 2);
	}

	/**
	 * @param node
	 * @param fp
	 * @param value
	 */
	public void printTree(BSTNode node, FileProcessor fp, int value) {
		if (node != null) {
			printTree(node.getLeft(), fp, value);
			
			//Write the node count to the output file
			fp.writeToFile(node.getValue() + " " + node.getCount(), value);
			Logger.writeMessage(node.getValue() + " " + node.getCount(), DebugLevel.DISPLAY);
			
			printTree(node.getRight(), fp, value);
		}
	}

	/**
	 * @return the root
	 */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BSTNode rootIn) {
		root = rootIn;
	}

	/**
	 * @return the backUpRoot
	 */
	public BSTNode getBackUpRoot() {
		return backUpRoot;
	}

	/**
	 * @param backUpRoot the backUpRoot to set
	 */
	public void setBackUpRoot(BSTNode backUpRootIn) {
		backUpRoot = backUpRootIn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BST [root=" + root + ", backUpRoot=" + backUpRoot + "]";
	}
}