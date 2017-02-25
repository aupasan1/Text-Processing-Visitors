package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-11-14
 * 
 */
public class FileProcessor {

	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private FileWriter fw1;
	private FileWriter fw2;
	private BufferedWriter bw;
	private BufferedWriter bw1;
	private BufferedWriter bw2;
	
	/**
	 * Constructor of the File processor class
	 * @param frIn
	 * @param fwIn
	 */
	public FileProcessor(FileReader frIn, FileWriter fwIn) {

		fr = frIn;
		fw = fwIn;
		br = new BufferedReader(fr);
		bw = new BufferedWriter(fw);

		Logger.writeMessage("Constructor of FileProcessor class", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 * @param fw1In
	 * @param fw2In
	 */
	public FileProcessor(FileWriter fw1In, FileWriter fw2In) {
		fw1 = fw1In;
		fw2 = fw2In;
		bw1 = new BufferedWriter(fw1);
		bw2 = new BufferedWriter(fw2);
	}

	/**
	 * This method reads a single line from a file
	 * 
	 * @return line 
	 * @throws IOException On input error
	 * @see IOException
	 */
	public String readInputFile(){

		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
		
		return line;
	}
	
	/**
	 * This method writes a single line to a file
	 * 
	 * @param lineIn
	 * @throws IOException On input error
	 * @see IOException
	 */
	public void writeToFile(String lineIn, int valueIn){

		try {
			switch (valueIn) {
			case 0:
				bw.write(lineIn);
				break;
			case 1:
				bw1.write(lineIn);
				bw1.newLine();
				break;
			case 2:
				bw2.write(lineIn);
				bw2.newLine();
				break;
			default:
				System.out.println("Invalid argument !!");
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	/**
	 * This method closes any open files
	 * @throws IOException
	 * @see IOException
	 */
	public void closeFile() {
		try {
			if (br != null) {
				br.close();
			}
			if(bw != null) {
				bw.close();
			}
			if(bw1 != null) {
				bw1.close();
			}
			if(bw2 != null) {
				bw2.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileProcessor [fr=" + fr + ", br=" + br + ", fw=" + fw
				+ ", fw1=" + fw1 + ", fw2=" + fw2 + ", bw=" + bw + ", bw1="
				+ bw1 + ", bw2=" + bw2 + "]";
	}
}