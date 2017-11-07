package CDIO2;

import java.util.ArrayList;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class spilSpil {
	
	public static void main (String[] args) {
		new spilSpil().spil();		
	}

	private void spil() {
		initializeGUI();
		GUI.showMessage("velkommen");
		boolean winner = false;
		
		while(!winner) {
			//TODO gameLoop;
			
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
