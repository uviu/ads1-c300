package ads;

// Der Konstruktor der Klasse darf keine formalen Parameter (Argumente) 
// enthalten

public class Inversionszahl_lschneid implements IInversionszahl {

  // Konstruktor ohne Argumente bitte belassen
  public Inversionszahl_lschneid() {

  }

  public int berechne(String[] feld) {
    int invz = 0;
    int[] indexA = count(feld, 0);
    int[] indexB = count(feld, 1);
    invz = sort(indexA, indexB, feld);
    return invz;
  }

  public static int sort(int[] indexA, int[] indexB, String[] feld) {
    int inversionsZahl = 0;
    for (int i = 1; i < indexA.length; i++) {
      int neuA = indexA[i];
      int neuB = indexB[i];
      String neuFeld = feld[i];
      int k = i;
      while (k > 1 && (indexA[k - 1] > neuA || (indexA[k - 1] == neuA && indexB[k - 1] > neuB))) {
        indexA[k] = indexA[k - 1];
        indexB[k] = indexB[k - 1];
        feld[k] = feld[k - 1];
        inversionsZahl++;
        k -= 1;
      }
      indexA[k] = neuA;
      indexB[k] = neuB;
      feld[k] = neuFeld;
    }
    return inversionsZahl;
  }

  public static int[] count(String[] feld, int aorb) {
    int[] indexA = new int[feld.length];
    int[] indexB = new int[feld.length];
    for (int i = 0; i < feld.length; i++) {
      indexA[i] = findAB(feld[i], 0);
      indexB[i] = findAB(feld[i], 1);
    }
    if (aorb == 0) {
      return indexA;
    }
    return indexB;
  }

  private static int findAB(String str, int aorb) {
    for (int i = 0; i < str.length(); i++) {
      switch (aorb) {
        case 0:
          if (str.charAt(i) == 'a') {
            return i;
          }
          break;
        case 1:
          if (str.charAt(i) == 'b') {
            return i;
          }
          break;
      }
    }
    return -1;
  }
}
