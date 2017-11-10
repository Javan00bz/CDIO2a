package CDIO2;

//Klasse for en terning
public class Terning {
		 
		private int antalØjne;
		
		//Opretter en terning med et antal øjne
		public Terning(int øjne) {
			øjne = antalØjne;
		}
		//Ruller terningen
		public int rulTerning() {
			antalØjne = (int)(Math.random()*6+1);
			return antalØjne;
		}

		public int getAntalØjne() {
			return antalØjne;
		}
		
		public void setAntalØjne(int nytAntalØjne) {
			antalØjne = nytAntalØjne;
	}
}