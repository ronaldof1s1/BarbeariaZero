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
    Militar m;
    for (int i = 0; i < clientes.size(); i++) {
      m = clientes.get(i);
      if(m.getPatente().getCategoria() != 0)
      {
        try {
          produce(clientes.get(i), i);
        } 
        catch (InterruptedException ex) {
          Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      try
      {
        Thread.sleep((long) (1 + Math.random() % 5)*100);
      }
      catch (InterruptedException ex)
      {
        Logger.getLogger(ProdutorFila.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  private int numeroClientesAtual()
  {
    int total = 0;
    
    for(int i = 0; i < filas.size() - 1; i++)
    {
      total += filas.get(i).getSize();
    }
    
    return total;
  }

  private void produce(Militar m, int i) throws InterruptedException {
    Fila fila = filas.get(m.getPatente().getCategoria() - 1);
    
    while (numeroClientesAtual() == maximoClientes) {
      synchronized (fila) {
        System.out.println("A barbearia está lotada. Tamanho: " + numeroClientesAtual());

        fila.wait();
      }
    }

    //producing element and notify consumers
    synchronized (fila) {
      fila.push(m);
      System.out.println("Entrou: " + m.getNumero());
      fila.notifyAll();
    }
  }
}