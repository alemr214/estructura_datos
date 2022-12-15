package proyecto_searching_methods.hashing_search;

import java.util.*;

class My_Dictionary {
  public static void main(String[] args) {
    // Key , Value
    Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Cuantos datos va a ingresar: ");
    int size = scanner.nextInt();
    // Llenado del diccionario
    for (int i = 0; i < size; i++) {
      int key;
      String value;
      System.out.println("Ingrese el valor de la llave en numero: ");
      key = scanner.nextInt();
      System.out.println("Ingrese el valor en letras");
      value = scanner.next();
      my_dict.put(key, value);
    }

    System.out.println("Ingrese el dato a buscar: ");
    int element = scanner.nextInt();

    if (my_dict.get(element) != null) {
      System.out.println("El elemento si existe con el valor: " + my_dict.get(element));
    } else {
      System.out.println("El elemento no se encuentra");
    }
    scanner.close();
  }
}