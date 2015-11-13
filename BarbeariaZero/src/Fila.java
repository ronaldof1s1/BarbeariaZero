
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
  
  public  void AddMilitar(Militar m,  ConcurrentLinkedQueue<Militar> q1)
  {
    if(Barbearia.totalSize < 20)
    {
      q1.add(m);
      Barbearia.totalSize += 1;
    }
  }
  
  ConcurrentLinkedQueue<Militar> queue;
   
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

  
   
   
   
}