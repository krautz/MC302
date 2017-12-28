package hotel;

import java.io.IOException;
import java.util.Scanner;

import BancoDeDados.Hospede;
import Data.Data;

public class Controlador {

	public void open_controlador (Hotel h) throws IOException {
		char c = 'X';
		while (c != 'F') {
			System.out.println("");
			System.out.println("Digite R para efetuar uma reserva;");
			System.out.println("Digite D para atualizar a data de uma reserva;");
			System.out.println("Digite T para atualizar o tipo de quarto de uma reserva;");
			System.out.println("Digite H para registrar um hospede;");
			System.out.println("Digite A para atualizar a data;");
			System.out.println("Digite F para finalizar o sistema;");
			System.out.println("Digite C para cancelar uma reserva;");
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			c = (char)System.in.read();
			sc.nextLine();
			
			if (c == 'R') {
				System.out.println("Digite a data de chegada(hora, dia, mes ano), data de saida, o tipo de quarto solicitado, id da reserva e a id do hospede");
				Data chegada = new Data (0, 0, 0, 0);
				chegada.hora = sc.nextDouble();
				sc.nextLine();
				chegada.dia = sc.nextInt();
				sc.nextLine();
				chegada.mes = sc.nextInt();
				sc.nextLine();
				chegada.ano = sc.nextInt();
				sc.nextLine();
				Data saida = new Data (0, 0, 0, 0);
				saida.hora = sc.nextDouble();
				sc.nextLine();
				saida.dia = sc.nextInt();
				sc.nextLine();
				saida.mes = sc.nextInt();
				sc.nextLine();
				saida.ano = sc.nextInt();
				sc.nextLine();
				char Tipo = (char)System.in.read();
				sc.nextLine();
				int id = sc.nextInt();
				sc.nextLine();
				int id_hos = sc.nextInt();
				sc.nextLine();
				Hospede hos = h.acha_hospede(id_hos);
				h.efetua_reserva(chegada, saida, Tipo, id, hos);
			} else if (c == 'H') {
				System.out.println("Digite o nome, idade, endereco, documento, numero do documento, e-mail, telefone, id, nacionalidade do hospede e numero de hospedes que estarao alojados com ele");
				String nome = sc.nextLine();
				int idade = sc.nextInt();
				sc.nextLine();
				String Endereco = sc.nextLine();
				String documento = sc.nextLine();
				int num_documento = sc.nextInt();
				sc.nextLine();
				String email = sc.nextLine();
				int telefone = sc.nextInt();
				sc.nextLine();
				int id = sc.nextInt();
				sc.nextLine();
				String nacionalidade = sc.nextLine();
				int num_hospedes = sc.nextInt();
				sc.nextLine();
				h.registrar_hospede(nome, idade, Endereco, documento, num_documento, email, telefone, id, nacionalidade, num_hospedes);
				h.imprime_hospedes ();
			} else if (c == 'A') {
				h.atualiza_data();
			} else if (c == 'D') {
				System.out.println("Insira o ID da reserva, a nova data de chegada e de saida (hora, dia, mes ano)");
				int ID = sc.nextInt();
				sc.nextLine();
				Data new_chegada = new Data (0, 0, 0, 0);
				new_chegada.hora = sc.nextDouble();
				sc.nextLine();
				new_chegada.dia = sc.nextInt();
				sc.nextLine();
				new_chegada.mes = sc.nextInt();
				sc.nextLine();
				new_chegada.ano = sc.nextInt();
				sc.nextLine();
				Data new_saida = new Data (0, 0, 0, 0);
				new_saida.hora = sc.nextDouble();
				sc.nextLine();
				new_saida.dia = sc.nextInt();
				sc.nextLine();
				new_saida.mes = sc.nextInt();
				sc.nextLine();
				new_saida.ano = sc.nextInt();
				sc.nextLine();
				h.alterar_data_reserva(new_chegada, new_saida, ID);
			} else if (c == 'T') {
				System.out.println("Insira o ID da reserva, e o novo tipo de quarto");
				int ID = sc.nextInt();
				sc.nextLine();
				char Tipo = (char)System.in.read();
				sc.nextLine();
				h.alterar_quarto_reserva(ID, Tipo);
			} else if (c == 'C') {
				System.out.println("Insira o id da reserva a ser cancelada");
				int ID = sc.nextInt();
				sc.nextLine();
				h.cancela_reserva(ID);
			}
		}
	}
	

}
