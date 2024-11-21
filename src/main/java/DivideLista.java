
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DivideLista {
	
	/**
	 * 
	 * @param datos lista de entrada
	 * @param k     longitud de una de las listas solución
	 * @param a   lista solución 1 (salida)
	 * @param b   lista solución 2 (salida)
	 * @return  la diferencia entre las dos listas
	 * 
	 */
	public static int resolverVoraz(int []datos, int k, List<Integer> a, List<Integer> b) {
		List<Integer> lista = new ArrayList<>();
		for(int num : datos){
			lista.add(num);
		}

		Collections.sort(lista, Collections.reverseOrder());

		b.addAll(lista.subList(0, k));
		a.addAll(lista.subList(k, lista.size()));

		int sumaB = b.stream().mapToInt(Integer::intValue).sum();
		int sumaA = a.stream().mapToInt(Integer::intValue).sum();

		return sumaB - sumaA;
	}
}
