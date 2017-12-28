package excecao;

public class check_in extends Exception {

	private static final long serialVersionUID = 1L;
	static final public int USURARIONAOENCONTRADO = 1;
	static final public int FUNCIONARIONAOENCONTRADO = 2;
	private int Erro;
	
	public check_in (int e) {
		Erro = e;
	}
	
	public int get_erro () {
		return Erro;
	}

}
