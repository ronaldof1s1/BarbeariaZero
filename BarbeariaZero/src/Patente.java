import java.util.Random;

public class Patente {
  
  // Categorias:
  // 1 - Oficial
  // 2 - Sargento
  // 3 - Praça
  
  private int categoria;
  private String nome;
  private int tempoMinimo;
  private int tempoMaximo;
  
  public Patente(int categoria, String nome) {
    this.categoria = categoria;
    this.nome = nome;
    this.tempoMinimo = 1;
    this.tempoMaximo = 3;
    if(categoria == 1)
    {
      this.tempoMaximo += 3;
      this.tempoMinimo += 3;
    }
    else if(categoria == 2)
    {
      this.tempoMaximo += 1;
      this.tempoMinimo += 1;
    }
  }
  
  public int getCategoria() {
    return categoria;
  }
  
  public int getTempoMinimo() {
    return tempoMinimo;
  }

  public int getTempoMaximo() {
    return tempoMaximo;
  }
//  
//  public int tempoCorte() {
//    Random rand = new Random();
//    return rand.nextInt((tempoMaximo - tempoMinimo) + 1) + tempoMinimo;
//  }
}
