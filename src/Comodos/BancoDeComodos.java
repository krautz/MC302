package Comodos;


import java.util.ArrayList;

import BancoDeDados.*;
import Data.Data;
import excecao.*;

public class BancoDeComodos {
	public ArrayList <Comodo> comodo;
	
	public BancoDeComodos () {
		comodo = new ArrayList<Comodo> ();
	}
	
	public void construir_quarto (int andar, char tipo, int numero) {
		if (tipo == 'S') {
			comodo.add(FabricaQuartos.criaSolteiro(andar, numero));
		} else if (tipo == 'C') {
			comodo.add(FabricaQuartos.criaCasal(andar, numero));
		} else if (tipo == 'F') {
			comodo.add(FabricaQuartos.criaFamilia(andar, numero));
		} else if (tipo == 'L') {
			comodo.add(FabricaQuartos.criaLuxo(andar, numero));
		} else {
			System.out.println ("Este tipo de quarto nao eh construtivel");
		}
		
	}
	
	public void imprime_quartos () {
		for (int i = 0; i < comodo.size(); i++) {
			comodo.get(i).imprime_quarto();
			System.out.println ("");
		}
	}
	
	public void check_in (char tipo, int num_hospedes, Hospede hospede, int id_fun, Data chegada, Data saida, BancoDeDados banco, int no_show) throws excecao.check_in {
		int flag = 1;
		int flag_3 = 1;
		// verificando se o quarto esta disponivel
		if (no_show == 1) {
			System.out.println("O hospede não apareceu.");
			if (tipo == 'S') {
				System.out.println("Multa aplicada de 99.99");
			} else if (tipo == 'C') {
				System.out.println("Multa aplicada de 199.99");
			} else if (tipo == 'F') {
				System.out.println("Multa aplicada de 249.99");
			} else if (tipo == 'L') {
				System.out.println("Multa aplicada de 499.99");
			}
			int flagg = 0;
			for (int i = 0; i < banco.reserva.size() && flagg == 0; i++) {
				if (hospede == banco.reserva.get(i).hospede) {
					banco.reserva.remove(i);
					flagg = 1;
				}
			}
			return;
		}
		
		int flagg = 0;
		for (int i = 0; i < banco.reserva.size() && flagg == 0; i++) {
			if (hospede == banco.reserva.get(i).hospede) {
				flagg = 1;
			}
		}
		if (flagg == 0) {
			throw new check_in (1);
		}
		
		for(int i = 0; i < comodo.size() && flag == 1; i++) {
			if (((Quarto)comodo.get(i)).ocupado instanceof Livre && ((tipo == 'S' && comodo.get(i) instanceof Solteiro) || (tipo == 'F' && comodo.get(i) instanceof Familia) || (tipo == 'L' && comodo.get(i) instanceof Luxo) || (tipo == 'C' && comodo.get(i) instanceof Casal))) {
				for (int k = 0; k < banco.funcionario.size() && flag_3 == 1; k++) {
					if (banco.funcionario.get(k).ID == id_fun) {
						banco.funcionario.get(k).numero_de_reservas++;
						flag_3 = 0;
					}
				}
				if (flag_3 != 0){
					System.out.println("Id do funcionario inexistente, efetuando check in da mesma maneira!");
				}
				((Quarto)comodo.get(i)).reserva_quarto(num_hospedes, chegada, saida, hospede);
				System.out.println("Check-in Efetuado com sucesso!");
				((Quarto)comodo.get(i)).imprime_quarto();
				flag = 0;
			}
		}
	}
	
	public void check_out (int id_hospede, char forma_de_pagamento, BancoDeDados banco) {
		int flag = 1;
		int flag_2 = 1;
		for (int i = 0; i < banco.hospede.size() && flag == 1; i++) {
			if (banco.hospede.get(i).ID == id_hospede) {
				flag = 0;
				for (int j = 0; j < comodo.size() && flag_2 == 1; j++) {
					if (((Quarto)comodo.get(j)).hospede == banco.hospede.get(i)) {
						System.out.println("");
						System.out.println("Desalugando Quarto...");
						comodo.get(j).imprime_quarto();
						((Quarto)comodo.get(j)).desalugar_quarto(forma_de_pagamento);
						flag_2 = 0;
					}
				}
			}
		}
	}

}
