package Comodos;

public class FabricaQuartos {
	public static int numSolteiro;
	public static int numCasal;
	public static int numLuxo;
	public static int numFamilia;
	
	public static Solteiro criaSolteiro (int andar, int numero) {
		numSolteiro++;
		return new Solteiro (andar, numero);
	}
	
	public static Casal criaCasal (int andar, int numero) {
		numCasal++;
		return new Casal (andar, numero);
	}
	
	public static Familia criaFamilia (int andar, int numero) {
		numFamilia++;
		return new Familia (andar, numero);
	}

	public static Luxo criaLuxo (int andar, int numero) {
		numLuxo++;
		return new Luxo (andar, numero);
	}
	

}
