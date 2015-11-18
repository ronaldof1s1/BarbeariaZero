import java.io.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
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

  
  
  
  public static ArrayList<Militar> processString(ArrayList<String> str)
  {
    ArrayList<Militar> militars = new ArrayList<>();
    Militar m;
    int tempo;
    
    int k = 1;
    for(int i = 0; i < str.size(); i++)
    {

      String s = str.get(i);
      //System.out.println(s);
      if(s.charAt(0) == '0')
      {
        m = new Militar(i, pausa);
        militars.add(m);
      }
      else if(s.charAt(0) == '1')
      {
        tempo = Integer.parseInt(s.substring(2));
        m = new Militar(k, oficial);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        k++;
      }
      else if(s.charAt(0) == '2')
      {
        tempo = Integer.parseInt(s.substring(2));
                
        m = new Militar(k, sargento);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        k++;
      }
      else 
      {
        tempo = Integer.parseInt(s.substring(2));
        m = new Militar(k, praca);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        k++;
      }
    }
    
    return militars; 
  }
  
  public static ArrayList<String> read(String path) throws FileNotFoundException
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
    
    List<Militar> militars = ParserEntrada.getMilitares("BarbeariaZero/src/input.in", patentes);
    

    Thread produtor_fila = new Thread(new ProdutorFila(3, militars, fila_militares));
  
    b1.start();
    b2.start();
    b3.start();
    
    produtor_fila.start();
  }
}
