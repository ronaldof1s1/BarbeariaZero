
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldofs
 */
public class Fila
{
  
  ConcurrentLinkedQueue<Militar> queue;
  private int categoria;

  public Fila(int categoria)
  {
    this.categoria = categoria;
    queue = new ConcurrentLinkedQueue<>();
  }

  public int getCategoria()
  {
    return categoria;
  }

  public void setCategoria(int categoria)
  {
    this.categoria = categoria;
  }
  
  public ConcurrentLinkedQueue<Militar> getQueue()
  {
    return queue;
  }
  
  public void setQueue(ConcurrentLinkedQueue<Militar> queue)
  {
    this.queue = queue;
  }

  public int getSize()
  {
    return queue.size();
  }
  
  
  public  void AddMilitar(Militar m)
  {
    if(Barbearia.totalSize < 20)
    {
      queue.add(m);
      Barbearia.totalSize += 1;
    }
  }
  
  public Militar poll()
  {
    Barbearia.totalSize -= 1;
    return queue.poll();
  }
  
  
}