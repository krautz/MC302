package Comodos;

import BancoDeDados.Hospede;
import Data.Data;

public class Quarto extends Comodo{
	
	public int numero;
	public double diaria;
	public int max_pessoas_permitidas;
	public String descricao;
	public int hospedes_no_quarto;
	public Data data_chegada;
	public Data data_saida;
	public EstadoQuarto ocupado;
	public Hospede hospede;
	
	public Quarto (int andar, int Numero){
		super(andar);
		numero = Numero;
		hospedes_no_quarto = 0;
		hospede = null;
		data_chegada = new Data (0, 0, 0, 0);
		data_saida = new Data (0,0,0,0);
		ocupado = new Livre();
	}
	
	public void reserva_quarto (int hospedes, Data chegada, Data saida, Hospede hos) { // retorna 1 se reserva foi efetuada, retorno 0 se reserva nao foi possivel
		hospedes_no_quarto = hospedes + 1;
		data_chegada = chegada;
		data_saida = saida;
		ocupado = new Ocupado();
		hospede = hos;
		System.out.println("Comodo ocupado com sucesso!");
	}
	
	public void calcula_total_pagar () {
		int total = data_chegada.Calcula_tempo_total (data_saida);
		System.out.println ("Total a pagar: "+(total * diaria));
		
	}
	
	public void desalugar_quarto (char forma_de_pagamento) {
		System.out.print ("Forma de pagamento: ");
		if (forma_de_pagamento == 'C') {
			System.out.println ("Cartao de Credito");
		} else if (forma_de_pagamento == 'D') {
			System.out.println ("Cartao de Debito");
		} else if (forma_de_pagamento == 'M') {
			System.out.println ("Dinheiro");
		} else {
			System.out.println("Metodo invalido, insira outro!");
			return;
		}
		this.calcula_total_pagar ();
		
		hospedes_no_quarto = 0;
		data_saida.hora = 0;
		data_saida.dia = 0;
		data_saida.mes = 0;
		data_saida.ano = 0;
		data_saida.hora = 0;
		data_saida.dia = 0;
		data_saida.mes = 0;
		data_saida.ano = 0;
		hospede = null;
		ocupado = new Livre();
		
	}
	
	public void imprime_quarto () {
		
	}
}
