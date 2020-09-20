import java.util.*;

class Graph<T> {

	private Map<T, List<T>> map = new HashMap<>();

	public void addEdge(T source, T destination, boolean bidirectional) {
		
		if (!map.containsKey(source))
			addVertex(source);
		if (!map.containsKey(destination))
			addVertex(destination);
		
		map.get(source).add(destination);
		if (bidirectional)
			map.get(destination).add(source);
	}

	public void addVertex(T node) {
		map.put(node, new LinkedList<T>());
	}
	
	public int getVerticesCount() {
		return map.size();
	}
	
	public int getEdgesCount() {
		int count = 0;
		for(T v : map.keySet()) {
			count += map.get(v).size();
		}
		return count;
	}
	
	public boolean hasVertex(T node) {
		
		if(map.containsKey(node))
			return true;
		return false;
	}
	
	public boolean hasEdge(T source, T destination) {
		
		if(map.get(source).contains(destination))
			return true;
		
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T v : map.keySet()) {
			sb.append(v.toString()+" : ");
			for(T w : map.get(v)) {
				sb.append(w.toString()+" -> ");
			}
			sb.replace(sb.length()-3, sb.length(), "");
			sb.append("\n");
		}
		
		return sb.toString();
	}
}

public class GraphImplementation {

	public static void main(String args[]) {
		
		Graph<Integer> graph = new Graph<Integer>();

		graph.addEdge(0, 1, true);
		graph.addEdge(0, 4, true);
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(1, 4, true);
		graph.addEdge(2, 3, true);
		graph.addEdge(3, 4, true);

		System.out.println(graph);
		
		System.out.println("Any Edge from 1-4 : "+graph.hasEdge(1, 4));
		System.out.println("Any Edge from 1-4 : "+graph.hasEdge(0, 3));
		System.out.println("Does it contains a node 5 ? : "+graph.hasVertex(5));
		System.out.println("Total number of vertices : "+graph.getVerticesCount());
		System.out.println("Total number of edges : "+graph.getEdgesCount());
	}
}
