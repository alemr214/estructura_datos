package u1_ejercicio03;

public class Main {
  public static void main(String[] args) {
    int[][][] array = new int[10][20][30];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        for (int k = 0; k < array[i][j].length; k++) {
          array[i][j][k] = (int) (Math.random() * 10);
        }
      }
    }
    // Impresion
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        for (int k = 0; k < array[i][j].length; k++) {
          System.out.println("Valor de la posicion [" + i + "][" + j + "][" + k + "]: " + array[i][j][k]);
        }
      }
    }

  }
}
