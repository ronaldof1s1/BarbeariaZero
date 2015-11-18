import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

class ProdutorFila implements Runnable {
  private int maximoClientes;
  private List<Militar> clientes;
  private List<Fila> filas;
  
  public ProdutorFila(int maximoClientes, List<Militar> clientes, List<Fila> filas)
  {
    this.maximoClientes = maximoClientes;
    this.clientes = clientes;
    this.filas = filas;
  }

  @Override
  public void run() {
    int contPausas = 0;
    Militar m;
    
    for (int i = 0; i < clientes.size(); i++) {
      m = clientes.remove(i);
      
      if(m.getPatente().getCategoria() != 0) {
        try {
          produce(m, i);
        } 
        catch (InterruptedException ex) {
          Logger.getLogger(ProdutorFila.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else {
        try {
          long tempoEspera = (long) (1 + Math.random() % 5);
          Estatistica.totalEsperaPausas += tempoEspera;
          Thread.sleep(tempoEspera * 100);
        }
        catch (InterruptedException ex) {
          Logger.getLogger(ProdutorFila.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  private void produce(Militar m, int i) throws InterruptedException {
    synchronized(filas) {      
      while(Barbearia.tamanhoFila == maximoClientes) {
        System.out.println("A barbearia está lotada. \t\t\t\t\t\t\t Total de clientes: " + Barbearia.tamanhoFila);
        clientes.add(m);
        m.imprimir("está indo para o final da fila");
        Estatistica.totalClientesDescartados++;
        filas.wait();
      }
      
      Fila fila = filas.get(m.getPatente().getCategoria() - 1);
      
      fila.push(m);
      
      Barbearia.tamanhoFila++;
      
      m.imprimir(" entrou na barbearia. \t Tamanho da fila " 
                + fila.getPatente().getCategoria() + ": " 
                + fila.getSize() + "\t Total de clientes: " 
                + Barbearia.tamanhoFila);          
      filas.notifyAll();
    }
  }
}