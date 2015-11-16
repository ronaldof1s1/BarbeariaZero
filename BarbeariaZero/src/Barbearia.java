/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Thread;
import java.util.Random;
/**
 *
 * @author ronaldofs
 */
public class Barbearia
{
  
  public static int totalSize; // Número de pessoas esperando dentro da barbearia
  public static int rejected;  // Número de pessoas que não puderam entrar na barbearia

  public static int oficiais_atendidos;  // Número de oficiais atendidos
  public static int sargentos_atendidos; // Número de sargentos atendidos
  public static int pracas_atendidos; 	 // Número de praças atendidos


  public static Fila oficiais;
  public static Fila sargentos;
  public static Fila pracas;

  public static Barbeiro barbeiro_oficial;
  public static Barbeiro barbeiro_sargento;
  public static Barbeiro barbeiro_praca;
  
  public static int input[][];

  public static int pausas; // Conta quantas vezes não entrou nenhum cliente na barbearia

  public static void generate_input(){
	input = new int[1000][2];

	Random rand = new Random();

	/* 
		Gera aleatoriamente a entrada de dados.
		Ao todos, são 1000 registros.
		Como espefificado, a barbearia deve fechar após cinco pausas (representadas pelo zero) consecutivas.
		Por isso, apenas os 995 primeiros registros são gerados de forma aleatória; os outros cinco serão 
			explicitamente definidos como zero.
	*/

	for (int i = 0; i < 995; i++) {
		input[i][0] = rand.nextInt(4);

		if (input[i][0] == 1) { // Oficial
			input[i][1] = rand.nextInt(3) + 4;
		}
		else if (input[i][0] == 2) { // Sargento
			input[i][1] = rand.nextInt(3) + 2;
		}
		else if (input[i][0] == 3) { // Praça
			input[i][1] = rand.nextInt(3) + 1;
		}
		else {
			input[i][1] = 0;
		}
	}

	input[995][0] = 0; input[995][1] = 0;
	input[996][0] = 0; input[996][1] = 0;
	input[997][0] = 0; input[997][1] = 0;
	input[998][0] = 0; input[998][1] = 0;
	input[999][0] = 0; input[999][1] = 0;

  }

  public static void output(){
  	// Método para calcular os dados de saída do programa

  }

  public static void open_barbearia(){
  	int i = 0;
  	Random rand = new Random();

  	pausas = 0;

  	while(pausas < 5 && i < 1000){
  		// Adicionar o código pra esperar um tempo tal até chamar alguém

  		if (input[i][0] == 0) {
  			pausas += 1;
  		}
  		else{
  			pausas = 0; // Se entrar uma pessoa, o contador de pausas CONSECUTIVAS deve ser reiniciado

  			if (totalSize < 20) { // Tem menos de 20 pessoas dentro da barbearia, o que significa que pode entrar mais gente

  				switch(input[i][0]) // Seleciona em qual fila aquela nova pessoa deve entrar
  				{
  					case 1:
  						oficiais.push( new Militar(input[i][0], input[i][1]) );
  						break;
  					case 2:
  						sargentos.push( new Militar(input[i][0], input[i][1]) );
  						break;
  					case 3:
  						pracas.push( new Militar(input[i][0], input[i][1]) );
  						break;
  					default:
  						System.out.println("Categoria inválida");
  				}

  			}
  			else {
  				rejected += 1;
  			}
  		}
  		i++;
  	}
  }
  
  public static void main(String args[]) throws InterruptedException
  {
    oficiais = new Fila(1);
    sargentos = new Fila(2);
    pracas = new Fila(3);

    barbeiro_oficial = new Barbeiro(1);
    barbeiro_sargento = new Barbeiro(2);
    barbeiro_praca = new Barbeiro(3);

    generate_input();

    open_barbearia();
    
    
    System.out.println("OI");
  }
}
