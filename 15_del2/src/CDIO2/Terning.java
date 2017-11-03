package CDIO2;

public class Terning {
		 
		static int antalØjne;
		
		public Terning(int øjne) {
			øjne = antalØjne;
		}
		
		public static int rulTerning() {
			antalØjne = (int)(Math.random()*6+1);
			return antalØjne;
		}
		
		public static int getAntalØjne() {
			return antalØjne;
		}
		
		public static void setAntalØjne(int nytAntalØjne) {
			antalØjne = nytAntalØjne;
	}
}