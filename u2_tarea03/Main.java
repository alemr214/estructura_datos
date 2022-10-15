package u2_tarea03;

import java.util.Scanner;

public class Main {
  public static int invertirNum(int num, int pos) {
    if (num < 10) {
      return num;
    } else {
      return (num % 10) * (int) Math.pow(10, pos) + (invertirNum(num / 10, pos - 1));
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Ingresa un numero menor de 1000 para invertirlo");
    int num = entrada.nextInt();
    System.out.println(invertirNum(num, 2));
    entrada.close();
  }
}
