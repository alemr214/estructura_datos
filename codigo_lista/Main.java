package codigo_lista;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static LinkedList<Integer> addElements(LinkedList<Integer> list, int element) {
    list.add(element);
    return list;
  }

  public static LinkedList<Integer> removeElements(LinkedList<Integer> list) {
    while (!list.isEmpty()) {
      list.remove();
    }
    return list;
  }

  public static LinkedList<Integer> printElements(LinkedList<Integer> list) {
    return list;
  }

  public static boolean isEmpty(LinkedList<Integer> list) {
    if (list.isEmpty()) {
      return true;
    }
    return false;
  }

  public static int size(LinkedList<Integer> list) {
    int counter = 0;
    while (!list.isEmpty()) {
      counter++;
      list.remove();
    }
    return counter;
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    LinkedList<Integer> list = new LinkedList<Integer>();
    int option = 0;
    System.out.println(
        "Menu de opciones\n1. Agregar elementos\n2. Eliminar elementos\n3. Imprimir los elementos\n4. Checar llenado\n5. Cantidad elementos\n6. Salir");
    do {
      option = entrada.nextInt();
      switch (option) {
        case 1:
          list = addElements(list, entrada.nextInt());
          break;
        case 2:
          list = removeElements(list);
          break;
        case 3:
          System.out.println(list);
          break;
        case 4:
          System.out.println(isEmpty(list));
          break;
        case 5:
          System.out.println(size(list));
          break;
        default:
          System.out.println("Opcion invalido");
          break;
      }
    } while (option != 6);
    entrada.close();
  }
}