package BancoDeDados;

public class Hospede extends Pessoa {
	public String nacionalidade;
	public int num_hospedes;

	public Hospede (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, String Nacionalidade, int id, int num_hospedeS) {
		super (nome, idade, Endereco, documento, num_documento, email, telefone, id);
		nacionalidade = Nacionalidade;
		num_hospedes = num_hospedeS;
	}

	public void imprime_hospede () {
		this.imprimir_pessoa ();
		System.out.println ("Nacionalidade: "+nacionalidade);
		System.out.println ("ID: "+ID);
	}
}
