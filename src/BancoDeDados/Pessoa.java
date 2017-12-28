package BancoDeDados;

public class Pessoa {
	public String nome;
	public int idade;
	public String endereco;
	public String documento;
	public int numero_documento;
	public String email;
	public int telefone;
	public int ID;
	
	public Pessoa (String Nome, int Idade, String Endereco, String Documento, int num_documento, String Email, int Telefone, int id) {
		nome = Nome;
		idade = Idade;
		endereco = Endereco;
		documento = Documento;
		numero_documento = num_documento;
		email = Email;
		telefone = Telefone;
		ID = id;
	}

	public void imprimir_pessoa () {
		System.out.println ("Nome: "+nome);
		System.out.println ("Idade: "+idade);
		System.out.println ("Endereco: "+endereco);
		System.out.println ("Documento: "+documento+" - "+numero_documento);
		System.out.println ("E-mail: "+email);
		System.out.println ("Telefone: "+telefone);
	}
}
