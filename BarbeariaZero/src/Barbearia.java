import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

public class Barbearia
{
  public static int tamanhoFila = 0;
  public static int totalClientes = 0;
  
  public static Patente oficial = new Patente(1, "Oficial");
  public static Patente sargento = new Patente(2, "Sargento");
  public static Patente praca = new Patente(3, "Praça");
  public static Patente pausa = new Patente(0, "Pausa");
  
  public static Fila fila_oficiais;
  public static Fila fila_sargentos;
  public static Fila fila_pracas;
  
  public static Barbeiro b1;
  public static Barbeiro b2;
  public static Barbeiro b3;

  public static void main(String args[]) throws InterruptedException, FileNotFoundException
  {    
    fila_oficiais = new Fila(oficial);
    fila_sargentos = new Fila(sargento);
    fila_pracas = new Fila(praca);
    
    List<Fila> fila_militares = new ArrayList<Fila>();
    fila_militares.add(fila_oficiais);
    fila_militares.add(fila_sargentos);
    fila_militares.add(fila_pracas);
    
    Thread b1 = new Thread(new Barbeiro(oficial, fila_militares));
    Thread b2 = new Thread(new Barbeiro(sargento, fila_militares));
    Thread b3 = new Thread(new Barbeiro(praca, fila_militares));
    
    List<Patente> patentes = new ArrayList<Patente>();
    patentes.add(pausa);
    patentes.add(oficial);
    patentes.add(sargento);
    patentes.add(praca);
    
    List<Militar> militares = ParserEntrada.getMilitares("BarbeariaZero/src/input.in", patentes);
    totalClientes = militares.size();
    
    Thread produtor_fila = new Thread(new ProdutorFila(20, militares, fila_militares));
    
    Estatistica.totalClientes();
  
    b1.start();
    b2.start();
    b3.start();
    
    produtor_fila.start();
  }
}
