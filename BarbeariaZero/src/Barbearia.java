/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Thread;
/**
 *
 * @author ronaldofs
 */
public class Barbearia
{
  
  public static int totalSize;
  
  public static Fila oficiais;
  public static Fila sargentos;
  public static Fila pracas;
  public static Barbeiro b1;
  public static Barbeiro b2;
  public static Barbeiro b3;
  
  
  
  public static void main(String args[]) throws InterruptedException
  {
    oficiais = new Fila(1);
    sargentos = new Fila(2);
    pracas = new Fila(3);
    b1 = new Barbeiro(1);
    b2 = new Barbeiro(2);
    b3 = new Barbeiro(3);
    
    
    System.out.println("OI");
  }
}
