package Comodos;

public class Familia extends Quarto{

	public Familia (int andar, int numero) {
		super(andar, numero);
		diaria = 249.99;
		max_pessoas_permitidas = 4;
		descricao = "Um otimo quarto para passar o fim de semana com a familia! O quarto inclui 3 camas, duas de solteiro e uma de casal, Televisao, banheiro com banheira e frigobar";
	}
	
	public void imprime_quarto () {
		System.out.println ("Andar: "+andar);
		System.out.println ("Numero: "+numero);
		System.out.println ("Tipo: Familia");
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
