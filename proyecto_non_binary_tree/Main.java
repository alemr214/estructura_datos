package proyecto_non_binary_tree;

import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Crea un nuevo nodo con el tipo de dato Integer
    Node<Integer> root = new Node<Integer>(1);

    // Agrega un hijo
    root.addChild(new Node<Integer>(2));
    root.addChild(new Node<Integer>(3));
    root.addChildAt(1, new Node<Integer>(4));
    root.addChildAt(1, new Node<Integer>(5));
    Tree<Integer> tree = new Tree<Integer>(root);

    List<Node<Integer>> preOrder = tree.getPreOrderTraversal();
    List<Node<Integer>> postOrder = tree.getPostOrderTraversal();
    System.out.println("El preorden es: " + preOrder);
    System.out.println("El preorden es: " + postOrder);
    System.out.println("\nIngrese un elemento para buscarlo: ");
    int item = scanner.nextInt();
    boolean exist = tree.exists(item);
    if (exist) {
      System.out.println("El elemento " + item + " existe");

    } else {
      System.out.println("El elemento " + item + " no existe");
    }
    scanner.close();

  }
}
