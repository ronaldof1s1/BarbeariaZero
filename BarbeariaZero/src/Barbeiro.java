
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
  
  private void cut(Militar M)
  {
    try
    {
      Thread.sleep(M.getTempo());
    }
    catch (InterruptedException ex)
    {
      Logger.getLogger(Barbeiro.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  @Override
  public void run()
  {
    
  }
}
