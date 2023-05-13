package estoque;

public enum Opcao {

	LISTAR(1, "1. Listar produtos" ),
	INCLUIR(2, "2. Incluir produtos"), 
	EXCLUIR(3, "3. Excluir produtos"),
	MOSTRAR_QUANT(4, "4. Mostrar quantidade total de produtos"),
	MOSTRAR_VALOR(5, "5. Mostrar valor total do estoque"),
	SALVAR_EXCEL(6, "6. Salvar para formato CSV"),
	LER_EXCEL(7, "7. Ler formato CSV"),
	SAIR(0, "0. Sair do sistema");
	
	private final int codigo;
	private final String msg;
	
	private Opcao(int codigo, String msg) {
		this.codigo = codigo;
		this.msg = msg;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void imprimir() {
		System.out.println(msg);
	}
	
	public int getCodMin() {
		return 0;
	}
	
	public int getCodMax() {
		return 7;
	}
}
