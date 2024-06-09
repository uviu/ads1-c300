package adsaufgabe2;

public class Prim_lschneid implements IPrim {
	
	private int[] abstand;
	private int[] vorgaenger;
	private boolean[] istFertig;
	private int[] processingOrder;
	
    public Prim_lschneid() {
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public boolean computeMSB(IGraph graph, int sourceVertex) {
    	
    	if(sourceVertex > graph.getNumberVertices() - 1) {
    		return false;
    	}
    	
    	abstand = new int[graph.getNumberVertices()];
    	vorgaenger = new int[graph.getNumberVertices()];
    	istFertig = new boolean[graph.getNumberVertices()];
    	processingOrder = new int[graph.getNumberVertices()];
    	
    	for(int i = 0; i <= graph.getNumberVertices() - 1; i++) {
    		abstand[i] = -1;
    		vorgaenger[i] = -1;
    		istFertig[i] = false;
    		processingOrder[i] = 0;
    	}
    	
    	abstand[sourceVertex] = 0;
    	
    	int naechster;
    	int processingStep = 0;
    	
    	while(knotenVorhanden(graph)) {
    		naechster = naechsterKnoten(graph);
    		istFertig[naechster] = true;
    		processingStep++;
    		processingOrder[naechster] = processingStep;
    		
    		for(int i = 0; i <= graph.getNumberVertices() - 1; i++) {
    			if(graph.containsEdge(i, naechster) && abstand[i] > graph.getWeight(naechster, i) && istFertig[i] == false) {
    				abstand[i] = graph.getWeight(naechster, i);
    				vorgaenger[i] = naechster;
    			}
        	}
    	}
    	
		for(int i = 0; i <= graph.getNumberVertices() - 1; i++) {
    		if( abstand[i] == -1) {
    			return false;
    		}
    	}
    		
	return true;
    }
    
    private int naechsterKnoten(IGraph graph) {
    	int minimumWert = -1;
    	int naechster = -1;
    	for(int i = 0; i <= graph.getNumberVertices() - 1; i++) {
    		if(( minimumWert == -1 || abstand[i] < minimumWert ) && istFertig[i] == false ) {
    			minimumWert = abstand[i];
    			naechster = i;
    		}
    	}
		return naechster;
    }
    
    private boolean knotenVorhanden(IGraph graph) {
    	for(int i = 0; i <= graph.getNumberVertices() - 1; i++) {
    		if(abstand[i] > -1 && istFertig[i] == false) {
    			return true;
    		}
    	}
		return false;
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public int getPredecessor(int targetVertex) {
    	if(targetVertex > vorgaenger.length - 1) {
    		return -1;
    	}
    	return vorgaenger[targetVertex];
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public int getSumOfWeights() {
    	int sumOfWeights = 0;
    	for(int i = 0; i < abstand.length; i++) {
    		sumOfWeights += abstand[i];
    	}
    	return sumOfWeights;
    }

    // Bitte Spezifikation in IDijkstra beachten!
    public int getProcessingOrder(int vertex) {
    	if(vertex > processingOrder.length - 1) {
    		return 0;
    	}
    	return processingOrder[vertex];
    }
    
    
}
