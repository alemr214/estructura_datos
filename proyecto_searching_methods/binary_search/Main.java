package proyecto_searching_methods.binary_search;

import java.util.Scanner;

public class Main {

  public void bubbleSort(int array[]) {
    int size = array.length;
    for (int i = 0; i < size - 1; i++)
      for (int j = 0; j < size - i - 1; j++)
        if (array[j] > array[j + 1]) {
          int temporal = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temporal;
        }
  }

  public int binarySearch(int array[], int l, int r, int x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;
      if (array[mid] == x)
        return mid;
      if (array[mid] > x)
        return binarySearch(array, l, mid - 1, x);
      return binarySearch(array, mid + 1, r, x);
    }
    return -1;
  }

  public static void main(String args[]) {
    Main bs = new Main();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese la cantidad de datos a guardar: ");
    int size = scanner.nextInt();
    int array[] = new int[size];

    // LLenado del arreglo
    for (int i = 0; i < size; i++) {
      System.out.println("Ingrese un dato a guardar: ");
      int data = scanner.nextInt();
      array[i] = data;
    }

    bs.bubbleSort(array);
    System.out.println("Ingrese el elemento a buscar para ver si se encuentra: ");
    int element = scanner.nextInt();

    int result = bs.binarySearch(array, 0, size - 1, element);
    if (result == -1)
      System.out.println("El elemento no se encuentra en el arreglo");
    else
      System.out.println("El elemento se encuentra en la posicion: "
          + result);
    scanner.close();
  }
}
