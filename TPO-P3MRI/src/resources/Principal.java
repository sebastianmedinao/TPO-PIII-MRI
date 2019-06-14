package resources;

import grafo.GrafoDinamic;
import grafo.GrafosTDA;

public class Principal {

	public static void main(String[] args) {
		
		GrafosTDA g = new GrafoDinamic();		
		g.inicializarGrafo(0);		
		GrafoDemo.Precarga(g);
		System.out.println("/// DFS ///");		
		g.Ejecutar_DFS(1);
		
		System.out.println(" ");
		System.out.println(" ");
		
		g = new GrafoDinamic();		
		g.inicializarGrafo(0);		
		GrafoDemo.Precarga(g);
		System.out.println("/// BFS ///");		
		g.Ejecutar_BFS(1);
		
		System.out.println(" ");
		System.out.println(" ");
		
		g = new GrafoDinamic();		
		g.inicializarGrafo(0);		
		GrafoDemo.Precarga(g);
		System.out.println("/// KRUSKAL ///");	
		g.Ejecutar_Kruskal();
		
		System.out.println(" ");
		
		g = new GrafoDinamic();		
		g.inicializarGrafo(0);		
		GrafoDemo.Precarga(g);
		System.out.println("/// PRIM ///");	
		g.Ejecutar_Prim(1);
		
	}

	
	
}
