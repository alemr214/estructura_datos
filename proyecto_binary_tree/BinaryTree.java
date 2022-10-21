package proyecto_binary_tree;

public class BinaryTree {
  // Crea la raiz
  Node root;

  // Constructor del arbol
  public BinaryTree() {
    root = null;
  }

  // Metodo que muestra el preorden
  public void printPreorder(Node node) {
    if (node == null)
      return;

    System.out.println("");
    System.out.print(node.item + " ");

    printPreorder(node.left);

    printPreorder(node.right);
  }

  // Metodo que inicializa el preorden
  public void printPreorder() {
    printPreorder(root);
  }

  // Metodo que muestra el inorden
  public void printInorder(Node node) {
    if (node == null)
      return;

    printInorder(node.left);

    System.out.print(node.item + " ");

    printInorder(node.right);
  }

  // Metodo que inicializa el inorden
  public void printInorder() {
    printInorder(root);
  }

  // Metodo que muestra el postorden
  public void printPostorder(Node node) {
    if (node == null)
      return;

    printPostorder(node.left);

    printPostorder(node.right);

    System.out.print(node.item + " ");
  }

  // Metodo que inicializa el postorden
  public void printPostorder() {
    printPostorder(root);
  }

  // Metodo que calcula la altura del arbol
  public int height(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  // Metodo que muestra la existencia de un nodo
  public boolean exist(int busqueda) {
    return exist(this.root, busqueda);
  }

  // Metodo que busca la existencia de un nodo
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

  // Cuenta cuantos nodos pares hay
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

  // Cuenta la altura de los nodos de la derecha
  public int leftHeight(Node node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.left;
    }
    return height;
  }

  // Cuenta la altura de los nodos de la izquierda
  public int rightHeight(Node node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.right;
    }
    return height;
  }

  // Cuenta cuantos nodos hay en total
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
