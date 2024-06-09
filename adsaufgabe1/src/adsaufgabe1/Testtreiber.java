package adsaufgabe1;

public class Testtreiber {
    public static void main (String[] args) {
	IInversionszahl invz = new Inversionszahl_lschneid();
	int inv;
	
	// Tesfall 1
	String[] feld1 = { "aaa", "bba", "aba", "aab" };
	int inv1 = 5; 
	inv = invz.berechne(feld1);
	if (inv == inv1)
	    System.out.println("Testfall 1 erfolgreich");
	else
	    System.out.println("Fehler bei der Bearbeitung von Testfall 1 ("+inv+" statt "+inv1+")");

	
	// Testfall 2
	String[] feld2 = { "aba", "baaza", "cccba", "abab", "bab", "baaaa", "bazbab" };
	int inv2 = 9;
	inv = invz.berechne(feld2);
	if (inv == inv2)
	    System.out.println("Testfall 2 erfolgreich");
	else
	    System.out.println("Fehler bei der Bearbeitung von Testfall 2 ("+inv+" statt "+inv2+")");
    }
}
