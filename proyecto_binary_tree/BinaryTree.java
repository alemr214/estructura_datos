package proyecto_binary_tree;

public class BinaryTree {
  Node root;

  public BinaryTree() {
    root = null;
  }

  public void printPreorder(Node node) {
    if (node == null)
      return;

    System.out.println("");
    System.out.print(node.item + " ");

    /* then recur on left subtree */
    printPreorder(node.left);

    /* now recur on right subtree */
    printPreorder(node.right);
  }

  public void printPreorder() {
    printPreorder(root);
  }

  public void printInorder(Node node) {
    if (node == null)
      return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    System.out.print(node.item + " ");

    /* now recur on right child */
    printInorder(node.right);
  }

  public void printInorder() {
    printInorder(root);
  }

  public void printPostorder(Node node) {
    if (node == null)
      return;

    // first recur on left subtree
    printPostorder(node.left);

    // then recur on right subtree
    printPostorder(node.right);

    // now deal with the node
    System.out.print(node.item + " ");
  }

  // Wrappers over above recursive functions
  public void printPostorder() {
    printPostorder(root);
  }

  public int height(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  public boolean exist(int busqueda) {
    return exist(this.root, busqueda);
  }

  private boolean exist(Node node, int busqueda) {
    if (node == null) {
      return false;
    }
    if (node.getItem() == busqueda) {
      return true;
    } else if (busqueda < node.getItem()) {
      return exist(node.getLeft(), busqueda);
    } else {
      return exist(node.getRight(), busqueda);
    }
  }

  public int countParents(Node node) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return 0;
    } else {
      return countParents(node.left) + countParents(node.right) + 1;
    }
  }

  public int leftHeight(Node node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.left;
    }
    return height;
  }

  public int rightHeight(Node node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.right;
    }
    return height;
  }

  public int totalNodes(Node root) {
    if (root == null)
      return 0;
    int leftHeight = leftHeight(root);
    int rightHeight = rightHeight(root);
    if (leftHeight == rightHeight) {
      return (1 << leftHeight) - 1;
    }
    return 1 + totalNodes(root.left) + totalNodes(root.right);
  }
}
