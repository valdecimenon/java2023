package login;

public class TesteLogin {

	public static void main(String[] args) {
		
			Autenticacao.autenticar("Gabriel", "456");
			
			if (Login.nomeLogado != null) {
			
				System.out.println(Login.nomeLogado + " Bem vindo ao sistema");
			}
	}
}
