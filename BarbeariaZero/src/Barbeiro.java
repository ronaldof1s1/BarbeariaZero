
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldofs
 */
public class Barbeiro implements Runnable
{
  //Categorias: 1 - Oficial, 2 - Sargento, 3 - Praça;
  private int categoria; 
  private Militar m;
  private void cut()
  {
    try
    {
      Thread.sleep(m.getTempo()*100);
      this.m = null;
    }
    catch (InterruptedException ex)
    {
      Logger.getLogger(Barbeiro.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  private void call() throws InterruptedException
  {
    while(true)
    {
      switch(categoria)
      {
        case 1: 
          if(!Barbearia.oficiais.getQueue().isEmpty())
          {
            this.m = Barbearia.oficiais.poll();
          }
          else if(!Barbearia.sargentos.getQueue().isEmpty())
          {
            this.m = Barbearia.sargentos.poll();
          }
          else if(!Barbearia.pracas.getQueue().isEmpty())
          {
            this.m = Barbearia.pracas.poll();
          }
          else
          {
            Thread.sleep((int)Math.random() % 500);
            continue;
          }
          break;
        case 2: 
          if(!Barbearia.sargentos.getQueue().isEmpty())
          {
            this.m = Barbearia.sargentos.poll();
          }
          else if(!Barbearia.oficiais.getQueue().isEmpty())
          {
            this.m = Barbearia.oficiais.poll();
          }
          else if(!Barbearia.pracas.getQueue().isEmpty())
          {
            this.m = Barbearia.pracas.poll();
          }
          else
          {
            Thread.sleep((int)Math.random() % 500);
            continue;
          }
          break;
        case 3:
          if(!Barbearia.pracas.getQueue().isEmpty())
          {
            this.m = Barbearia.pracas.poll();
          }
          else if(!Barbearia.oficiais.getQueue().isEmpty())
          {
            this.m = Barbearia.oficiais.poll();
          }
          else if(!Barbearia.sargentos.getQueue().isEmpty())
          {
            this.m = Barbearia.sargentos.poll();
          }
          else
          {
            Thread.sleep((int)Math.random() % 500);
            continue;
          }
          break;
        }
      break;
      }
  }
  
  @Override
  public void run()
  {
    while(true)
    {
      try
      {
        call();
      }
      catch (InterruptedException ex)
      {
        Logger.getLogger(Barbeiro.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      cut();
    }
  }
}
