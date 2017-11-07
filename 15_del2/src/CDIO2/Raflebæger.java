package CDIO2;

public class Raflebæger {
	private Terning[] terninger;

	public Raflebæger(int i) {
		terninger = new Terning[i];
		for (int j=0; j<i; j++) {
			terninger[j] = new Terning(6);
		}

	}

	public void rulRaflebæger() {
		for (int i = 0; i < terninger.length; i++) {
			terninger[i].rulTerning();
		}
	}

	
	
	public Terning[] getTerninger() {
		return terninger;
	}

	public void setTerninger(Terning[] terninger) {
		this.terninger = terninger;
	}

	public int getSum() {
		int sum=0;
		for (int i = 0; i < terninger.length; i++) {
			sum+=terninger[i].getAntalØjne();
		}
		return sum;
	}


}
