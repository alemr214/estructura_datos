package u1_ejercicio04;

public class Main {
  private final int HABITACIONES = 16;
  private static int inquilinos = 76;
  private double renta = 0;

  public Main(int tarifa) {
    renta = tarifa * HABITACIONES / inquilinos;
  }

  public double getRenta() {
    return renta;
  }

  public static int getInquilinos() {
    return inquilinos;
  }

  public static void main(String[] args) {
    System.out.println("No. inquilinos: " + inquilinos);
    System.out.println("No. inquilinos: " + getInquilinos());

    // Memoria dinamica
    Main unidad = new Main(1400);

    System.out.println("No. habitaciones: " + unidad.HABITACIONES);
    System.out.println("Renta nominal: " + unidad.getRenta());
  }
}