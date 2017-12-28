package Data;

public class Data {

	public double hora;
	public int dia;
	public int mes;
	public int ano;
	
	public Data (double h, int d, int m, int a){
		hora = h;
		dia = d;
		mes = m;
		ano = a;
	}
	
	public int Calcula_tempo_total (Data atual) {
		int total = 0;
		if (this.dia > atual.dia) {
			while (this.dia != atual.dia ) {
				this.dia --;
				total--;
			}
		} else if (this.dia < atual.dia){
			while (this.dia != atual.dia ) {
				this.dia ++;
				total++;
			}
		}
		
		if (this.mes > atual.mes) {
			while (this.mes != atual.mes) {
				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 9 || mes == 11) {
					total -= 31;
				} else if (mes == 2) {
					total -= 28;
				} else {
					total -= 30;
				}
				this.mes--;
			}
		} else  if (this.mes < atual.mes){
			while (this.mes != atual.mes) {
				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 9 || mes == 11) {
					total += 31;
				} else if (mes == 2) {
					total += 28;
				} else {
					total += 30;
				}
				this.mes++;
			}
		}
		
		while (this.ano != atual.ano) {
			total += 365;
			this.ano++;
		}

		if (this.hora > atual.hora) {
			total++;
		}
		
		return total;
		
	}
	
	public int verifica_possivel_reserva (Data atual) {
		int d, m, a;
		d = this.dia;
		m = this.mes;
		a = this.ano;
		int total = 0;
		if (d > atual.dia) {
			while (d != atual.dia ) {
				d --;
				total--;
			}
		} else if (d < atual.dia){
			while (d != atual.dia ) {
				d ++;
				total++;
			}
		}
		
		if (m > atual.mes) {
			while (m != atual.mes) {
				if (m == 1 || m == 3 || m == 5 || m == 7 || m == 9 || m == 11) {
					total -= 31;
				} else if (m == 2) {
					total -= 28;
				} else {
					total -= 30;
				}
				m--;
			}
		} else  if (m < atual.mes){
			while (m != atual.mes) {
				if (m == 1 || m == 3 || m == 5 || m == 7 || m == 9 || m == 11) {
					total += 31;
				} else if (m == 2) {
					total += 28;
				} else {
					total += 30;
				}
				m++;
			}
		}
		
		if (a < atual.ano) {
			while (a != atual.ano) {
				total += 365;
				a++;
			}
		} else if (a > atual.ano) {
			while (a != atual.ano) {
				total -= 365;
				a--;
			}
		}
		
		return total;
		
	}
	
	public int check_data (Data cheg, Data said, Data saida) {
		int flag_1 = 0;
		int flag_2 = 0;
		int flag_3 = 0;
		int flag_4 = 0;
		
		if (this.verifica_possivel_reserva(cheg) >= 0) {
			flag_1 = 1;
		}
		
		if (this.verifica_possivel_reserva(said) <= 0) {
			flag_2 = 1;
		}
		
		if (saida.verifica_possivel_reserva(cheg) <= 0) {
			flag_3 = 1;
		}
		
		if (saida.verifica_possivel_reserva(said) >= 0) {
			flag_4 = 1;
		}
		
		if ((flag_1 == 1 && flag_3 == 1) || (flag_2 == 1 && flag_4 == 1) || (flag_2 == 0 && flag_4 == 0) || (flag_1 == 0 && flag_2 == 0 && flag_3 == 1 && flag_3 == 1)) {
			return - 1;
		} else {		
			return 0;
		}
		
	}
	
	public void atualiza() {
		dia++;
		if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 9 || mes == 11) && dia == 32) {
			dia = 1;
			mes++;
		} else if((mes == 4 || mes == 6 || mes == 8 || mes == 10|| mes == 12) && dia == 31) {
			dia = 1;
			mes++;
		} else if (mes == 2 && dia == 29) {
			dia = 1;
			mes++;
		}
		if (mes == 13) {
			mes = 1;
			ano++;
		}
	}
	
	public void imprime_data() {
		System.out.println("Hora: " +hora);
		System.out.println("Dia: " +dia);
		System.out.println("Mes: " +mes);
		System.out.println("Ano: " +ano);
	}
	
	
}
