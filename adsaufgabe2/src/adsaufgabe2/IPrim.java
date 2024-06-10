package adsaufgabe2;

/**
 * Klassen, die dieses Interface implementieren, enthalten eine
 * Implementation des Prim-Algorithmus zur Erstellung des 
 * minimalen Spannbaums.
 * 
 * Zur Verwendung:
 * 1. Durch Aufruf der Methode computeMSB wird der Algorithmus
 *    durchgefuehrt und seine Ergebnisse innerhalb der Klasse gespeichert
 * 2. Fuer die einzelnen Knoten kann anschliessend der Vorgaenger und
 *    die Reihenfolge der bearbeiteten Knoten im Algorithmus erfragt 
 *    werden.
 *
 * Es koennen nacheinander mehrfach die Schritte (1) und (2) ausgefuehrt
 * werden und es ist auch die gleichzeitige Durchfuehrung in mehreren
 * Objekten der Klasse moeglich.
 */

public interface IPrim {

    /**
     * Der Prim-Algorithmus wird durchgefuehrt.
     * Wie in der Vorlesung wird bei mehreren Knoten mit dem gleichen 
     * minimalen Abstandswert derjenige Knoten ausgewaehlt, der den 
     * kleineren Index (Nummer des Knotens) besitzt.
     * 
     * @param graph zu untersuchender Graph
     * @param sourceVertex Index des Startknotens
     * @return true gdw. der Startknoten im Graphen enthalten war und 
     *         alle Knoten des Graphen erreicht wurden
     */
    public boolean computeMSB(IGraph graph, int sourceVertex);

    /**
     * Fuer einen Knoten im Graphen wird der Vorgaengerknoten aus der
     * MSB-Berechnung fuer den letzten Aufruf von 
     * computeMSB geliefert.
     *
     * @param targetVertex Nummer eines beliebigen Knotens im Graphen
     * @return Nummer des Vorgaengerknotens bzw. -1 falls Knoten oder
     *         Vorgaengerknoten nichts existiert
     */
    public int getPredecessor(int targetVertex);

    /**
     * Die Summe der Gewichte aus dem zuletzt errechneten minimalen
     * Spannbaum wird geliefert.
     *
     * @return Nummer des Vorgaengerknotens bzw. -1 falls Knoten oder
     *         Vorgaengerknoten nichts existiert
     */
    public int getSumOfWeights();

    /**
     * Der Prim-Algorithmus muss die Reihenfolge der bearbeiteten
     * Knoten abspeichern, sodass mit dieser Methode erfragt werden kann,
     * an welcher Stelle der erfragte Knoten bearbeitet, d.h. seine 
     * Kanten untersucht, wurde.
     *
     * @param vertex Nummer eines beliebigen Knotens im Graphen
     * @return Nummer aus 1,...,size , die der Bearbeitungsreihenfolge
     *         entspricht; falls nicht bearbeitet: 0
     */
    public int getProcessingOrder(int vertex);
}
