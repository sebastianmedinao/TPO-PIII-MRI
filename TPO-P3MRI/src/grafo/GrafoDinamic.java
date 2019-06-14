package grafo;

import java.util.*;

public class GrafoDinamic implements GrafosTDA {
	NodoGrafo nodo;
	int cantidad;
	private Queue<NodoGrafo> queue;
	
	static final int NO_VISITADO = 0;
	static final int DESCUBIERTO = 1;
	static final int VISITADO = 2;

	public void inicializarGrafo(int dim) {
		nodo = null;
		cantidad = 0;
	}
	
	public void eliminarVertice(int v) {
		NodoGrafo aux = encontrarNodo(v);
		
		if(aux != null) {
			aux = nodo; 
			if(aux.valor == v) {
				nodo = aux.sig;
				System.out.println("1");
			}
			while(aux != null) {
				this.eliminarArista(aux.valor, v);	
				if(aux.sig == this.encontrarNodo(v) && aux.sig != null) {
					aux.sig = aux.sig.sig;
					cantidad--;
					System.out.println("1");
				}
					aux = aux.sig;
					System.out.println("2");
			}
			
		} else {
			System.out.println("El vertice no existe");
		}

		
	}

	public void agregarVertice(int v) {
		if(this.encontrarNodo(v) == null) {
		
			NodoGrafo aux = new NodoGrafo();
			aux.valor = v;
			aux.lista = null;
			aux.sig = nodo;
			aux.Visitado = false;
			aux.marcado = false;
			nodo = aux;
			cantidad++;
		}	
			
	}

	public void agregarArista(int v1, int v2, int peso) {
		if(this.encontrarNodo(v1) != null && this.encontrarNodo(v2) != null) {
			NodoArista aux = new NodoArista();
			aux.v1 = this.encontrarNodo(v1);
			aux.peso = peso;
			aux.visitado = false;
			aux.v2 = this.encontrarNodo(v2);
			aux.sig = encontrarNodo(v1).lista;
			encontrarNodo(v1).lista = aux;
			
			// Modificación para doble enlazado
			aux = new NodoArista();
			aux.v1 = this.encontrarNodo(v2);
			aux.peso = peso;
			aux.visitado = false;
			aux.v2 = this.encontrarNodo(v1);
			aux.sig = encontrarNodo(v2).lista;
			encontrarNodo(v2).lista = aux;
						
		} else {
			System.out.println("No existe alguino de los nodos");
		}
	}
	
	
	public void eliminarArista(int v1, int v2) {
		NodoGrafo nodo = encontrarNodo(v1);
		
		NodoArista arista = nodo.lista;
		if(arista != null) {
			if(arista.v2.valor == v2) {
				nodo.lista = arista.sig;
			}
			else {
				while(arista.sig != null && arista.v2.valor == v2) {
					arista = arista.sig;
				}
				if(arista.sig != null) {
					arista.sig = arista.sig.sig;
				}				
			}			
		}
	}
	
	public boolean existeArista(int v1, int v2) {
		NodoGrafo aux = this.encontrarNodo(v1);
		NodoArista arista = aux.lista ;
		while(arista != null) {
			if(arista.v2.valor == v2) {
				return true;
			}
			arista = arista.sig;
		}		
		return false;
	}

	public int pesoArista(int v1, int v2) {
		NodoGrafo g1 = this.encontrarNodo(v1);
		NodoGrafo g2 = this.encontrarNodo(v2);
		NodoArista aux;
		
		if (g1 == null || g2 == null) return 0;
		
		aux = g1.lista;
		while (aux != null) {
			if (aux.v2.valor == v2) {
				return aux.peso;
			} else {
				aux = aux.sig;
			}
		}
		
		aux = g2.lista;
		while (aux != null) {
			if (aux.v2.valor == v1) {
				return aux.peso;
			} else {
				aux = aux.sig;
			}
		}

		return 0;
	}

	public void mostrarMatriz() {
		NodoGrafo aux = nodo;
		NodoArista arista;
		while(aux != null) {
		System.out.print(aux.valor + "\t" );
		arista = aux.lista;
			while(arista != null) {				
				System.out.print(arista.v2.valor + " (" + arista.peso + ") \t");
				arista = arista.sig;
			}
			System.out.println();
			aux = aux.sig;
		}
	}

	public boolean pertenece(int x) {
		if (this.encontrarNodo(x) != null) {
			return true;
		}
		return false;
	}

	public NodoGrafo encontrarNodo(int v) {
		NodoGrafo aux = nodo;
		while(aux != null) {
			if(aux.valor == v) {
				return aux;
			}
			aux = aux.sig;
		}
		return null;
	}
	
	
	/////////////////////////////////////////////////////
	/////////////// Comienzo algoritmos /////////////////
	/////////////////////////////////////////////////////

	
	private ArrayList<NodoGrafo> getVecinos(NodoGrafo n) {
		NodoArista aux = new NodoArista();
		ArrayList<NodoGrafo> grafos = new ArrayList<NodoGrafo>();
		
		aux = n.lista;
		while (aux != null) {			
			if (!grafos.contains(aux.v2)) grafos.add(aux.v2);
			if (!grafos.contains(aux.v1)) grafos.add(aux.v1);			
			aux = aux.sig;
		}	
		
		return grafos;			
	}
	
	private ArrayList<NodoGrafo> getVecinosDirigido(NodoGrafo n) {
		NodoArista aux = new NodoArista();
		ArrayList<NodoGrafo> grafos = new ArrayList<NodoGrafo>();
		
		aux = n.lista;
		while (aux != null) {			
			if (!grafos.contains(aux.v2)) grafos.add(aux.v2);		
			aux = aux.sig;
		}	
		
		return grafos;			
	}
	
	public void Ejecutar_DFS(int origen) { // Ejecución de algoritmo DFS
		NodoGrafo aux = this.encontrarNodo(origen);
		Queue<Integer> cola = new LinkedList<Integer>();
		int[] status = new int[cantidad+1];
		if (aux != null) {
			DFS(aux, cola, status);
		}		
	    while (!cola.isEmpty()) {
			System.out.print(cola.remove() + ", ");
		}
		
	}
	
	private void DFS(NodoGrafo g, Queue<Integer> cola, int[] status) { // Recursión DFS
		//System.out.print(g.valor + " ");
		
		status[g.valor] = DESCUBIERTO;
	
		ArrayList<NodoGrafo> vecinos = getVecinosDirigido(g);
		
		vecinos.forEach((v) -> {
			if (status[v.valor] == NO_VISITADO)
				DFS(v, cola, status);	
		});
		
		status[g.valor] = VISITADO;
		cola.add(g.valor);
	}

	public void Ejecutar_BFS(int origen) { // Ejecución de algoritmo BFS
		NodoGrafo aux = this.encontrarNodo(origen);		
		if (aux != null) {
			queue = new LinkedList<NodoGrafo>();			
			BFS(aux);
		}
	}
	
	private void BFS(NodoGrafo g) { // Recursión BFS
		queue.add(g);
		
		g.Visitado = true;
		
		while (!queue.isEmpty()) {
			NodoGrafo aux = queue.remove();
			
			System.out.print(aux.valor + ", ");
			
			ArrayList<NodoGrafo> vecinos = getVecinos(aux);
			
			vecinos.forEach((v) -> {
				if (v != null && !v.Visitado) {
					queue.add(v);
					v.Visitado = true;
				}
			});
		}

	}
	
	private void Kruskal_Recoleccion(NodoGrafo n, ArrayList<NodoGrafo> nodos, ArrayList<NodoArista> aristas) { // Recoleccion de datos
		NodoArista aux = null;
		if (!nodos.contains(n)) {
			nodos.add(n);
			aux = n.lista;
			while (aux != null) {
				aristas.add(aux);
				if (!nodos.contains(aux.v2)) Kruskal_Recoleccion(aux.v2, nodos, aristas);
				aux = aux.sig;
			}			
		}
		if (n.sig != null) Kruskal_Recoleccion(n.sig, nodos, aristas);
	}
	
	private void Kruskal_CopiaVertices(ArrayList<NodoGrafo> nodos, GrafosTDA resultado) { // Insertado de Array de nodos a un grafo nuevo
		nodos.forEach((n) -> {
			resultado.agregarVertice(n.valor);
		});
	}
	
    private void Kruskal_SetParientes(int [] parientes, ArrayList<NodoGrafo> vertices) { // Generacion del array de parientes
    	vertices.forEach((n) -> {
    		parientes[n.valor] = n.valor;
    	});
    }

    private int Kruskal_Buscar(int [] parientes, int vertice) { // Buscador de la cadena de parientes de un vertice recursivamente
        if (parientes[vertice] != vertice) 
        	return Kruskal_Buscar(parientes, parientes[vertice]);
        else
        	return vertice;
    }

    private void Kruskal_Union(int [] parientes, int x, int y) { // Hacer X padre de Y
        int x_pariente = Kruskal_Buscar(parientes, x);
        int y_pariente = Kruskal_Buscar(parientes, y);
        parientes[y_pariente] = x_pariente;
    }
	
	public GrafoDinamic Ejecutar_Kruskal() {		
		ArrayList<NodoGrafo> nodos = new ArrayList<NodoGrafo>(); // Lista de todos los nodos
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>(); // Lista de todas las aristas
		GrafoDinamic resultado = new GrafoDinamic(); // Grafo resultado
		int[] parientes = new int[cantidad+1]; // Arreglo de almacen de los parientes de cada nodo
		int i = 0;
		int costo = 0;
		
		resultado.inicializarGrafo(0);
		
		Kruskal_Recoleccion(nodo, nodos, aristas); // Recolección de todos los nodos y aristas del grafo de manera ordenada
				
		Collections.sort(aristas); // Ordenación de aristas segun peso utilizando Comparator y Sort de Java
		
		Kruskal_CopiaVertices(nodos, resultado); // Copia de los vertices existentes en el grafo resultado
		Kruskal_SetParientes(parientes, nodos); // Seteo inicial de parientes en los nodos
		
		while (i < nodos.size() - 1) {
			NodoArista t = aristas.remove(0); // Tomo la primer arista
			
			 int x = Kruskal_Buscar(parientes, t.v1.valor); // Busco parientes de ambos nodos para verificar ciclo
             int y = Kruskal_Buscar(parientes, t.v2.valor);
             
             if (x != y) { // Comprobamos que no alcancen al mismo pariente, es decir, que no forme un ciclo
                 Kruskal_Union(parientes, x, y);
                 resultado.agregarArista(t.v1.valor, t.v2.valor, t.peso); // Agregar nueva arista de minimo costo
                 costo += t.peso; // Sumatoria del costo total
                 System.out.println("Arista agregada: " + t.v1.valor + "-" + t.v2.valor + " / Peso: " + t.peso);
                 i++;
             }			
			
		}
		
		System.out.println("Costo minimo: " + costo);
		
		return resultado;
	}
	
	public Queue<NodoArista> Prim_ObtenerAristas(NodoGrafo n) {
		Queue<NodoArista> result = new LinkedList<NodoArista>();
		NodoArista aux;
		
		aux = n.lista;
		
		while (aux != null) {
			result.add(aux);
			aux = aux.sig;
		}

		return result;
	}
	
	public GrafoDinamic Ejecutar_Prim(int inicio) {
		Queue<NodoArista> aristas;	// Cola de almacenamiento de aristas obtenidas
		PriorityQueue<NodoArista> cola = new PriorityQueue<>();	// Cola de prioridad ordenada por Comparator para la lista de adyacencia
		GrafoDinamic resultado = new GrafoDinamic();	// Grafo resultado que será devuelto
		NodoArista arista;	// Almacenamiento temporal de la arista observada en iteración
		int observado;	// Almacenamiento temporal del nodo observado en la iteración
		int costo = 0;	// Sumador del costo total
		
		NodoGrafo n = this.encontrarNodo(inicio); // Cargo nodo inicial elegido
				
		resultado.inicializarGrafo(0);
		resultado.agregarVertice(n.valor); // Agrego el vertice de inicio
				
		aristas = Prim_ObtenerAristas(n); // Obtengo las aristas del vertice inicial
		
		while (resultado.cantidad < cantidad) {	// Condición de corte: Mientras la cantidad de nodos del grafo resultado sea menor a la cantidad de nodos del grafo original ...
			while (!aristas.isEmpty()) { // Carga de las aristas a la cola prioridad
				cola.add(aristas.remove());
			}
									
			arista = cola.remove(); // Obtengo valor de la cola (ordenada)
									
			if (resultado.encontrarNodo(arista.v1.valor) == null) { // Analizo cual de los extremos de la arista es el nuevo nodo
				observado = arista.v1.valor;
			} else if (resultado.encontrarNodo(arista.v2.valor) == null) {
				observado = arista.v2.valor;
			} else {
				observado = 0; // El vertice nuevo ya existe en el grafo resultado
			}
							
			if (observado != 0) {				
				resultado.agregarVertice(observado); // Agrego el nuevo vertice y arista al resultado
				resultado.agregarArista(arista.v1.valor, arista.v2.valor, arista.peso);
				
				aristas = Prim_ObtenerAristas(this.encontrarNodo(observado)); // Reanalizo las aristas del nodo agregado para la próxima iteración
				
				System.out.println("Arista agregada: " + arista.v1.valor + "-" + arista.v2.valor + " / Peso: " + arista.peso);
								
				costo += arista.peso; // Sumatoria del costo final
		
				n = this.encontrarNodo(observado); // Procedo a descubrir el siguiente nodo desde el observado				
			}
			
		}
				
		System.out.println("Costo minimo: " + costo);
		
		return resultado;
	}
	
	
	
}
