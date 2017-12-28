package hotel;

import java.io.IOException;

public class ExemploHotel {
	public static void main(String[] args) throws IOException {
		Hotel h = new Hotel ("Krauthamer Hotel", "Rua Israel - 288", 234518001);
		Controlador controlador = new Controlador ();
		// CRIANDO TODOS OS QUARTOS
		h.construir_quarto (1, 'S', 1);
		h.construir_quarto (1, 'C', 2);
		h.construir_quarto (1, 'F', 3);
		h.construir_quarto (1, 'L', 4);
		h.construir_quarto (2, 'F', 1);
		h.construir_quarto (2, 'L', 2);
		h.construir_quarto (2, 'S', 3);
		h.construir_quarto (2, 'C', 4);
		/*
		h.construir_quarto (3, 'L', 1);
		h.construir_quarto (3, 'F', 2);
		h.construir_quarto (3, 'C', 3);
		h.construir_quarto (3, 'S', 4);
		h.construir_quarto (4, 'F', 1);
		h.construir_quarto (4, 'S', 2);
		h.construir_quarto (4, 'C', 3);
		h.construir_quarto (4, 'L', 4);
		*/
		
		// CRIANDO TODOS OS FUNCIONARIOS
		h.contrar_funcionario("Jose Andino", 20, "Rua jandira - 200 - ap 20", "RG", 345235, "jose@gmail.com", 9994321, 2000, 2, 1, 10);
		h.contrar_funcionario("Carlos Barg", 25, "Rua jantis - 431 - ap 10", "CPF", 846275, "carlos@gmail.com", 9997538, 2500, 5, 2, 30);
		h.contrar_funcionario("Joao Pinto", 18, "Avenida Sao Joao - 1002", "RG", 846204, "Joao@gmail.com", 99983523, 1000, 0, 3, 0);
		h.contrar_funcionario("Sergio da Silva", 30, "Rua jhonson - 666 - ap 69", "RG", 191019, "sergio@gmail.com", 9928473, 3000, 8, 4, 50);
		
		//CRIANDO TODOS HOSPEDES
		
		h.registrar_hospede ("Martin Garrix", 19, "Rua Albert Eisten - 18890 - ap 01", "Passaporte", 745268, "garrix@stmpd.com", 1946282, 1, "Holandes", 0);
		h.registrar_hospede ("Felipe Tampa", 28, "Rua Belo Horizonte - 90 - ap 100", "RG", 547392, "ftampa@revelead.com", 9947102, 2, "Brasileiro", 0);
		h.registrar_hospede ("Armin Van Bureen", 41, "Rua Amsterda - 8351", "Passaporte", 384623, "armin@armada.com", 458204, 3, "Holandes", 0);
		h.registrar_hospede ("KSHMR", 26, "Rua Altisten - 10386 - ap 99", "Passaporte", 6937478, "hardwell@sjmag.com", 284672, 4, "Indiano", 0);
		h.registrar_hospede ("Vintage Culture", 23, "Rua Deep House - 984 - ap 103", "CPF", 645273, "vintage@deep.com", 193482, 5, "Brasileiro", 0);
		
		//h.imprime_tudo();
		
		controlador.open_controlador(h);
		
	}

}
