package CDIO2;

import java.util.ArrayList;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Spil {

	private String besked = null;
	private boolean winner = false; //Når spillet starter er der ingen vinder
	private boolean yourturn = true; //Styrer hvornår spillerens tur er færdig. Bliver altid false når en spiller har slået med ternngen, hvis ikke spilleren har slået 10
	private Raflebæger cup = new Raflebæger(2); //Laver et raflebæger med to 6-sidede terninger.
	private Spiller spiller1;
	private Spiller spiller2;
	public static void main (String[] args) {
		new Spil().spilSpil();	
	}

	private void spilSpil() {
		initializeGUI(); //initialiserer GUI
		GUI.showMessage(StandardBeskeder (0));
		//Opretter spillere, konti og raflebæger
		spiller1 = new Spiller(GUI.getUserString(StandardBeskeder (1)), 6, 1000 );
		String Spiller2Navn = GUI.getUserString(StandardBeskeder (3));
		while (Spiller2Navn.equals(spiller1.getNavn())) {
			GUI.showMessage(StandardBeskeder (2));
			Spiller2Navn = GUI.getUserString(StandardBeskeder (4));
		}

		spiller2 = new Spiller(Spiller2Navn, 6, 1000 ); //Laver en ny spiller og knytter den til den anden Konto. Viser en fejlmeddelelse hvis den har samme navn som spiller 1
		GUI.addPlayer(spiller1.getNavn(), spiller1.getKonto().getVærdi());
		GUI.addPlayer(spiller2.getNavn(), spiller2.getKonto().getVærdi()); //Opretter de to spillere i GUI'en




		//hele spillets loop
		while(!winner) {
			tur(spiller1);
			tur(spiller2);
		}
		slutSpil(spiller1, spiller2);
	}

	private void initializeGUI() {
		Field [] fields = new Field[40];
		// Navngiv felter der skal bruges
		for (int i = 0; i < Oversæt.file1().size(); i++) {
			fields[i] = new Street.Builder()
					.setTitle(hentFeltOverskrift(i)).setDescription(hentFeltBeskrivelse(i))
					.setSubText(hentFeltVærdi(i))
					.build();
		}
		// Lav tomme felter som ikke skal bruges
		for (int i = Oversæt.file1().size(); i < fields.length; i++) {
			fields[i] = new Empty.Builder().build();
		}

		GUI.create(fields);


	}

	private String hentFeltOverskrift(int i){

		ArrayList<String> lines1 = new ArrayList<String>();
		lines1 = Oversæt.file1();
		String[] li1 = new String[lines1.size()];
		li1 = lines1.toArray(li1);

		return li1[i];

	}

	private String hentFeltVærdi(int i){

		ArrayList<String> lines2 = new ArrayList<String>();
		lines2 = Oversæt.file2();
		String[] li2 = new String[lines2.size()];
		li2 = lines2.toArray(li2);
		return li2[i];
	}


	private String hentFeltBeskrivelse(int i){

		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file3();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);
		return li3[i];
	}

	private String StandardBeskeder(int i){

		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file4();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);
		return li3[i];
	}
	//Metode for en spillers tur
	private void tur(Spiller CurrentPlayer) {
		yourturn = true;
		while(yourturn == true && winner == false) {
			GUI.getUserButtonPressed(besked, CurrentPlayer.getNavn() + StandardBeskeder(5));
			cup.rulRaflebæger(); //Ruller de to terninger
			GUI.setDice(cup.getTerninger()[0].getAntalØjne(), cup.getTerninger()[1].getAntalØjne()); //Sætter terningerne på brættet
			CurrentPlayer.setPosition(cup.getSum() - 1); 
			GUI.removeAllCars(CurrentPlayer.getNavn()); //Fjerner spillerens bil fra pladen
			GUI.setCar(CurrentPlayer.getPosition(), CurrentPlayer.getNavn()); //Setter bilen på det rigtige felt

			//Finder ud af hvor mange point spilleren skal givet eller fratages.
			switch (CurrentPlayer.getPosition()) {
			case 1: CurrentPlayer.getKonto().tilføjVærdi(250);
			break;
			case 2: CurrentPlayer.getKonto().hævVærdi(100);
			break;
			case 3: CurrentPlayer.getKonto().tilføjVærdi(100);
			break;
			case 4: CurrentPlayer.getKonto().hævVærdi(20);
			break;
			case 5: CurrentPlayer.getKonto().tilføjVærdi(180);
			break;
			case 6: CurrentPlayer.getKonto().tilføjVærdi(0);
			break;
			case 7: CurrentPlayer.getKonto().hævVærdi(70);
			break;
			case 8: CurrentPlayer.getKonto().tilføjVærdi(60);
			break;
			case 9: CurrentPlayer.getKonto().hævVærdi(80);
			break;
			case 10: CurrentPlayer.getKonto().hævVærdi(50);
			break;
			case 11: CurrentPlayer.getKonto().tilføjVærdi(650);
			break;
			default: besked = StandardBeskeder (6);
			}

			besked = hentFeltBeskrivelse(CurrentPlayer.getPosition()-1); //Læser en besked fra en tekstfil
			GUI.setBalance(CurrentPlayer.getNavn(), CurrentPlayer.getKonto().getVærdi()); //Sætter spillerens balnce
			if (CurrentPlayer.getKonto().getVærdi() >= 3000) //finder ud af om spilleren har vundet
				winner = true;
			if (CurrentPlayer.getPosition() == 9) //Finder ud af om spilleren må slå igen
				yourturn = true;
			else yourturn = false;
		}

	}
	//Metode for at aflslutte spillet. Finder ud af hvilken spiller der har flest point og spytter en vinderbesked ud
	private void slutSpil(Spiller FørsteSpiller, Spiller AndenSpiller) {
		if (FørsteSpiller.getKonto().getVærdi() > AndenSpiller.getKonto().getVærdi())
			GUI.showMessage(FørsteSpiller.getNavn() +  StandardBeskeder(7));
		else GUI.showMessage(AndenSpiller.getNavn() + StandardBeskeder(7));
	}

}
