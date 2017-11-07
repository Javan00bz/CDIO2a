package CDIO2;

import java.util.ArrayList;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Spil {
	
	public static void main (String[] args) {
		new Spil().spilSpil();	
	}

	private void spilSpil() {
		initializeGUI();
		GUI.showMessage("velkommen");
		boolean winner = false;
		
		while(!winner) {
			Konto Konto1 = new Konto(1000);
			Konto Konto2 = new Konto(1000);
			String player1Name = GUI.getUserString("Spiller 1, indtast dit navn");
			String player2Name = GUI.getUserString("Spiller 2, indtast dit navn");
			Spiller Spiller1 = new Spiller(player1Name, 6, Konto1 );
			Spiller Spiller2 = new Spiller(player2Name, 6, Konto2 );
			
			GUI.addPlayer(Spiller1.getNavn(), Konto1.getVærdi());
			GUI.setCar(Spiller2.getPosition(), Spiller1.getNavn());
			GUI.setCar(Spiller1.getPosition(), Spiller1.getNavn());
			GUI.addPlayer(Spiller2.getNavn(), Konto2.getVærdi());			
		}
		
	}

	private void initializeGUI() {
		// TODO Create Fields
		Field [] fields = new Field[40];
		// Navngiv felter der skal bruges
		for (int i = 0; i < Oversæt.file1().size(); i++) {
		fields[i] = new Street.Builder()
				.setTitle(hentFeltOverskrift(i)).setDescription(hentFeltVærdi(i))
				.setSubText(hentFeltBeskrivelse(i))
				.build();
		}
		// Lav tomme felter som ikke skal bruges
		for (int i = Oversæt.file1().size(); i < fields.length; i++) {
		fields[i] = new Empty.Builder().build();
		}
		
		GUI.create(fields);

		//TODO send Fields to GUI
		
	}

	public static String hentFeltOverskrift(int i){
		
		ArrayList<String> lines1 = new ArrayList<String>();
		lines1 = Oversæt.file1();
		String[] li1 = new String[lines1.size()];
		li1 = lines1.toArray(li1);
		
		return li1[i];
		
	}

		public static String hentFeltBeskrivelse(int i){

		ArrayList<String> lines2 = new ArrayList<String>();
		lines2 = Oversæt.file2();
		String[] li2 = new String[lines2.size()];
		li2 = lines2.toArray(li2);
		return li2[i];
		}

		
		public static String hentFeltVærdi(int i){
		
		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file3();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);
		return li3[i];
		}
}
