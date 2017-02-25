package wordCount.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.dsForStrings.BST;
import wordCount.util.DebugLevel;
import wordCount.util.FileProcessor;
import wordCount.visitors.CloneAndObserverVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.UpdateValueVisitor;
import wordCount.visitors.WordCountVisitor;
import wordCount.util.Logger;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class Driver {

	private static String inputFile;
	private static String outputFile;
	private static String originalFile;
	private static String backUpFile;
	private static int NUM_ITERATIONS;
	private static int DEBUG_VALUE;
	
	/**
	 * Driver code to run the program
	 * 
	 * @param args the argument set 
	 */
	public static void main(String[] args) {

		//Validate the arguments
		if(!validate(args)) {
			System.err.println("Usage: java Driver input.txt output.txt NUM_ITERATIONS first.txt second.txt");
			System.exit(1);
		} else {
	
			FileProcessor fp = null;
			FileReader fr = null;
			FileWriter fw = null, fw1 = null, fw2 = null;
			BST tree = null;

			DEBUG_VALUE = 0;
			Logger.setDebugValue(DEBUG_VALUE);
			
			long startTime = System.currentTimeMillis();
			
			//Call the visitors and test performance
			for (int i = 0; i < NUM_ITERATIONS; i++) {
				try {
					
					//Instantiate the data structure and visitors
					tree = new BST();
					fr = new FileReader(inputFile);
					fw = new FileWriter(outputFile);
					fp = new FileProcessor(fr, fw);

					//Populate visitor
					DSProcessingVisitorI ptVisitor = new PopulateVisitor(fp);
					tree.accept(ptVisitor);

					//Word count visitor
					DSProcessingVisitorI wcVisitor = new WordCountVisitor(fp);
					tree.accept(wcVisitor);
					
				} catch (FileNotFoundException e) {
					System.err.println("Unable to open file '" + inputFile + "'");
					System.exit(1);
				} catch (IOException e) {
					System.err.println("Unable to write to file '" + outputFile + "'");
					System.exit(1);
				} finally {
					fp.closeFile();
				}
			}

			//Calculate total time time
			long finishTime = System.currentTimeMillis();
			long total_time = (finishTime - startTime) / NUM_ITERATIONS;
			Logger.writeMessage("Total time is " + String.valueOf(total_time) + " ms", DebugLevel.AVG_TIME);
			
			//Clone and Observer visitor
			DSProcessingVisitorI clVisitor = new CloneAndObserverVisitor();
			tree.accept(clVisitor);
	
			//Update visitor
			try {
				fw1 = new FileWriter(originalFile);
				fw2 = new FileWriter(backUpFile);
				fp = new FileProcessor(fw1, fw2);
				
				DSProcessingVisitorI upVisitor = new UpdateValueVisitor(fp);
				tree.accept(upVisitor);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} finally {
				fp.closeFile();
			}			
		}
	}

	/**
	 * 
	 * This function validates the command line arguments
	 * 
	 * @param args
	 * @return flag
	 */
	private static boolean validate(String[] args) {
		
		boolean flag = true;
		
		//Validate the command line arguments
		if(args.length != 5) {
			flag = false;
		} else {
			
			//Read the command line arguments
			inputFile = args[0];
			outputFile = args[1];
			NUM_ITERATIONS = Integer.parseInt(args[2]);
			originalFile = args[3];
			backUpFile = args[4];

			//Validate number of iterations
			if (NUM_ITERATIONS < 1) {
				System.err.println("Invalid number of iterations !!");
				System.exit(1);
			}
		}
		return flag;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Driver []";
	}
}