package BancoDeDados;

import Data.Data;

public class Reserva {
	
	public Data chegada;
	public Data saida;
	public char tipo;
	public int id;
	public Hospede hospede;
	
	public Reserva (Data cheg, Data said, char Tipo, int ID, Hospede hos) {
		chegada = cheg;
		saida = said;
		tipo = Tipo;
		id = ID;	
		hospede = hos;
	}
	
	public int verifica_data_disponivel (Data cheg, Data said, char Tipo) {
		if (this.tipo == Tipo) {
			return this.chegada.check_data(cheg, said, this.saida);
		} else return 0;
		
	}
	
	public void alterar_data (Data cheg, Data said) {
		this.chegada = cheg;
		this.saida = said;
	}
	
	public void alterar_tipo (char Tipo) {
		this.tipo = Tipo;
	}
	
	public void imprime_reserva () {
		System.out.println("Dados do hospede");
		hospede.imprime_hospede();
		System.out.println("Data de chegada");
		chegada.imprime_data();
		System.out.println("Data de saida");
		saida.imprime_data();
		System.out.println("ID reserva: " +id);
		System.out.println("Tipo quarto: " +tipo);
	}

}
