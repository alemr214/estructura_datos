package u1_ejercicio02;

public class Main {
  public static void main(String[] args) {
    int[][] array = new int[10][20];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = (int) (Math.random() * 10);
      }
    }
    // Impresion
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.println("Valor [" + i + "],[" + j + "]: " + array[i][j]);
      }
    }
  }
}
