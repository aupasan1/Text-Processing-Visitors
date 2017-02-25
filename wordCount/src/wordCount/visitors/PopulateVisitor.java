package wordCount.visitors;

import java.util.StringTokenizer;

import wordCount.dsForStrings.BST;
import wordCount.util.DebugLevel;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class PopulateVisitor implements DSProcessingVisitorI {

	private FileProcessor fp;
	private BST tree;
	
	/**
	 * Constructor of the Populate visitor
	 * @param fpIn
	 */
	public PopulateVisitor(FileProcessor fpIn) {
		fp = fpIn;
		
		Logger.writeMessage("Constructor of Logger class", DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see wordCount.visitors.DSProcessingVisitorI#visit(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visit(BST treeIn) {
		tree = treeIn;
		String line = null;
		StringTokenizer st =null;
		
		while ((line = fp.readInputFile()) != null) {
			
			//Split the line by spaces
			st = new StringTokenizer(line, "[ \t\n]+");
			
			//Insert all the tokens in the tree
			while(st.hasMoreTokens()) {
				tree.insert(st.nextToken());
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PopulateVisitor [fp=" + fp + ", tree=" + tree + "]";
	}
}