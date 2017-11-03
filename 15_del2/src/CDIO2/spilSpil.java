package CDIO2;

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
		fields[i] = new Street.Builder().setTitle(Felt.BoardController1(i)).setDescription(Felt.BoardController3(i)).setSubText(Felt.BoardController2(i)).build();
		}
		// Lav tomme felter som ikke skal bruges
		for (int i = Oversæt.file1().size(); i < fields.length; i++) {
		fields[i] = new Empty.Builder().build();
		}
		
		GUI.create(fields);

		//TODO send Fields to GUI
		
	}
}
