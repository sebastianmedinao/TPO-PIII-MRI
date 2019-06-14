package grafo;


public interface GrafosTDA {
	
	public void inicializarGrafo(int dim);
	
	public void eliminarVertice(int v);
	
	public void agregarVertice(int v) ;
	
	public void agregarArista(int v1, int v2, int peso);
	
	public void eliminarArista(int v1, int v2);
	
	public boolean existeArista(int v1, int v2);
	
	public int pesoArista(int v1, int v2);
	
	public void mostrarMatriz();
	
	public boolean pertenece(int x);
			
	public void Ejecutar_DFS(int origen);
	
	public void Ejecutar_BFS(int origen);
	
	public GrafoDinamic Ejecutar_Kruskal();
	
	public GrafoDinamic Ejecutar_Prim(int inicio);
}
