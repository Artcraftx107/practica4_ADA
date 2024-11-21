import java.util.ArrayList;
import java.util.List;

public class Antenas {
	
	private Integer[] puntosKm; //Puntos kilometricos de las urbanizaciones ordenados crecientemente.
	private int cobertura;
		
	public Antenas(Integer[] urbanizaciones, int c) {
		puntosKm = urbanizaciones;
		cobertura=c;
		
	}
	
	public List<Integer> situarAntenas(){
		List<Integer> antenas = new ArrayList<>();
		int i = 0;

		while(i < puntosKm.length){
			int ubicacionAntena = puntosKm[i] + cobertura;
			antenas.add(ubicacionAntena);

			while(i < puntosKm.length && puntosKm[i] <= ubicacionAntena + cobertura){
				i++;
			}
		}
		return antenas;
	}
}
