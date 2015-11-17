import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barbearia
{
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
  
  
  
  public static ArrayList<Militar> processString(String str)
  {
    ArrayList<Militar> militars = new ArrayList<>();
    
    return militars; 
  }
  
  public static List<String> read(String path) throws FileNotFoundException
  {
    BufferedReader br = null;
    
    br = new BufferedReader(new FileReader(path));
    
    ArrayList<String> str;
    str = new ArrayList<>();
    String line;
    try
    {
      while((line = br.readLine()) !=null)
      {
        str.add(line);
      }
        }
    catch (IOException ex)
    {
      Logger.getLogger(Barbearia.class.getName()).log(Level.SEVERE, null, ex);
    }
    return str;
  }

  public static void main(String args[]) throws InterruptedException
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
    
    Militar m1 = new Militar(1, oficial);
    Militar m2 = new Militar(2, oficial);
    Militar m3 = new Militar(3, oficial);
    Militar m4 = new Militar(4, sargento);
    Militar m5 = new Militar(5, praca);
    
    List<Militar> militares = new ArrayList<Militar>();
    militares.add(m1);
    militares.add(m2);
    militares.add(m3);
    militares.add(m4);
    militares.add(m5);
    
    Thread produtor_fila = new Thread(new ProdutorFila(4, militares, fila_militares));
  
    b1.start();
    b2.start();
    b3.start();
    
    produtor_fila.start();
    
    /*Vector sharedQueue = new Vector();
    int size = 4;
    Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
    Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
    prodThread.start();
    consThread.start();*/
  }
}
