/**
 * Tree23.java
 *
 * @author  Fujie Chen
 *
 * PURPOSE: This class is a 2-3 tree with insertion
 *          function.
 */

public class Tree23 {
  
  //Instance variables
  private Node23 root;
  
  //----------------------------------------------------------------
  
  public Tree23() {
    /**
     * Constructor of this class, create one empty 2-3 tree.
     *
     * @param       No parameter.
     *
     * @return      No return
     */
    root = null;
  }//Constructor
  
  //----------------------------------------------------------------
  
  public void insert(String value) {
    /**
     * Insert a String into the tree
     *
     * @param value   the value of data
     *
     * @return        No return 
     */
    root = insert(root, value);
  }//insert - public vision
  //----------------------------------------------------------------
  
  private Node23 insert(Node23 rt, String value) {
    /**
     * Insert a data into the given Node
     *
     * @param rt      The Node we want to insert
     *        value   The new data
     * @return        The node we inserted 
     */
    Node23 retval; //Temp
    if(rt == null) {
      //Empty tree: create a leaf node for root
      return new Node23(value, null, null, null, null);
    }//if
    if(rt.isLeaf()) {
      //At leaf node: insert here
      return rt.add(new Node23(value, null, null, null, null));
    }
    
    //Add to internal node
    if(value.compareTo(rt.getLVal()) <= 0) {
      //Insert left
      retval = insert(rt.getLChild(), value);
      if(retval == rt.getLChild())
        return rt;
      else
        return rt.add(retval);
    }//if
    else if((rt.getRVal() == null) || (value.compareTo(rt.getRVal()) <= 0)) {
      //Insert center
      retval = insert(rt.getCChild(), value);
      if(retval == rt.getCChild())
        return rt;
      else
        return rt.add(retval);
    }//else if
    else {
      //Insert right
      retval = insert(rt.getRChild(), value);
      if(retval == rt.getRChild())
        return rt;
      else
        return rt.add(retval);
    }//else
  }//insert - recursive
  
  //----------------------------------------------------------------

  public int getSplitNum() {
    /**
     * Get the split number
     *
     * @param      No parameter
     *
     * @return     The split number
     */
    if(root != null)
      return root.getSplit();
    return 0;
  }//getSplitNum
  
  //----------------------------------------------------------------

  public void resetSplitNum() {
    /**
     * Reset the split number
     *
     * @param      No parameter.
     *
     * @return     No returning.
     */
    if(root != null)
      root.resetSplit();
    else {
      //If the tree is empty, then new a empty node to reset split number
      //Because the split varible is static
      Node23 node = new Node23();
      node.resetSplit();
    }//else
  }//resetSplitNum
  
  //----------------------------------------------------------------
  
  public String toString() {
    /**
     * Handle the content of this class as String
     *
     * @param      No parameter.
     *
     * @return     The content of this class
     */
    String string  = "[ ";
    string += inOrder(root);
    if(string.length() > 2)
    string = string.substring(0, string.length()-2);
    string += " ]";
    return string;
  }//toString
  
  //----------------------------------------------------------------
  
  private String inOrder(Node23 currentNode) {
    /**
     * Get the in order result of this tree
     *
     * @param currentNode  The current node point for recursion.
     *
     * @return             The result
     */
    String value = "";
    if(currentNode != null) {
      if(currentNode.getLChild() != null)
        value += inOrder(currentNode.getLChild());
      if(currentNode.getLVal() != null)
        value += currentNode.getLVal() + ", ";
      if(currentNode.getCChild() != null)
        value +=inOrder(currentNode.getCChild());
      if(currentNode.getRVal() != null)
        value += currentNode.getRVal() + ", ";
      if(currentNode.getRChild() != null)
        value +=inOrder(currentNode.getRChild());
    }//if
    return value;
  }//inOrder
  
  //----------------------------------------------------------------
  
  public void print() {
    /**
     * Print out the whole tree in details
     *
     * @param      No parameter.
     *
     * @return     No returning.
     */
    print(root, 0, 0); //Call recursive method starting with root node
  }//print
  
  //----------------------------------------------------------------
  
  private void print(Node23 node, int level, int childNum) {
    /**
     * Recursive method for print out the current node details
     *
     * @param node        The current node we want to print out.
     *        level       The level of the current node in the tree
     *        childNum    The current node position in its parent
     *
     * @return            No returning.
     */
    //Print the level
    System.out.print("Level = " + level + " ");
    
    //Print the position of children
    if(level == 0)
      System.out.print("[root] "); //Print root
    else {
      //Is NOT root
      if(childNum == 0)
        System.out.print("[left] ");
      else if(childNum == 1)
        System.out.print("[middle] ");
      else
        System.out.print("[right] ");
    }//else
    
    //Print the value
    System.out.print("value = " + node + "\n");
    
    //Call ourselves for each child of this node
    if(node.getLChild() != null)
      print(node.getLChild(), level+1, 0);
    if(node.getCChild() != null)
      print(node.getCChild(), level+1, 1);
    if(node.getRChild() != null)
      print(node.getRChild(), level+1, 2);
    
  }//print-recursive
}//Tree23