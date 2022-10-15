package u1_ejercicio01;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] array = new int[15];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    System.out.println(Arrays.toString(array));
  }
}