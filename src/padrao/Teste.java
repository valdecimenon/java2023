package padrao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import static java.lang.System.out;

public class Teste {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("maça");
		lista.add("uva");
		lista.add("kiwi");
		
		//lambda
		// =>
		// lambda
		// method reference
		lista.forEach(out::println);
	}
	
}
