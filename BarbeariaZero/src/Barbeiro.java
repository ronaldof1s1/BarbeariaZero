import java.lang.Thread;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barbeiro implements Runnable
{
  private Patente patente; 
  private List<Fila> filas;
  
  public Barbeiro(Patente patente, List<Fila> filas)
  {
    this.patente = patente;
    this.filas = filas;
  }

  @Override
  public void run()
  {
    while (true) {
      try {
          work(filas.get(patente.getCategoria() - 1));
      } catch (InterruptedException ex) {
          Logger.getLogger(Barbeiro.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  private void work(Fila fila) throws InterruptedException { 
    synchronized (filas) {
      if(fila.getQueue().isEmpty()) {
        // pegar a próxima fila
        Fila filaAux = fila;
        
        for(int i = 0; i < filas.size(); i++) {
          filaAux = filas.get(i);
          
          if(!filaAux.getQueue().isEmpty()) {
            fila = filaAux;
            break;
          }
        }
        
        if(!fila.getQueue().isEmpty()) {
          Militar m = fila.poll();
          Barbearia.tamanhoFila--;
          m.imprimir(" saiu da fila " + fila.getPatente().getCategoria()
              + ". \t Tamanho da fila " + fila.getPatente().getCategoria()
              + ": " + fila.getSize() + "\t Total de clientes: " + Barbearia.tamanhoFila);
          Thread.sleep(m.getTempoDeCorte() * 1000);
        }        
      }
      else {
        Militar m = fila.poll();
        Barbearia.tamanhoFila--;
        m.imprimir(" saiu da fila " + fila.getPatente().getCategoria()
                  + ". \t Tamanho da fila " + fila.getPatente().getCategoria()
                  + ": " + fila.getSize() + "\t Total de clientes: " + Barbearia.tamanhoFila);        
        Thread.sleep(m.getTempoDeCorte() * 1000);
      }
      filas.notifyAll();
    }
  }
}
