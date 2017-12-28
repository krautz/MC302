package hotel;

import java.io.IOException;
import java.util.Scanner;

import BancoDeDados.*;
import Comodos.*;
import Data.Data;
import excecao.*;

public class Hotel {
	public String nome;
	public String endereco;
	public int CEP;
	public Data data;
	public BancoDeComodos Bcomodo;
	public BancoDeDados banco;
	private Scanner sc;
	
	public Hotel (String name, String Endereco, int cep) {
		nome = name;
		endereco = Endereco;
		CEP = cep;
		data = new Data (12.00, 14, 7, 2016);
		banco = new BancoDeDados();
		Bcomodo = new BancoDeComodos ();
	}
	
	public void contrar_funcionario (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, double salario, int tempo_servico, int id, int qtd_reservas) {
		banco.contrar_funcionario(nome, idade, Endereco, documento, num_documento, email, telefone, salario, tempo_servico, id, qtd_reservas);
	}
	
	public void demitir_funcionario (int id) {
		banco.demitir_funcionario (id);
	}
	
	public void registrar_hospede (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, int id, String nacionalidade, int num_hospedeS) {
		banco.registrar_hospede(nome, idade, Endereco, documento, num_documento, email, telefone, id, nacionalidade, num_hospedeS);
	}
	
	public void remover_hospede(int id) {
		banco.remover_hospede (id);
	}
	
	public void imprime_hospedes () {
		banco.imprime_hospedes ();
	}
	
	public Hospede acha_hospede (int id) {
		return banco.acha_hospede(id);
	}
	
	public void construir_quarto (int andar, char tipo, int numero) {
		Bcomodo.construir_quarto(andar, tipo, numero);
		
	}
	
	public void efetua_reserva (Data cheg, Data said, char Tipo, int ID, Hospede hos) {
		banco.efetua_reserva(cheg, said, Tipo, ID, hos);
	}
	
	public void alterar_data_reserva (Data new_chegada, Data new_saida, int ID) {
		banco.alterar_data_reserva(new_chegada, new_saida, ID);
	}
	
	public void alterar_quarto_reserva (int ID, char Tipo) {
		banco.alterar_quarto_reserva(ID, Tipo);
	}

	public void check_in (char tipo, int num_hospedes, Hospede hospede, int id_fun, Data chegada, Data saida, int no_show) throws excecao.check_in {
		Bcomodo.check_in(tipo, num_hospedes, hospede, id_fun, chegada, saida, banco, no_show);
	}
	
	public void check_out (int id_hospede, char forma_de_pagamento) {
		Bcomodo.check_out(id_hospede, forma_de_pagamento, banco);
	}
	
	public void cancela_reserva (int id_reserva) {
		banco.remove_reserva (id_reserva);
	}
	
	public void imprime_hotel () {
		System.out.println ("Nome: "+nome);
		System.out.println ("Endereco: "+endereco);
		System.out.println ("CEP: "+CEP);
	}
	
	public void imprime_tudo () {
		System.out.println ("DADOS DO HOTEL:");
		System.out.println ("");
		imprime_hotel ();
		System.out.println ("");
		System.out.println ("DADOS DOS QUARTOS:");
		System.out.println ("");
		Bcomodo.imprime_quartos ();
		System.out.println ("");
		System.out.println ("DADOS DOS HOSPEDES");
		System.out.println ("");
		banco.imprime_hospedes ();
		System.out.println ("");
		System.out.println ("DADOS DOS FUNCIONARIOS");
		System.out.println ("");
		banco.imprime_funcionarios();
		System.out.println ("");
	}
	
	public void atualiza_data () throws IOException{
		data.atualiza();
		sc = new Scanner(System.in);
		for (int i = 0; i < banco.reserva.size(); i++) {
			if ((banco.reserva.get(i)).chegada.dia == data.dia && (banco.reserva.get(i)).chegada.mes == data.mes && (banco.reserva.get(i)).chegada.ano == data.ano) {
				System.out.println("");
				System.out.println("Efetuando check in!");
				System.out.println("Dados da reserva:");
				banco.reserva.get(i).imprime_reserva();
				System.out.println("Insira a id do funcionario");
				int id_func = sc.nextInt();
				sc.nextLine();
				System.out.println("Insira se houve no-show(1 == true)");
				int no_show = sc.nextInt();
				sc.nextLine();
				try {
					check_in((banco.reserva.get(i)).tipo, (banco.reserva.get(i)).hospede.num_hospedes, (banco.reserva.get(i)).hospede, id_func, (banco.reserva.get(i)).chegada, (banco.reserva.get(i)).saida, no_show);
				} catch (check_in e) {
					if (e.get_erro() == 1) {
						System.out.println("Hospede inexistente");
					}
				}
			} else if ((banco.reserva.get(i)).saida.dia == data.dia && (banco.reserva.get(i)).saida.mes == data.mes && (banco.reserva.get(i)).saida.ano == data.ano) {
				System.out.println("Efetuando check out!");
				System.out.println("Dados da reserva:");
				banco.reserva.get(i).imprime_reserva();
				System.out.println("Insira a forma de pagamento ");
				char forma_pagamento = (char)System.in.read();
				sc.nextLine();
				check_out ((banco.reserva.get(i)).hospede.ID, forma_pagamento);
			}
		}
	}
}
