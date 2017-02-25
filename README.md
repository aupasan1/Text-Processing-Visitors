# Text-Processing-Visitors

Design and develop the following 2 visitors:

o A visitor (Populate Visitor) that reads an input file, input.txt, and populates a data structure with all the words in the file. Use a data structure that will maximize performance for the second visitor. Store the words in the data structure using the insert criteria for that data structure.

o A second visitor (Word Count) that counts the number of words, number of distinct words, and number of characters (NOT distinct characters) stored by the data structure, and then stores it in a file named output.txt. Total number of characters should not take whitespaces into account. Also,

o If the input has the following words: the the the quick brown fox jumps jumps over the lazy dog , then the number of distinct words is 8, as the rest are repeated words.

o A third visitor (Clone-and-Observe-Visitor) that clones the data structure so that it can be used as a backup. You should setup the observer pattern's subject and listener relationship as part of the implementation of this visitor.

o Use the observer pattern, so that whenever any word is modified in the original data structure, the corresponding element (or whatever is used to store the word) of the backup data structure is notified and updated. You will be graded on how fine grained you can keep the updates. So, do not update the entire data structure, each time.

o The second visitor is supposed to be specialized in extracting information such as word count, etc. from the data structure. The first visitor should not do any work for the second visitor. So, you CANNOT use a separate data structure, outside the original data structure, to keep track of the word count. It is also NOT acceptable to keep a running count while populating the original data structure. So, your performance should depend on the choice of data structure, choice of data structure within each node/element to store information, and traversal through the data structure to calculate the total number of words, distinct words, and characters.

o In the driver code, call the two visitors and test the performance in the following manner:

    o	 long startTime = System.currentTimeMillis();
    o	 Start of loop N times
    o    Declare/instantiate the data structure and visitors
    o	 Code to visit with the PopulateVisitor
    o	 Code to visit with the WordCountVisitor.
    o	 End of loop N times
    o	 // the file should be open closed within the code in the loop. So, each iteration should overwrite the file.
    o	 long finishTime = System.currentTimeMillis();
    o	 Calculate total_time as (finishTime-startTime)/NUM_ITERATIONS.
    o	 Write the total_time value to stdout
    
o In the driver, after the timing loop, call a method using a test class, to show that the 3rd visitor works correctly. One way to do this it write another visitor that updates the integer value in all the nodes of the original tree. The updates should automatically notify the backup nodes via the observer pattern. Next, write to two different files the int values in the nodes using an inorder traversal of the trees. During the demo, do a "diff" of the two files to prove that your observer pattern worked.

o In the driver, after the timing loop, call a method from a test class, to show that the observer pattern for the backup works correctly.

o Use any whitespace as the criteria to delimit words.

o Assume that the input file will NOT contain any special characters.

o The following should be read from command line: input file name, output file name, and the value of NUM_ITERATIONS.

o Use the Logger class from any previous assignment along with your own debug scheme.
