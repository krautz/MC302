package BancoDeDados;

public class Funcionario extends Pessoa {
	
	public double salario;
	public int anos_de_servico;
	public int numero_de_reservas;
	
	public Funcionario (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, double Salario, int tempo_servico, int id, int qtd_reservas) {
		super (nome, idade, Endereco, documento, num_documento, email, telefone, id);
		salario = Salario;
		anos_de_servico = tempo_servico;
		numero_de_reservas = qtd_reservas;
	}

	public void imprime_funcionario () {
		this.imprimir_pessoa ();
		System.out.println ("Salario: "+salario);
		System.out.println ("Tempo de trabalho: "+anos_de_servico+" anos");
		System.out.println ("Numero de indentificacao: "+ID);
		System.out.println ("Bonus Salarial pelo numero de reservas efetuadas: "+this.calcula_bonus());
	}
	
	public double calcula_bonus () {
		return numero_de_reservas * 10.00;
	}
}
