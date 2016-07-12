/**
 * Node23.java
 *
 * @author  Fujie Chen
 *
 * PURPOSE: This class is a Node class for 2-3 tree.
 */

public class Node23 {
  
  //Instance variables
  private String lval;       //Left value
  private String rval;       //Right value
  private Node23 left;         //Left child
  private Node23 center;       //Middle child
  private Node23 right;        //Right child
  
  private static int split = 0; //Calculate the split number
  
  //----------------------------------------------------------------
  
  public Node23() {
    /**
     * Constructor of this class, create one empty Node.
     *
     * @param       No parameter.
     *
     * @return      No returning.
     */
    left = null;
    center = null;
    right = null;
    lval = null;
    rval = null;
  }//Constructor - 1
  
  //----------------------------------------------------------------
  
  public Node23(String lv, String rv, Node23 p1, Node23 p2, Node23 p3) {
    /**
     * Constructor of this class, create one Node.
     *
     * @param lv    Left value;
     *        rv    Right value;
     *        p1    Left point
     *        p2    Middle point
     *        p3    Right point
     *
     * @return      No returning.
     */
    left = p1;
    center = p2;
    right = p3;
    lval = lv;
    rval = rv;
  }//Constructor - 2
  
  //----------------------------------------------------------------
  
  public Node23 getLChild() {
    /**
     * Get the left child
     *
     * @param      No parameter
     *
     * @return     the left child
     */
    return left;
  }//getLChild
  
  //----------------------------------------------------------------
  
  public Node23 getRChild() {
    /**
     * Get the right child
     *
     * @param      No parameter
     *
     * @return     the right child
     */
    return right;
  }//getRChild
  
  //----------------------------------------------------------------
  
  public Node23 getCChild() {
    /**
     * Get the center child
     *
     * @param      No parameter
     *
     * @return     the center child
     */
    return center;
  }//getCChild
  
  //----------------------------------------------------------------
  
  public String getLVal() {
    /**
     * Get the left value
     *
     * @param      No parameter
     *
     * @return     the left value
     */
    return lval;
  }//getLVal
  
  //----------------------------------------------------------------
  
  public String getRVal() {
    /**
     * Get the right value
     *
     * @param      No parameter
     *
     * @return     the right value
     */
    return rval;
  }//getRVal

  //----------------------------------------------------------------
  
  public void setLeft(String value) {
    /**
     * Reset the left value
     *
     * @param      the left value
     *
     * @return     No returning
     */
    lval = value;
  }//setLeft
  
  //----------------------------------------------------------------
  
  public void setRight(String value) {
    /**
     * Reset the right value
     *
     * @param      the right value
     *
     * @return     No returning
     */
    rval = value;
  }//setRight
  
  //----------------------------------------------------------------
  
  public void setLeftChild(Node23 point) {
    /**
     * Reset the left child
     *
     * @param      the new point
     *
     * @return     No returning
     */
    left = point;
  }//setLeftChild
  
  //----------------------------------------------------------------
  
  public void setCenterChild(Node23 point) {
    /**
     * Reset the center child
     *
     * @param      the new point
     *
     * @return     No returning
     */
    center = point;
  }//setLeftChild
  
  //----------------------------------------------------------------
  
  public void setRightChild(Node23 point) {
    /**
     * Reset the right child
     *
     * @param      the new point
     *
     * @return     No returning
     */
    right = point;
  }//setLeftChild
  
  //----------------------------------------------------------------
  
  public boolean isLeaf() {
    /**
     * Determine this node is or not leaf
     *
     * @param      No parameter
     *
     * @return     The node is or not leaf
     */
    return left == null;
  }//isLeaf
  
  //----------------------------------------------------------------
  
  public Node23 add(Node23 newNode) {
    /**
     * Add a new value into this node
     *
     * @param newNode   The node containing the new value
     *
     * @return          The new modified node
     */
    if(rval == null) {
      //Only one key, add here
      if(lval.compareTo(newNode.getLVal()) < 0) {
        rval = newNode.getLVal();
        right = center;
        center = newNode.getCChild();
      }//if
      else {
        rval = lval;
        right = center;
        lval = newNode.getLVal();
        center = newNode.getCChild();
      }//else
      return this;
    }//if
    else if(lval.compareTo(newNode.getLVal()) >= 0) {
      //Add left
      Node23 temp = new Node23(lval, null, newNode, this, null);
      newNode.setLeftChild(left);
      left = center;
      center = right;
      right = null;
      lval = rval;
      rval = null;
      split++;
      return temp;
    }//else if
    else if(rval.compareTo(newNode.getLVal()) >= 0) {
      //Add center
      newNode.setCenterChild(new Node23(rval, null, newNode.getCChild(), right, null));
      newNode.setLeftChild(this);
      rval = null;
      right = null;
      split++;
      return newNode;
    }//else if
    else {
      //Add right
      Node23 temp = new Node23(rval, null, this, newNode, null);
      newNode.setLeftChild(right);
      right = null;
      rval = null;
      split++;
      return temp;
    }//else
  }//add
  
  //----------------------------------------------------------------
  
  public int getSplit() {
    /**
     * Get the split number
     *
     * @param      No parameter
     *
     * @return     the split number
     */
    return split;
  }//getSplit
  
  //----------------------------------------------------------------

  public void resetSplit() {
    /**
     * Reset the split number
     *
     * @param      No parameter.
     *
     * @return     No returning.
     */
    
    split = 0;
    
  }//resetSplit
  
  //----------------------------------------------------------------
  
  public String toString() {
    /**
     * Handle the content of this class as String
     *
     * @param      No parameter.
     *
     * @return     The content of this class
     */
    String print = "";
    if(lval != null)
      print += lval;
    if(rval != null)
      print += "/" + rval;
    return print;
  }//toString
  
}//Node23