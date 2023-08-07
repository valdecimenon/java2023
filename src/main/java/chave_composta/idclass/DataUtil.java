package chave_composta.idclass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

	private static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static String formatarData(LocalDate data) {
		return formatador.format(data);
	}
}
