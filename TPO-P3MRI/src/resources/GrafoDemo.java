package resources;

import grafo.GrafosTDA;

public class GrafoDemo {
	
	public static void Precarga(GrafosTDA g) {
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		g.agregarVertice(9);
		
		g.agregarArista(1, 2, 1);	
		g.agregarArista(1, 3, 10);
		g.agregarArista(2, 5, 2);
		g.agregarArista(2, 6, 7);
		g.agregarArista(2, 4, 6);
		g.agregarArista(4, 7, 4);
		g.agregarArista(4, 3, 3);
		g.agregarArista(4, 1, 5);
		g.agregarArista(5, 6, 2);
		g.agregarArista(6, 9, 5);
		g.agregarArista(7, 6, 4);
		g.agregarArista(7, 8, 5);
		g.agregarArista(8, 9, 2);
		g.agregarArista(9, 5, 1);
		
	}
	
	public static void Precarga2(GrafosTDA g) {
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		
		g.agregarArista(1, 2, 1);	
		g.agregarArista(1, 3, 1);
		g.agregarArista(1, 4, 1);
		g.agregarArista(2, 8, 1);
		g.agregarArista(4, 5, 1);
		g.agregarArista(4, 6, 1);
		g.agregarArista(5, 7, 1);
		
	}

}
