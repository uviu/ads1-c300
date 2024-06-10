package adsaufgabe2;

public interface IGraph {

	/**
	 * Getter zur Abfrage, ob eine Kante im Graphen existiert. Dabei sind 
	 * die Indizes der Knoten in der Menge {0,...,(n-1)} fuer einen Graph
	 * mit n Knoten.
	 * @param from Index des Startknotens der Kante
	 * @param to Index des Zielknotens der Kante
	 * @return	Information, ob diese Kante existiert
	 */
	public boolean containsEdge(int from, int to);

	/**
	 * Getter fuer ein Kantengewicht. Dabei sind 
	 * die Indizes der Knoten in der Menge {0,...,(n-1)} fuer einen Graph
	 * mit n Knoten.
	 * @param von Index des Startknotens der Kante
	 * @param nach Index des Zielknotens der Kante
	 * @return	Kantengewicht bzw. 0 falls Kante nicht existiert
	 */
	public int getWeight(int from, int to);

	/**
	 * Getter fuer die Anzahl der Knoten
	 * @return Anzahl der Knoten im Graphen
	 */
	public int getNumberVertices();

}
