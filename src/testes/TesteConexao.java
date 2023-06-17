package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

// softgraf.com/cursojava/drivers_jdbc
public class TesteConexao {

	final private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final private static String DATABASE = "agenda"; 
	final private static String URL = "localhost:3306";
	final private static String STRCONEXAO = "jdbc:mysql://" + URL + "/" + DATABASE;
	final private static String USER = "root";
	final private static String PASSWORD = "softgraf";

	public static void main(String[] args) {

		try {
			Class.forName(DRIVER);
			System.out.println("Encontrou o driver de conexão");
			
			Connection conexao = DriverManager.getConnection(STRCONEXAO, USER, PASSWORD);
			System.out.println("Abriu a conexão");
			
			conexao.close();
			System.out.println("Fechou a conexão");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Conector java/mysql não encontrado");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Falha de conexão com o banco");
			e.printStackTrace();
		}
		
	}

}
