

import java.util.ArrayList;
import java.util.List;

public class Raflebæger {
	
	static List<Integer> resultatListe = new ArrayList<Integer>();
	public static List<Integer> rollCup(int n) {
		for (int i = 1; i <= n; i++) {
			int Resultat = (Terning.rulTerning());
			resultatListe.add(Resultat);
		}
		System.out.println(resultatListe);
		return resultatListe;
		}
	
	public static int getSum() {
		int sum = 0;
		for (int k = 0; k < resultatListe.size(); k++)
			sum += resultatListe.get(k);
		System.out.println(sum);
		return sum;
	}
	

}
