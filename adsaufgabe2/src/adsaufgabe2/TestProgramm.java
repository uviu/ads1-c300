package adsaufgabe2;

public class TestProgramm {

    public TestProgramm() {
    }
    
    public static void main(String[] args) {
	
	// Testfall 1
	Graph g = new Graph(4);
	g.addEdge(0,3,6);
	g.addEdge(0,1,3);
	g.addEdge(1,2,3);
	g.addEdge(3,2,2);
	g.addEdge(1,3,2);
	boolean erfolgreich = true;
	IPrim t = new Prim_lschneid();
	if (!t.computeMSB(g,0)) {
	    System.out.println("Fehler: Der Knoten 0 ist enthalten");
	    erfolgreich = false;
	}
	int vorg = t.getPredecessor(2);
	if (vorg != 3) {
	    System.out.println("Fehler: Knoten 3 hat falschen Vorgaenger " + vorg);
	    erfolgreich = false;
	}
	int summe = t.getSumOfWeights();
	if (summe != 7) {
	    System.out.println("Fehler: MSB hat falsches Gewicht " + summe);
	    erfolgreich = false;
	}
	int nummer = t.getProcessingOrder(2);
	if (nummer != 4) {
	    System.out.println("Fehler: Knoten 2 wurde fehlerhaft im Schritt " + nummer + " bearbeitet");
	    erfolgreich = false;
	}
	if (erfolgreich)
	    System.out.println("Der Testfall 1 wurde erfolgreich gemeistert.");
	else
	    System.out.println("Der Testfall 1 zeigt Fehler in Ihrem Programm.\n");
	
	// Testfall 2
	g = new Graph(5);
	g.addEdge(0,1,7);
	g.addEdge(0,3,8);
	g.addEdge(0,4,6);
	g.addEdge(1,3,4);
	g.addEdge(1,4,3);
	g.addEdge(3,4,5);
	erfolgreich = true;
	t = new Prim_lschneid();
	if (t.computeMSB(g,0)) {
	    System.out.println("Fehler: Sie sollten erkennen, dass der Graph unzusammenhaengend ist.");
	    erfolgreich = false;
	}
	if (erfolgreich)
	    System.out.println("Der Testfall 2 wurde erfolgreich gemeistert.");
	else
	    System.out.println("Der Testfall 2 zeigt Fehler in Ihrem Programm.\n");
    }

}
