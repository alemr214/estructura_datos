package proyecto_searching_methods.binary_search;

import java.util.Scanner;

public class Main {
  // Java implementation of recursive Binary Search
  // Returns index of x if it is present in arr[l..
  // r], else return -1
  int binarySearch(int array[], int l, int r, int x) {
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
    for (int i = 0; i < size; i++) {
      System.out.println("Ingrese un dato a guardar: ");
      int data = scanner.nextInt();
      array[i] = data;
    }
    System.out.println("Ingrese el elemento a buscar para ver si se encuentra: ");
    int element = scanner.nextInt();

    // int arra[] = { 2, 3, 4, 10, 40 };
    // int n = arr.length;
    // int x = 10;
    int result = bs.binarySearch(array, 0, size - 1, element);
    if (result == -1)
      System.out.println("Element not present");
    else
      System.out.println("Element found at index "
          + result);
    scanner.close();
  }
}
