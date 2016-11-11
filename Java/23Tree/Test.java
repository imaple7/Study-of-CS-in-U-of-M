/**
 * Test.java
 * @author       Fujie Chen
 * @version      2015/07/11
 *
 * PURPOSE: This class will insert a sequence of strings from
 *          file into a 2-3 tree and display the tree after it is 
 *          complete.
 */
import java.util.Scanner;
import java.io.*;

public class Test {
  //The file address
  static final String TEST_ADDRESS = "test.dat";
  static final String SEARCH_ADDRESS = "a4q1search.txt";
  
  public static void main(String[] args) throws Exception{
    //Try a test
    Tree23 testTree = new Tree23();
    //Read each line from file
    BufferedReader read = new BufferedReader(new FileReader(TEST_ADDRESS));
    String nextLine = read.readLine();
    while(nextLine != null) {
      testTree.insert(nextLine); //Insert string into 2-3 tree
      printDetail(testTree);
      nextLine = read.readLine();
    }//while
    /*
    //Try the formal file
    Tree23 formalTree = new Tree23();
    formalTree.resetSplitNum(); //Reset the split number
    BufferedReader readFile = new BufferedReader(new FileReader(SEARCH_ADDRESS));
    String eachLine = readFile.readLine();
    while(eachLine != null) {
      formalTree.insert(eachLine);
      eachLine = readFile.readLine();
    }//while
    System.out.println("Final results:");
    printDetail(formalTree);
    */
    //Print out the result
    System.out.println("End of processing.");
  }//main
  
  static void printDetail(Tree23 tree) {
    /**
     * Print the details of the given 2-3 tree
     *
     * @param      The tree we want to display
     *
     * @return     No returning.
     */
    
    System.out.println(tree); 
    tree.print();
    System.out.println("\nNumber of splits: " + tree.getSplitNum() + "\n");
  }//printDetail
}//Test
