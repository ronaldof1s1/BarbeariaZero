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
  
  public static int totalSize; // Número de pessoas esperando dentro da barbearia
  public static int rejected;  // Número de pessoas que não puderam entrar na barbearia

  public static int oficiais_atendidos;  // Número de oficiais atendidos
  public static int sargentos_atendidos; // Número de sargentos atendidos
  public static int pracas_atendidos; 	 // Número de praças atendidos

  public static Fila oficiais;
  public static Fila sargentos;
  public static Fila pracas;

  public static Barbeiro barbeiro_oficial;
  public static Barbeiro barbeiro_sargento;
  public static Barbeiro barbeiro_praca;
  
  
  
  public static void main(String args[]) throws InterruptedException
  {
    oficiais = new Fila(1);
    sargentos = new Fila(2);
    pracas = new Fila(3);

    barbeiro_oficial = new Barbeiro(1);
    barbeiro_sargento = new Barbeiro(2);
    barbeiro_praca = new Barbeiro(3);
    
    
    System.out.println("OI");
  }
}
