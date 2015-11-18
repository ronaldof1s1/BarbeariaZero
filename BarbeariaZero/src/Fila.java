import java.util.concurrent.ConcurrentLinkedQueue;

public class Fila
{
  ConcurrentLinkedQueue<Militar> queue;
  Patente patente;
  
  public Fila(Patente patente)
  {
    this.patente = patente;
    queue = new ConcurrentLinkedQueue<>();
  }
  
  public ConcurrentLinkedQueue<Militar> getQueue()
  {
    return queue;
  }
  
  public Patente getPatente() {
    return patente;
  }

  public int getSize()
  {
    return queue.size();
  }  
  
  public void push(Militar m)
  {
    queue.add(m);
  }
  
  public Militar poll()
  {
    return queue.poll();
  }
}