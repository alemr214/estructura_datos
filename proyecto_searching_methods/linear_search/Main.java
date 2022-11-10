package proyecto_searching_methods.linear_search;

import java.util.Scanner;

public class Main {

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
    for (int i = 0; i < size; i++) {
      System.out.println("Ingrese un dato a guardar: ");
      int data = scanner.nextInt();
      array[i] = data;
    }
    System.out.println("Ingrese el elemento a buscar para ver si se encuentra: ");
    int element = scanner.nextInt();
    // int arr[] = { 2, 3, 4, 10, 40 };
    // int x = 10;
    int result = search(array, element);

    if (result == -1)
      System.out.print(
          "Element is not present in array");
    else
      System.out.print("Element is present at index "
          + result);
    scanner.close();
  }
}