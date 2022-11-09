package sorting_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  void bubbleSort(int array[]) {
    int size = array.length;
    for (int i = 0; i < size - 1; i++)
      for (int j = 0; j < size - i - 1; j++)
        if (array[j] > array[j + 1]) {
          int temporal = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temporal;
        }
  }

  static void swap(int[] array, int i, int j) {
    int temporal = array[i];
    array[i] = array[j];
    array[j] = temporal;
  }

  static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
      if (array[j] < pivot) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return (i + 1);
  }

  static void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }

  int shellSort(int array[]) {
    int n = array.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i += 1) {
        int temporal = array[i];
        int j;
        for (j = i; j >= gap && array[j - gap] > temporal; j -= gap)
          array[j] = array[j - gap];
        array[j] = temporal;
      }
    }
    return 0;
  }

  static int getMax(int array[], int size) {
    int max = array[0];
    for (int i = 1; i < size; i++)
      if (array[i] > max)
        max = array[i];
    return max;
  }

  static void countSort(int array[], int size, int exp) {
    int output[] = new int[size];
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);

    for (i = 0; i < size; i++)
      count[(array[i] / exp) % 10]++;

    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (i = size - 1; i >= 0; i--) {
      output[count[(array[i] / exp) % 10] - 1] = array[i];
      count[(array[i] / exp) % 10]--;
    }

    for (i = 0; i < size; i++)
      array[i] = output[i];
  }

  static void radixsort(int array[], int size) {
    int m = getMax(array, size);

    for (int exp = 1; m / exp > 0; exp *= 10)
      countSort(array, size, exp);
  }

  void merge(int array[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = array[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = array[m + 1 + j];

    int i = 0, j = 0;
    int k = l;

    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = R[j];
      j++;
      k++;
    }
  }

  void sort(int array[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      sort(array, l, m);
      sort(array, m + 1, r);

      merge(array, l, m, r);
    }
  }

  private static int nextGap(int gap) {
    if (gap <= 1)
      return 0;
    return (int) Math.ceil(gap / 2.0);
  }

  private static void inPlaceMerge(int[] nums, int start,
      int end) {
    int gap = end - start + 1;
    for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
      for (int i = start; i + gap <= end; i++) {
        int j = i + gap;
        if (nums[i] > nums[j])
          swap(nums, i, j);
      }
    }
  }

  static void mergeSort(int[] nums, int s, int e) {
    if (s == e)
      return;
    int mid = (s + e) / 2;

    mergeSort(nums, s, mid);
    mergeSort(nums, mid + 1, e);
    inPlaceMerge(nums, s, e);
  }

  void printArray(int array[]) {
    int size = array.length;
    for (int i = 0; i < size; ++i)
      System.out.print(array[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) {
    Main ua = new Main();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Cuantos datos va a ingresar?");
    int size = scanner.nextInt();
    int array[] = new int[size];
    int data = 0, option = 0;
    for (int i = 0; i < size; ++i) {
      System.out.println("Ingrese el valor:");
      data = scanner.nextInt();
      array[i] = data;
    }
    // Testing
    // int array[] = { 1, 21, 10, 902, 1, 0, 124, 10 };
    // int size = array.length;
    do {
      System.out.println(
          "Elige tu metodo de ordenamiento:\n1.Burbuja\n2.QuickSort\n3.ShellSort\n4.RadixSort\n5.Intercalacion\n6.Mezcla\n7.Salir");
      option = scanner.nextInt();
      switch (option) {
        case 1:
          System.out.println("Estructura original: " + Arrays.toString(array));
          ua.bubbleSort(array);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 2:
          System.out.println("Estructura original: " + Arrays.toString(array));
          quickSort(array, 0, size - 1);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 3:
          System.out.println("Estructura original: " + Arrays.toString(array));
          ua.shellSort(array);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 4:
          System.out.println("Estructura original: " + Arrays.toString(array));
          radixsort(array, size);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 5:
          System.out.println("Estructura original: " + Arrays.toString(array));
          ua.sort(array, 0, size - 1);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 6:
          System.out.println("Estructura original: " + Arrays.toString(array));
          mergeSort(array, 0, size - 1);
          System.out.print("Estrcutura ordenada: ");
          ua.printArray(array);
          System.exit(0);
          break;
        case 7:
          System.exit(0);
          break;
        default:
          System.out.println("Opcion incorrecta");
          System.exit(0);
          break;
      }
    } while (option != 7);
    scanner.close();
  }

}