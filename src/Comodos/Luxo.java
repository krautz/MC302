package Comodos;

public class Luxo extends Quarto{

	public Luxo (int andar, int numero) {
		super(andar, numero);
		diaria = 499.99;
		max_pessoas_permitidas = 5;
		descricao = "O melhor quarto oferecido pelo hotel, inclui Televisao, 3 camas, 2 de casal e 1 de solteiro, frigobar, hidromassagem, sala de estar, e otima vista pela janela!";
	}
	
	public void imprime_quarto () {
		System.out.println ("Andar: "+andar);
		System.out.println ("Numero: "+numero);
		System.out.println ("Tipo: Luxo");
		System.out.println ("Numero maximo de pessoas permitidas: "+max_pessoas_permitidas);
		System.out.println ("Descricao: "+descricao);
		if (ocupado instanceof Ocupado) {
			System.out.println ("O quarto esta alugado por:");
			hospede.imprime_hospede();
			System.out.println ("Hospedes no quarto: "+hospedes_no_quarto);
			System.out.println ("Hora de chegada: "+data_chegada.hora);
			System.out.println ("Dia de chegada: "+data_chegada.dia);
			System.out.println ("Mes de chegada: "+data_chegada.mes);
			System.out.println ("Ano de chegada: "+data_chegada.ano);
		} else {
			System.out.println ("O quarto nao esta alugado!");
		}
	}

}
