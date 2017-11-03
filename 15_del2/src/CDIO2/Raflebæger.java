package CDIO2;

public class Raflebæger {
	private Terning[] terninger;

	public Raflebæger(int i) {
		terninger = new Terning[i];
		for (int j=0; j<i; j++) {
			terninger[j] = new Terning(6);
		}

	}

	public void rollCup() {
		for (int i = 0; i < terninger.length; i++) {
			terninger[i].rulTerning();
		}
	}

	public int getSum() {
		int sum=0;
		for (int i = 0; i < terninger.length; i++) {
			sum+=terninger[i].getAntalØjne();
		}
		return sum;
	}


}
