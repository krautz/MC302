package Comodos;

public class Solteiro extends Quarto{
	
	public Solteiro (int andar, int numero) {
		super (andar, numero);
		diaria = 99.99;
		max_pessoas_permitidas = 1;
		descricao = "Um quarto com banheiro frigobar e cama para uma pessoa";
	}
	
	public void imprime_quarto () {
		System.out.println ("Andar: "+andar);
		System.out.println ("Numero: "+numero);
		System.out.println ("Tipo: Solteiro");
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