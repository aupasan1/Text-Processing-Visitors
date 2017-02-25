CS542 Design Patterns
Fall 2016
PROJECT <4> README FILE

Due Date: <PROJECT DUE DATE, IN FORMAT: Wednesday, November 23, 2016>
Submission Date: <DATE YOU SUBMIT, IN FORMAT: Wednesday, November 23, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <ABHISHEK NIRANJAN UPASANI>
e-mail(s): <aupasan1@binghamton.edu>

PURPOSE:

[
  The purpose of this project is to understand and implement the Visitor, Prototype and Observer
  Patterns in Java.
  
]

PERCENT COMPLETE:

[
  "I believe I have completed 100% of this project."
]

PARTS THAT ARE NOT COMPLETE:

[
  None
]

BUGS:

[
  None
]

FILES:

[
  Included with this project are 15 files:

  Driver.java, the main file associated with the program
  BST.java, the file associated with all the tree related operations
  BSTNode.java, the file associated with BST node attributes
  ObserverI.java, the file associated with updates
  SubjectI.java, the file associated with registering and removing observers
  DebugLevel.java, the file associated with Logger values
  Logger.java, the file associated with debugging
  FileProcessor.java, the file associated with file reading and writing
  CloneAndObserverVisitor.java, the file associated with cloning the nodes
  DSProcessingVisitorI.java, the file associated with various tree operations
  PopulateVisitor.java, the file associated with inserting the nodes
  UpdateValueVisitor.java, the file associated with updating the nodes
  WordCountVisitor.java, the file associated with counting the nodes
  build.xml, the file associated with cleaning, compiling and running the code
  README.txt the text file you are presently reading
]

SAMPLE OUTPUT:

[
  [java] Total time is 22 ms
]

TO UNTAR:
[
  tar -xvf upasani_abhishek_assign4.tar.gz
]

TO COMPILE:

[
  ant -buildfile build.xml all
]

TO RUN:

[
  ant -buildfile build.xml run  -Darg0=<input_file> -Darg1=<output_file> -Darg2=<NUM_ITERATIONS> -Darg3=<original_file> -Darg4=<backup_file>
]

TO GENERATE JAVADOCS:

[
  ant -buildfile build.xml docs
]

CHOICE OF DATA STRUCTURES:

[
  Binary search tree to insert and update the nodes. The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree. However, inorder traversal of the tree always
  produces the sorted output
  
  ArrayList to store the observer nodes. 
]

TESTING THE OBSERVER PATTERN:

[
  The notifyObservers() function in UpdateValueVisitor will notify the back up nodes of the update in original node.
  If the call to this function is commented (line 64 in UpdateValueVisitor.java), the two output files will differ in the count of nodes.
  This way, we can test that the observer pattern works correctly as both the output files will be same.
]

EXTRA CREDIT:

[
  "N/A" 
]


BIBLIOGRAPHY:

[
  For exception handling in reading and writing files
  https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
  
  For generating Javadocs using ANT
  http://javabeat.net/javadoc-ant-task/
  
  For tokenizing the input
  https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
]

ACKNOWLEDGEMENT:

[
  None
]