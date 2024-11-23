
import java.util.Arrays;
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
		int diffTotal = 0;
		Arrays.sort(datos);

		if(k>datos.length/2){
			k=datos.length-k;
		}
		for(int i = 0; i<datos.length; i++){
			if(i<k){
				a.add(i);
				diffTotal-=datos[i];
			}else{
				b.add(i);
				diffTotal+=datos[i];
			}
		}
		return diffTotal;
	}
}
