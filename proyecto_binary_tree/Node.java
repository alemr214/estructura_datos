package proyecto_binary_tree;

public class Node {
  int item;
  Node left, right;

  public Node(int item) {
    this.item = item;
    left = right = null;
  }

  public int getItem() {
    return item;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public void printItem() {
    System.out.println(this.getItem());
  }
}
