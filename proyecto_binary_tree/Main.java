package proyecto_binary_tree;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("\nEl preorden es: ");
    tree.printPreorder();
    System.out.println("\nEl postorden es: ");
    tree.printPostorder();
    System.out.println("\nEl indorden es: ");
    tree.printInorder();
    System.out.println("\nLa altura del arbol es: " + tree.height(tree.root));
    System.out.println("Hay " + tree.countParents(tree.root) + " numero de padres");
    System.out.println("Hay " + tree.totalNodes(tree.root) + " numero de nodos");
    System.out.println("\nIngrese un dato para buscar");
    int item = scanner.nextInt();
    if (tree.exist(item)) {
      System.out.println("El valor: " + item + " existe");
    } else {
      System.out.println("El valor: " + item + " no existe");
    }
    scanner.close();
  }
}
