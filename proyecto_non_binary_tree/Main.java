package proyecto_non_binary_tree;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Create a new Integer type node
    Node<Integer> root = new Node<Integer>(1);

    // Add a child
    root.addChild(new Node<Integer>(2));

    // Create a tree, providing the root node
    Tree<Integer> tree = new Tree<Integer>(root);

    // Get the pre-order traversal
    List<Node<Integer>> preOrder = tree.getPreOrderTraversal();
    System.out.println(preOrder);

  }
}
