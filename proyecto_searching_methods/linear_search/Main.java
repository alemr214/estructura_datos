package proyecto_searching_methods.linear_search;

import java.util.Scanner;

public class Main {

  // Ordena el arreglo
  public static void bubbleSort(int array[]) {
    int size = array.length;
    for (int i = 0; i < size - 1; i++)
      for (int j = 0; j < size - i - 1; j++)
        if (array[j] > array[j + 1]) {
          int temporal = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temporal;
        }
  }

  // Hace la busqueda lineal
  public static int search(int array[], int element) {
    int size = array.length;
    for (int i = 0; i < size; i++) {
      if (array[i] == element)
        return i;
    }
    return -1;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de datos a guardar: ");
    int size = scanner.nextInt();
    int array[] = new int[size];

    // Llenado del arreglo
    for (int i = 0; i < size; i++) {
      System.out.println("Ingrese un dato a guardar: ");
      int data = scanner.nextInt();
      array[i] = data;
    }

    bubbleSort(array);

    System.out.println("Ingrese el elemento a buscar para ver si se encuentra: ");
    int element = scanner.nextInt();
    int result = search(array, element);

    if (result == -1)
      System.out.print(
          "El elemento no se encuentra en el arreglo");
    else
      System.out.print("El elemento se encuentra en la posicion "
          + result);
    scanner.close();
  }
}