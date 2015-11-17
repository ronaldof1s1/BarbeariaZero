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
          work();
      } catch (InterruptedException ex) {
          Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  private Fila filaProximaPatente() {
    Fila fila = null;
    
    for(int i = 0; i < filas.size(); i++) {
      fila = filas.get(i);
      
      if(! fila.getQueue().isEmpty()) {
        break;
      }
    }
    
    return fila;
  }
  
  private void work() throws InterruptedException {
    Fila fila = filas.get(patente.getCategoria() - 1);
    
    if (fila.getQueue().isEmpty()) {
      fila = filaProximaPatente(); 
    }

    if(! fila.getQueue().isEmpty()) {
      synchronized (fila) {
      Militar m = fila.poll();
      System.out.println("Cliente "+ m.getNumero() + " indo embora da fila " + fila.getPatente().getCategoria());
      Thread.sleep(m.getTempoDeCorte() * 100);        
        fila.notifyAll();
      }
    }
  }
}
