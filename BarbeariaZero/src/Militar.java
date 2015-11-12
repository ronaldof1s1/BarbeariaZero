/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldofs
 */
public class Militar
{
  private int numero;
  //categorias: 1 - oficial, 2 - sargento, 3 - praça;
  private int categoria;

  public Militar(int numero, int categoria)
  {
    this.numero = numero;
    this.categoria = categoria;
  }

  public Militar(int numero)
  {
    this.numero = numero;
    this.categoria = 3;
  }

  public int getNumero()
  {
    return numero;
  }

  public void setNumero(int numero)
  {
    if(numero >= 0)
    {
      this.numero = numero;

    }
    else
    {
      System.out.println("Numero não pode ser menor que 0");
    }
  }

  public int getCategoria()
  {
    return categoria;
  }

  public void setCategoria(int categoria)
  {
    if(categoria != 1 && categoria != 2 && categoria != 3)
    {
      System.out.println("Não existe essa categoria");
    }
    else
    {
      this.categoria = categoria;
    }
  }
  
}
