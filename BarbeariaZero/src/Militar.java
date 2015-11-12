/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author ronaldofs
 */

public class Militar
{
  private int numero;
  //Categorias: 1 - Oficial, 2 - Sargento, 3 - Praça;
  private int categoria;
  private int tempo;
  private int tempoDeEspera;
  
  public Militar(int numero, int categoria)
  {
    setNumero(numero);
    setCategoria(categoria);
    setTempo(categoria);
    this.tempoDeEspera = 0;
  }

  public int getTempo()
  {
    return tempo;
  }

  public void setTempo(int categoria)
  {
    Random rand = new Random();
    this.tempo = rand.nextInt() % 3;
    switch(categoria)
    {
      case 1: 
        this.tempo += 4;
        break;
      case 2:
        this.tempo += 2;
        break;
      case 3:
        this.tempo += 1;
        break;
      default:
        System.out.println("Categoria inválida");
    }
  }

  public Militar(int numero)
  {
    this.numero = numero;
    this.categoria = 3;
    setTempo(3);
    this.tempoDeEspera = 0;
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

  public int getTempoDeEspera()
  {
    return tempoDeEspera;
  }
  
  public void aumentaTempoDeEspera(int tempo)
  {
    this.tempoDeEspera += tempo;
  }
  
}
