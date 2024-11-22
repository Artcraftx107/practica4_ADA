import java.util.HashSet;
import java.util.Set;

public class Cobertura {

	private Grafo grafo;

	public Cobertura(Grafo g) {
		grafo = g;
	}

	public Set<Integer> getConjuntoCobertura() {
		Set<Integer> cobertura = new HashSet<>();
		Set<String> aristasCubiertas = new HashSet<>();

		Set<String> todasLasAristas = new HashSet<>();
		for(int nodo : grafo.nodos()){
			for(int vecino : grafo.sucesores(nodo)){
				String arista = Math.min(nodo, vecino) + "-" + Math.max(nodo, vecino);
				todasLasAristas.add(arista);
			}
		}
		while (aristasCubiertas.size() < todasLasAristas.size()) {
			int nodoSeleccionado = -1;
			int maxAristasSinCubrir = -1;

			for (int nodo : grafo.nodos()) {
				int aristasSinCubrir = 0;

				for (int vecino : grafo.sucesores(nodo)) {
					String arista = Math.min(nodo, vecino) + "-" + Math.max(nodo, vecino);
					if (!aristasCubiertas.contains(arista)) {
						aristasSinCubrir++;
					}
				}

				if (aristasSinCubrir > maxAristasSinCubrir) {
					maxAristasSinCubrir = aristasSinCubrir;
					nodoSeleccionado = nodo;
				}
			}

			cobertura.add(nodoSeleccionado);

			for (int vecino : grafo.sucesores(nodoSeleccionado)) {
				String arista = Math.min(nodoSeleccionado, vecino) + "-" + Math.max(nodoSeleccionado, vecino);
				aristasCubiertas.add(arista);
			}
		}
		return cobertura;
	}
}
