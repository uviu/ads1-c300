package adsaufgabe1;

public class Inversionszahl_lschneid implements IInversionszahl {

	public Inversionszahl_lschneid() {

	}

	public int berechne(String[] feld) {
		int invz = 0;
		for (int i = 1; i < feld.length; i++) {
			for (int j = i; j > 0 && greater(feld[j - 1], feld[j]); j--) {
				swap(feld, j, j - 1);
				invz++;
			}
		}
		return invz;
	}

	private void swap(String[] feld, int a, int b) {
		String newStr = feld[a];
		feld[a] = feld[b];
		feld[b] = newStr;
	}

	private boolean greater(String str1, String str2) {
		int indexA1 = str1.indexOf('a');
		int indexA2 = str2.indexOf('a');
		int indexB1 = str1.lastIndexOf('b');
		int indexB2 = str2.lastIndexOf('b');

		if (indexA1 != -1 && (indexA1 < indexA2 || indexA2 == -1)) {
			return false;
		}
		if (indexA2 != -1 && (indexA1 > indexA2 || indexA1 == -1)) {
			return true;
		}
		if (indexB2 != -1 && (str1.length() - indexB1 > str2.length() - indexB2 || indexB1 == -1)) {
			return true;
		}
		return false;
	}
}