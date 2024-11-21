import java.util.HashSet;
import java.util.Set;

public class Cobertura {

	private Grafo grafo;

	public Cobertura(Grafo g) {
		grafo = g;
	}

	public Set<Integer> getConjuntoCobertura() {
		Set<Integer> cobertura = new HashSet<>();
		boolean[] nodoEnCobertura = new boolean[grafo.nodos().size()];
		int aristasCubiertas = 0;

		while(aristasCubiertas < grafo.numAristas()){
			int maxGrado = -1;
			int nodoSeleccionado = -1;

			for(int nodo : grafo.nodos()){
				if(!nodoEnCobertura[nodo]){
					int grado = grafo.grado(nodo);
					if(grado > maxGrado){
						maxGrado = grado;
						nodoSeleccionado = nodo;
					}
				}
			}

			cobertura.add(nodoSeleccionado);
			nodoEnCobertura[nodoSeleccionado] = true;

			for(int vecino : grafo.sucesores(nodoSeleccionado)){
				aristasCubiertas++;
			}
		}

		return cobertura;
	}
}
