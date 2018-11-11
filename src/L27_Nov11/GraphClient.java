package L27_Nov11;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Nov-2018
 *
 */

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 20);
		graph.addEdge("B", "C", 5);
		graph.addEdge("C", "D", 3);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 2);
		graph.addEdge("F", "G", 30);
		graph.addEdge("E", "G", 50);

		graph.display();

		// graph.removeEdge("D", "E");
		// graph.removeEdge("A", "B");
		// graph.removeEdge("E", "F");

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		// System.out.println(graph.bfs("A", "F"));
		// System.out.println(graph.dfs("A", "F"));

		// graph.dft();

		System.out.println(graph.isConnected());
		System.out.println(graph.isCyclic());
		System.out.println(graph.isTree());
		System.out.println(graph.getCC());

		System.out.println(graph.isBipartite());

	}

}
