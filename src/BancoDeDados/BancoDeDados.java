package BancoDeDados;


import java.util.ArrayList;

import Comodos.FabricaQuartos;
import Data.Data;

public class BancoDeDados {
	 
	public ArrayList <Funcionario> funcionario;
	public ArrayList <Hospede> hospede;
	public ArrayList <Reserva> reserva;
	
	public BancoDeDados () {
		funcionario = new ArrayList <Funcionario> ();
		hospede = new ArrayList <Hospede> ();
		reserva = new ArrayList <Reserva> ();
	}
	
	
	public void contrar_funcionario (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, double salario, int tempo_servico, int id, int qtd_reservas) {
		funcionario.add (new Funcionario (nome, idade, Endereco, documento, num_documento, email, telefone, salario, tempo_servico, id, qtd_reservas));
	}
	
	public void demitir_funcionario (int id) {
		int flag = 1;
		for (int i = 0; i < funcionario.size() && flag == 1; i++) {
			if (funcionario.get(i).ID == id) {
				funcionario.remove(i);
				flag = 0;
				System.out.println("Funcionario demitido!");
			}
		}
		if (flag == 1) {
			System.out.println("Funcionario inexistente!");
		}
	}
	
	public void registrar_hospede (String nome, int idade, String Endereco, String documento, int num_documento, String email, int telefone, int id, String nacionalidade, int num_hospedeS) {
		hospede.add(new Hospede(nome, idade, Endereco, documento, num_documento, email, telefone, nacionalidade, id, num_hospedeS));
	}
	
	public void remover_hospede(int id) {
		int flag = 1;
		for (int i = 0; i < hospede.size() && flag == 1; i++) {
			if (hospede.get(i).ID == id) {
				hospede.remove(i);
				flag = 0;
				System.out.println("Hospede Removido!");
			}
		}
		if (flag == 1) {
			System.out.println("Hospede nao encontrado!");
		}
	}
	
	public void imprime_funcionarios () {
		for (int i = 0; i < funcionario.size(); i++) {
			funcionario.get(i).imprime_funcionario();
			System.out.println ("");
		}
	}
	
	public void imprime_hospedes () {
		for (int i = 0; i < hospede.size(); i++) {
			hospede.get(i).imprime_hospede();
			System.out.println ("");
		}
	}
	
	public Reserva acha_reserva (int ID) {
		for (int i = 0; i < reserva.size(); i++) {
			if ((reserva.get(i)).id == ID) {
				return reserva.get(i);
			}
		}
		return null;
	}
	
	public Hospede acha_hospede (int id) {
		for (int i = 0; i < hospede.size(); i++) {
			if (hospede.get(i).ID == id) {
				return hospede.get(i);
			}
		}
		return null;
	}
	
	public void imprimir_reservas () {
		for (int i = 0; i < reserva.size(); i++) {
			reserva.get(i).imprime_reserva();
		}
	}
	
	public void efetua_reserva (Data cheg, Data said, char Tipo, int ID, Hospede hos) {
		//verificar se quarto esta disponivel nesta data, fazemos isto percorrendo a lista de reservas e checando
		if ((Tipo == 'S' && hos.num_hospedes > 1) || (Tipo == 'C' && hos.num_hospedes > 2) || (Tipo == 'F' && hos.num_hospedes > 4) || (Tipo == 'L' && hos.num_hospedes > 5)) {
			System.out.println("numero maximo de hospedes permitido no tipo de quarto solicitado ultrapassado!");
			return;
		} else if (Tipo != 'S' && Tipo != 'C' && Tipo != 'F' && Tipo != 'L') {
			System.out.println("Tipo solicitado inexistente!");
		} else {
			int flag = 1;
			int contador_quartos_disponiveis = 0;
			if (Tipo == 'S') {
				contador_quartos_disponiveis = FabricaQuartos.numSolteiro;
			} else if (Tipo == 'C') {
				contador_quartos_disponiveis = FabricaQuartos.numCasal;
			} else if (Tipo == 'F') {
				contador_quartos_disponiveis = FabricaQuartos.numFamilia;
			} else if (Tipo == 'L') {
				contador_quartos_disponiveis = FabricaQuartos.numLuxo;
			}
			for (int i = 0; i < reserva.size() && flag == 1; i++) {
				contador_quartos_disponiveis += (reserva.get(i)).verifica_data_disponivel(cheg, said, Tipo); 
				System.out.println("Contador: "+contador_quartos_disponiveis);
				if (contador_quartos_disponiveis == 0) {
					flag = 0;
					System.out.println("Nao ha quartos disponiveis para esta data!");
				}
			}
			if (flag == 1) {
				reserva.add(new Reserva (cheg, said, Tipo, ID, hos));
				System.out.println("Reserva efetuada com sucesso!");
				acha_reserva(ID).imprime_reserva();
			}
		}
	}
	
	public void alterar_data_reserva (Data new_chegada, Data new_saida, int ID) {
		Reserva check;
		check = acha_reserva(ID);
		if (check == null) {
			System.out.println("Esta ID nao corresponde a nenhuma reserva!");
			return;
		} else {
			int flag = 1;
			int contador_quartos_disponiveis = 0;
			if (check.tipo == 'S') {
				contador_quartos_disponiveis = FabricaQuartos.numSolteiro;
			} else if (check.tipo == 'C') {
				contador_quartos_disponiveis = FabricaQuartos.numCasal;
			} else if (check.tipo == 'F') {
				contador_quartos_disponiveis = FabricaQuartos.numFamilia;
			} else if (check.tipo == 'L') {
				contador_quartos_disponiveis = FabricaQuartos.numLuxo;
			}
			for (int i = 0; i < reserva.size() && flag == 1; i++) {
				if (check != reserva.get(i)) {
					contador_quartos_disponiveis += (reserva.get(i)).verifica_data_disponivel(new_chegada, new_saida, check.tipo); 
					if (contador_quartos_disponiveis == 0) {
						flag = 0;
						System.out.println("Nao ha quartos disponiveis para esta data!");
					}
				}
			}
			if (flag == 1) {
				acha_reserva(ID).alterar_data(new_chegada, new_saida);
				System.out.println("Reserva alterada com sucesso!");
				acha_reserva(ID).imprime_reserva();
			}
		}
	}
	
	public void alterar_quarto_reserva (int ID, char Tipo) {
		Reserva check;
		check = acha_reserva(ID);
		if (check == null) {
			System.out.println("Esta ID nao corresponde a nenhuma reserva!");
			return;
		} else {
			int flag = 1;
			int contador_quartos_disponiveis = 0;
			if (Tipo == 'S') {
				contador_quartos_disponiveis = FabricaQuartos.numSolteiro;
			} else if (Tipo == 'C') {
				contador_quartos_disponiveis = FabricaQuartos.numCasal;
			} else if (Tipo == 'F') {
				contador_quartos_disponiveis = FabricaQuartos.numFamilia;
			} else if (Tipo == 'L') {
				contador_quartos_disponiveis = FabricaQuartos.numLuxo;
			}
			for (int i = 0; i < reserva.size() && flag == 1; i++) {
				if (check != reserva.get(i)) {
					contador_quartos_disponiveis += (reserva.get(i)).verifica_data_disponivel(check.chegada, check.saida, Tipo); 
					if (contador_quartos_disponiveis == 0) {
						flag = 0;
						System.out.println("Nao ha quartos disponiveis para esta data!");
					}
				}
			}
			if (flag == 1) {
				acha_reserva(ID).alterar_tipo(Tipo);
				System.out.println("Reserva alterada com sucesso!");
				acha_reserva(ID).imprime_reserva();
			}
		}
		
	}
	
	public void remove_reserva(int id) {
		int flag = 1;
		for (int i = 0; i < reserva.size() && flag == 1; i++) {
			if (reserva.get(i).id == id) {
				reserva.remove(i);
				flag = 0;
			}
		}
		if (flag == 0) {
			System.out.println("Reserva encontrada e cancelada");
		} else {
			System.out.println("este id nao corresponde a nenhuma reserva");			
		}
	}

}
