public class Militar
{
  private int numero;
  private int tempoDeCorte;
  private int tempoDeEspera;
  private Patente patente;
  
  public Militar(int numero, Patente patente)
  {
    this.numero = numero;
    this.patente = patente;
    this.tempoDeEspera = 0;
    this.tempoDeCorte = 0;
  }
  
  public Patente getPatente()
  {
    return patente;
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

  public int getTempoDeEspera()
  {
    return tempoDeEspera;
  }
  
  public void aumentaTempoDeEspera(int tempo)
  {
    this.tempoDeEspera += tempo;
  }

  public int getTempoDeCorte()
  {
    return tempoDeCorte;
  }

  public void setTempoDeCorte(int tempoDeCorte)
  {
    this.tempoDeCorte = tempoDeCorte;
  }
  
}
