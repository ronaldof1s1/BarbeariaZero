import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParserEntrada {
  private static ArrayList<String> read(String path) throws FileNotFoundException
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
  
  private static ArrayList<Militar> processString(ArrayList<String> str, List<Patente> patentes)
  {
    ArrayList<Militar> militars = new ArrayList<>();
    Militar m;
    int tempo;
    
    Patente pausa = patentes.get(0);
    Patente oficial = patentes.get(1);
    Patente sargento = patentes.get(2);
    Patente praca = patentes.get(3);
    
    int k = 0;
    for(int i = 0; i < str.size(); i++)
    {
      String s = str.get(i);

      if(s.charAt(0) == '0')
      {
        m = new Militar(i, pausa);
        militars.add(m);
        
        Estatistica.totalPausas++;
        Estatistica.totalEsperaPausas++;
      }
      else if(s.charAt(0) == '1')
      {
        k++;
        tempo = Integer.parseInt(s.substring(2));
        m = new Militar(k, oficial);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        
        Estatistica.totalOficiais++;
        Estatistica.totalEsperaOficiais += tempo;
      }
      else if(s.charAt(0) == '2')
      {
        k++;
        tempo = Integer.parseInt(s.substring(2));
                
        m = new Militar(k, sargento);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        
        Estatistica.totalSargentos++;
        Estatistica.totalEsperaSargentos += tempo;
      }
      else 
      {
        k++;
        tempo = Integer.parseInt(s.substring(2));
        m = new Militar(k, praca);
        m.setTempoDeCorte(tempo);
        militars.add(m);
        
        Estatistica.totalPracas++;
        Estatistica.totalEsperaPracas += tempo;
      }
    }
    
    return militars; 
  }
  
  public static List<Militar> getMilitares(String diretorio, List<Patente> patentes) throws FileNotFoundException {
    ArrayList<String> input = read(diretorio);
    return processString(input, patentes);
  }  
}
