package adsaufgabe2;

/*
 * Aenderungen sind nur innerhalb der main()-Methode vorzunehmen!
 * Nichts ausserhalb muss angepasst werden.
 * Die einzige Ausnahme ist der Methodenaufruf Prim_MEINNAME().
 * Dieser ist in der in evaluate()-Methode zu finden.
 */

public class TestProgrammNeu {

	private static int[] expectedPredecessor;
	private static int[] expectedProcessingOrder;
	private static int expectedSumOfWeights;
	private static boolean graphIsFullyConnected;
	private static boolean erfolgreich;
	private static int currentTestcase = 0;

	public static void main(String[] args) {

		// =======================
		// Testfall 1 - vorgegeben
		// =======================
		Graph g = new Graph(4);
		g.addEdge(0, 3, 6);
		g.addEdge(0, 1, 3);
		g.addEdge(1, 2, 3);
		g.addEdge(3, 2, 2);
		g.addEdge(1, 3, 2);

		// Hier erwartete Ergebnisse eingeben.
		// Angabe, ob es sich um einen zusammenhaengenden Graphen handelt.
		graphIsFullyConnected = true;

		// Hier erwartete Ergebnisse eingeben.
		// Falls der Grpah unvollstaendig ist (graphIsFullyConnected == false) wird die
		// Kantensumme ignoriert.
		expectedSumOfWeights = 7;

		// Hier erwartete Ergebnisse eingeben.
		// Es ist das erwartete Ergebnis (kurz: erg), fuer den jeweiligen Knoten, anzugeben.
		// Format: {ergKnoten_0, ergKnoten_1, ergKnoten_2, ..., ergKnoten_n-1}
		// Falls der Grpah unvollstaendig ist (graphIsFullyConnected == false) werden
		// diese Arrays ignoriert.
		expectedPredecessor = new int[] { -1, 0, 3, 1 };
		expectedProcessingOrder = new int[] { 1, 2, 4, 3 };

		// nimmt Graph und Startknoten entgegen
		evaluate(g, 0);

		// =======================
		// Testfall 2 - vorgegeben
		// =======================
		g = new Graph(5);
		g.addEdge(0, 1, 7);
		g.addEdge(0, 3, 8);
		g.addEdge(0, 4, 6);
		g.addEdge(1, 3, 4);
		g.addEdge(1, 4, 3);
		g.addEdge(3, 4, 5);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = false;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] {};
		expectedProcessingOrder = new int[] {};

		evaluate(g, 0);

		// ===========================
		// Testfall 3 - nur ein Knoten
		// ===========================
		g = new Graph(1);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = true;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] { -1 };
		expectedProcessingOrder = new int[] { 1 };

		evaluate(g, 0);

		// =========================
		// Testfall 4 - keine Kanten
		// =========================
		g = new Graph(5);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = false;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] {};
		expectedProcessingOrder = new int[] {};

		evaluate(g, 0);

		// =====================================
		// Testfall 5 - nur Startknoten isoliert
		// =====================================
		g = new Graph(5);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 4, 2);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 3, 3);
		g.addEdge(2, 4, 7);
		g.addEdge(3, 4, 8);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = false;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] {};
		expectedProcessingOrder = new int[] {};

		evaluate(g, 0);

		// ============================================================
		// Testfall 6 - nur gleiche Kantengewichte mit Startknoten == 0
		// ============================================================
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 4, 1);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = true;
		expectedSumOfWeights = 4;
		expectedPredecessor = new int[] { -1, 0, 0, 0, 0 };
		expectedProcessingOrder = new int[] { 1, 2, 3, 4, 5 };

		evaluate(g, 0);
		
		// ============================================
		// Testfall 7 - zwei einzelne Graphen als einer
		// ============================================
		g = new Graph(6);
		g.addEdge(0, 1, 3);
		g.addEdge(1, 2, 5);
		g.addEdge(0, 2, 7);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 4);
		g.addEdge(3, 5, 2);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = false;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] {};
		expectedProcessingOrder = new int[] {};

		evaluate(g, 0);
		
		// =====================
		// Testfall 8 - P3-Graph
		// =====================
		g = new Graph(4);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 5);
		g.addEdge(2, 3, 6);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = true;
		expectedSumOfWeights = 12;
		expectedPredecessor = new int[] { -1, 0, 1, 2 };
		expectedProcessingOrder = new int[] { 1, 2, 3, 4 };

		evaluate(g, 0);
		
		// =============================
		// Testfall 9 - Startknoten != 0
		// =============================
		g = new Graph(5);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 4, 4);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 4, 5);
		g.addEdge(3, 4, 7);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = true;
		expectedSumOfWeights = 9;
		expectedPredecessor = new int[] { 3, 3, 1, -1, 0 };
		expectedProcessingOrder = new int[] { 2, 3, 4, 1, 5 };

		evaluate(g, 3);
		
		// =============================================================
		// Testfall 10 - nur gleiche Kantengewichte mit Startknoten != 0
		// =============================================================
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 4, 1);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = true;
		expectedSumOfWeights = 4;
		expectedPredecessor = new int[] { 2, 2, -1, 2, 2 };
		expectedProcessingOrder = new int[] { 2, 3, 1, 4, 5 };

		evaluate(g, 2);
		
		// =========================================
		// Testfall 11 - Startknoten existiert nicht
		// =========================================
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 4, 1);

		// Hier erwartete Ergebnisse eingeben.
		graphIsFullyConnected = false;
		expectedSumOfWeights = 0;
		expectedPredecessor = new int[] {};
		expectedProcessingOrder = new int[] {};

		try {
			evaluate(g, 10);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fehler: " + e);
			System.out.println("Hinweis: In diesem Testfall existiert der Startknoten nicht. Fuehrt dies vielleicht zu Problemen?");
		}
	}
	
	

	private static void evaluate(final Graph g, final int sourceVertex) {

		// ===========================
		// ===========================
		// TODO Bitte anpassen
		IPrim t = new Prim_lschneid();
		// ===========================
		// ===========================

		erfolgreich = true;
		currentTestcase++;

		System.out.println("==== TESTFALL " + currentTestcase + " ====");

		if (t.computeMSB(g, sourceVertex) != graphIsFullyConnected) {
			if (graphIsFullyConnected) {
				System.out.println("Fehler: Der Knoten " + sourceVertex + " ist enthalten");
			} else {
				System.out.println("Fehler: Sie sollten erkennen, dass der Graph unzusammenhaengend ist.");
			}
			erfolgreich = false;
		}

		if (graphIsFullyConnected) {
			for (int i = 0; i < expectedPredecessor.length; i++) {
				if (expectedPredecessor[i] != t.getPredecessor(i)) {
					System.out.println("Fehler: Knoten " + i + " hat nicht den Knoten " + t.getPredecessor(i)
							+ " als Vorgaenger.");
					erfolgreich = false;
					break;
				}
			}

			for (int i = 0; i < expectedProcessingOrder.length; i++) {
				if (expectedProcessingOrder[i] != t.getProcessingOrder(i)) {
					System.out.println("Fehler: Knoten " + i + " wird nicht im Schritt " + t.getProcessingOrder(i) + " bearbeitet.");
					erfolgreich = false;
					break;
				}
			}

			if (expectedSumOfWeights != t.getSumOfWeights()) {
				System.out.println("Fehler: Die Kantensumme ist nicht " + t.getSumOfWeights() + ".");
				erfolgreich = false;
			}
		}

		if (erfolgreich) {
			System.out.println("Testfall erfolgreich.\n");
		} else {
			System.out.println("Testfall fehlgeschlagen.\n");
		}
	}
}
