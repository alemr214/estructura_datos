package proyecto_pila;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int randomNumber = (int) Math.random() * 10;
    // Creacion de la pila doble
    TwoStacks twoStacks = new TwoStacks(size);
    for (int i = 0; i < size; i++) {
      System.out.println("Agrega la posicion del participante: ");
      int data = scanner.nextInt();
      if (i % 3 == 0) {
        // Agrega a la primera pila
        twoStacks.push1(data);
      } else {
        // Agrega a la segunda pila
        twoStacks.push2(data);
      }
    }
    System.out.print("Participante elimando de la primera parte " + " : " + twoStacks.pop1() + "\n");
    twoStacks.push2(randomNumber);
    System.out.print("Participante eeliminados de la segunda parte " + ": " + twoStacks.pop2() + "\n");
    scanner.close();
  }
}

// This code is contributed by aashish1995
