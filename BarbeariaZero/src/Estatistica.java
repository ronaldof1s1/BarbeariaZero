public class Estatistica {
  //=================================================================
  // ESTATÍSTICAS
   
   public static int totalPausas = 0;
   public static int totalOficiais = 0;
   public static int totalSargentos = 0;
   public static int totalPracas = 0;
   
   public static int totalClientesDescartados = 0;
   
   public static int totalEsperaPausas = 0;
   public static int totalEsperaOficiais = 0;
   public static int totalEsperaSargentos = 0;
   public static int totalEsperaPracas = 0;
  //=================================================================
 
  public static void totalClientes() {
    float totalOficiais = (float) (Estatistica.totalOficiais * 100) / Barbearia.totalClientes;
    float totalSargentos = (float) (Estatistica.totalSargentos * 100) / Barbearia.totalClientes;
    float totalPracas = (float) (Estatistica.totalPracas * 100) / Barbearia.totalClientes;
    float totalPausas = (float) (Estatistica.totalPausas * 100) / Barbearia.totalClientes;
    
    System.out.println("=====================================");
    System.out.println("NÍVEL DE OCUPAÇÃO DAS CADEIRAS\n");
    System.out.println("Total de entradas: " + Barbearia.totalClientes);
    System.out.println("Total de oficiais: " + Estatistica.totalOficiais + " (" + totalOficiais + "%)");
    System.out.println("Total de sargentos: " + Estatistica.totalSargentos + " (" + totalSargentos+ "%)");
    System.out.println("Total de praças: " + Estatistica.totalPracas + " (" + totalPracas+ "%)");
    System.out.println("Total de pausas: " + Estatistica.totalPausas + " (" + totalPausas + "%)");
    System.out.println("=====================================\n");
  }
  
  public static void totalClientesDescartados() {
    System.out.println("=====================================");
    float totalClientesDescartados = (float) (Estatistica.totalClientesDescartados * 100) / Barbearia.totalClientes;
    
    System.out.println("TOTAL DE CLIENTES DESCARTADOS: " + Estatistica.totalOficiais + " (" + totalClientesDescartados + "%)");
    System.out.println("=====================================\n");
  }
  
  public static void tempoMedioEspera() {
    float tempoEsperaOficiais = (float) (Estatistica.totalEsperaOficiais * 100) / Estatistica.totalOficiais;
    float tempoEsperaSargentos = (float) (Estatistica.totalEsperaSargentos * 100) / Estatistica.totalSargentos;
    float tempoEsperaPracas = (float) (Estatistica.totalEsperaPracas * 100) / Estatistica.totalPracas;
    float tempoEsperaPausas = (float) (Estatistica.totalEsperaPausas * 100) / Estatistica.totalPausas;
    
    System.out.println("=====================================");
    System.out.println("NÍVEL DE OCUPAÇÃO DAS CADEIRAS\n");
    System.out.println("Total de entradas: " + Barbearia.totalClientes);
    System.out.println("Total de oficiais: " + Estatistica.totalOficiais + " (" + tempoEsperaOficiais + "%)");
    System.out.println("Total de sargentos: " + Estatistica.totalSargentos + " (" + tempoEsperaSargentos+ "%)");
    System.out.println("Total de praças: " + Estatistica.totalPracas + " (" + tempoEsperaPracas+ "%)");
    System.out.println("Total de pausas: " + Estatistica.totalPausas + " (" + tempoEsperaPausas + "%)");
    System.out.println("=====================================\n");
  }
}
