package adsaufgabe2;

public class Graph implements IGraph {

    private boolean[][] adj;
    private int[][] gamma;
    private int size;
    
    public Graph(int size) {
	this.size = size;
	adj = new boolean[size][];
	for (int i=1; i<size; i++)
	    adj[i] = new boolean[i];
	gamma = new int[size][];
	for (int i=1; i<size; i++)
	    gamma[i] = new int[i];
    }

    public void addEdge(int from, int to, int weight) {
	if (from>=0 && to>=0 && from<size && to<size && from!=to) {
	    if (from < to) {
		adj[to][from] = true;
		gamma[to][from] = weight;
	    } else {
		adj[from][to] = true;
		gamma[from][to] = weight;
	    }
	}
    }
	
    public boolean containsEdge(int from, int to) {
	if (from==to)
	    return false;
	if (from < to)
	    return adj[to][from];
	return adj[from][to];
    }

    public int getWeight(int from, int to) {
	if (from==to)
	    return 0;
	if (from < to && adj[to][from])
	    return gamma[to][from];
	if (adj[from][to])
	    return gamma[from][to];
	return 0;
    }
    
    public int getNumberVertices() {
	return size;
    }
}
