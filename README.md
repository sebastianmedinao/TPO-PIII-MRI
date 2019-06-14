# Entrega TPO Programación 3 MRI (Pinamar)

> Alumno: Sebastian Aitor Medina Barrondo

> LU: 1081481

Implementación de las funcionalidades:
* Algoritmo BFS
* Algoritmo DFS
* Algoritmo de Prim
* Algoritmo de Kruskal

Los algoritmos se encuentran dentro de la clase GrafoDinamic.
Se provee un grafo dibujado en una imágen y el proyecto completo con código demo de este para su ejecución y prueba de cada algoritmo.

### Grafo precargado 1 (Kruskal - Prim)
![Grafo](https://github.com/sebastianmedinao/TPO-PIII-MRI/blob/master/TPO-P3MRI/grafo.jpg)

### Grafo precargado 2 (DFS - BFS)
![Grafo](https://github.com/sebastianmedinao/TPO-PIII-MRI/blob/master/TPO-P3MRI/grafo2.jpg)

## Algoritmo BFS
 
En el algoritmo Breadth First Search se utiliza una función principal que luego llama a otra recursiva para recorrer en anchura el grafo, utilizando una cola para agregar de manera ordenada los nodos.

**Procedimiento**
1. Crear un nodo auxiliar donde almaceno el nodo inicial recibido por parámetro
1. Inicializo una cola que usaré para el almacenamiento ordenado del resultado
1. Si el nodo es diferente a null llamo a una función recursiva BFS que recibe el nodo origen como parámetro.
1. La función BFS agrega el nodo a la cola y lo marca como visitado. Luego, itera hasta que la cola no esté vacía removiendo el primer elemento, obtengo sus vecinos (nodos conectados a este directamente), y para cada uno, si no es nulo y no está visitado, lo agrego a la cola y lo marco como visitado.

La utilización de una cola me permite hacer el recorrido en orden, de manera que el descubrimiento es horizontal y respeta la condición del descubrimiento en el ancho.

Impresión del resultado por consola.

## Algoritmo DFS

El procedimiento es bastante similar al BFS pero con algunas diferencias para cumplir el requerimiento del descubrimiento en profundidad.
En este caso utilizo una cola y flags para indicar los nodos visitados. Al descubrir un nodo nuevo, busco sus vecinos y continuo iterando en sus vecinos de manera individual, y luego de la recurrencia los agrego a la cola. Al finalizar la iteración, imprimo en consola el resultado de la cola.

## Algoritmo Kruskal

El código ha sido comentado línea por línea para indicar cómo funciona cada paso.
En este algoritmo utilizo 2 ArrayList para el almacenamiento de todos los nodos y aristas. Procedo a utilizar Kruskal_Recoleccion donde recorro el grafo entero recursivamente para descubrir todas las aristas y nodos que posee y agregarlas a los arreglos.
Mediante el Collections.sort() de Java, ordeno las aristas en forma creciente.
Realizo una iteración por el ArrayList de aristas para buscar la de menor costo. Si los nodos de la arista no forman un ciclo, procedo a insertar la arista y crear la unión de los nodos. Se agrega todo al grafo resultado y imprimo en consola el progreso.

## Algoritmo Prim

El código ha sido comentado línea por línea para indicar cómo funciona cada paso.
Utilizo una cola común para el almacen de aristas que obtengo del nodo iterado, y una cola prioridad para el almacen de todas las aristas descubiertas.
En el grafo resultado, agrego el vértice de origen, y cargo las aristas de este nodo. Comienza una iteración hasta que la cantidad de nodos del grafo resultante sea igual a la del grafo original.
Agrego las aristas descubiertas a la cola de prioridad, la cual se ordena según el peso de la arista por el Comparator de la clase.
Obtengo la primera arista de la cola prioridad y controlo si el nodo nuevo existe. Si existe, no hago nada. Si no existe, agrego el vértice al nuevo grafo y la arista, sumo el peso de la arista a un sumador del costo total, y procedo a setear el próximo nodo a descubrir como el nodo recién agregado.

### Resultado en consola
´´´
/// DFS ///
6, 7, 5, 4, 3, 8, 2, 1,  
 
/// BFS ///
1, 4, 3, 2, 6, 5, 8, 7,  
 
/// KRUSKAL ///
Arista agregada: 9-5 / Peso: 1
Arista agregada: 2-1 / Peso: 1
Arista agregada: 5-6 / Peso: 2
Arista agregada: 8-9 / Peso: 2
Arista agregada: 2-5 / Peso: 2
Arista agregada: 3-4 / Peso: 3
Arista agregada: 6-7 / Peso: 4
Arista agregada: 4-7 / Peso: 4
Costo minimo: 19
 
/// PRIM ///
Arista agregada: 1-2 / Peso: 1
Arista agregada: 2-5 / Peso: 2
Arista agregada: 5-9 / Peso: 1
Arista agregada: 9-8 / Peso: 2
Arista agregada: 5-6 / Peso: 2
Arista agregada: 6-7 / Peso: 4
Arista agregada: 7-4 / Peso: 4
Arista agregada: 4-3 / Peso: 3
Costo minimo: 19
´´´
