package CDIO2;

public class Terning {
		 
		private int antalØjne;
		
		public Terning(int øjne) {
			øjne = antalØjne;
		}
		
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