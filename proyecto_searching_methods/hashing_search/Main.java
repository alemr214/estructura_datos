package proyecto_searching_methods.hashing_search;

import java.util.*;

class My_Dictionary {
  public static void main(String[] args) {
    // Key , Value
    Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el dato a buscar: ");
    int element = scanner.nextInt();

    // HashTable
    my_dict.put(5, "Apple");
    my_dict.put(10, "Banana");
    my_dict.put(3, "Pears");
    my_dict.put(1, "Watermelon");

    if (my_dict.get(element) != null)
      System.out.println("El elemento si existe con el valor: " + my_dict.get(element));
    scanner.close();
  }
}