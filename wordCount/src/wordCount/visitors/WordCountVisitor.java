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
public class WordCountVisitor implements DSProcessingVisitorI {
	
	private FileProcessor fp;
	private BST tree;

	private int totalWords;
	private int distinctWords;
	private int totalCharacters;


	/**
	 * Constructor of the Word count visitor
	 * @param fpIn
	 */
	public WordCountVisitor(FileProcessor fpIn) {
		fp = fpIn;
		
		totalWords = 0;
		distinctWords = 0;
		totalCharacters = 0;

		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.DSProcessingVisitorI#visit(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visit(BST treeIn) {
		tree = treeIn;
		String result = null;
	
		//Calculate the word count
		result = wordCount();
		
		//Write the result to the file
		fp.writeToFile(result, 0);
	}
	
	/**
	 * Returns the total word count, distinct words and total 
	 * characters in the tree
	 * @return result
	 */
	private String wordCount() {
		StringBuilder result = new StringBuilder();
		wordCount(tree.getRoot());
		result.append("Number of distinct words: " + distinctWords
				+ "\nNumber of characters: " + totalCharacters
				+ "\nTotal words: " + totalWords);
		return result.toString();
	}

	/**
	 * @param node
	 * @param counts
	 */
	private void wordCount(BSTNode node) {
		if (node != null) {
			wordCount(node.getLeft());
			
			//Calculate the total words, distinct words and total characters
			distinctWords += 1;
			totalCharacters += node.getCount() * node.getValue().length();
			totalWords += node.getCount();
			
			wordCount(node.getRight());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WordCountVisitor [fp=" + fp + ", tree=" + tree + "]";
	}
}