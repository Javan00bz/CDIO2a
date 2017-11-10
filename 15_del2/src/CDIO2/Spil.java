package CDIO2;

import java.util.ArrayList;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Spil {

	String besked = null;
	boolean winner = false;
	boolean yourturn = true;
	Raflebæger cup = new Raflebæger(2);
	public static void main (String[] args) {
		new Spil().spilSpil();	
	}

	private void spilSpil() {
		initializeGUI(); //initialiserer GUI
		GUI.showMessage(StandardBeskeder (0));
		//Opretter spillere, konti og raflebæger
		Konto Konto1 = new Konto(1000);
		Konto Konto2 = new Konto(1000);
		Spiller Spiller1 = new Spiller(GUI.getUserString(StandardBeskeder (1)), 6, Konto1 );
		String Spiller2Navn = GUI.getUserString(StandardBeskeder (3));
		while (Spiller2Navn.equals(Spiller1.getNavn())) {
			GUI.showMessage(StandardBeskeder (2));
			Spiller2Navn = GUI.getUserString(StandardBeskeder (4));
		}

		Spiller Spiller2 = new Spiller(Spiller2Navn, 6, Konto2 );
		GUI.addPlayer(Spiller1.getNavn(), Konto1.getVærdi());
		GUI.addPlayer(Spiller2.getNavn(), Konto2.getVærdi());




		//hele spillets loop
		while(!winner) {
			tur(Spiller1);
			tur(Spiller2);
		}
		endGame(Spiller1, Spiller2);
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

	public static String hentFeltOverskrift(int i){

		ArrayList<String> lines1 = new ArrayList<String>();
		lines1 = Oversæt.file1();
		String[] li1 = new String[lines1.size()];
		li1 = lines1.toArray(li1);

		return li1[i];

	}

	public static String hentFeltVærdi(int i){

		ArrayList<String> lines2 = new ArrayList<String>();
		lines2 = Oversæt.file2();
		String[] li2 = new String[lines2.size()];
		li2 = lines2.toArray(li2);
		return li2[i];
	}


	public static String hentFeltBeskrivelse(int i){

		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file3();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);
		return li3[i];
	}

	public static String StandardBeskeder(int i){

		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file4();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);
		return li3[i];
	}
	public void tur(Spiller CurrentPlayer) {
		yourturn = true;
		while(yourturn == true && winner == false) {
			GUI.getUserButtonPressed(besked, CurrentPlayer.getNavn() + StandardBeskeder(5));
			cup.rulRaflebæger();
			GUI.setDice(cup.getTerninger()[0].getAntalØjne(), cup.getTerninger()[1].getAntalØjne());
			CurrentPlayer.setPosition(cup.getSum() - 1);
			GUI.removeAllCars(CurrentPlayer.getNavn());
			GUI.setCar(CurrentPlayer.getPosition(), CurrentPlayer.getNavn());

			//Finder ud af hvor mange point spilleren skal givet eller fratages.
			switch (CurrentPlayer.getPosition()) {
			case 1: CurrentPlayer.Konto.tilføjVærdi(250);
			break;
			case 2: CurrentPlayer.Konto.hævVærdi(100);
			break;
			case 3: CurrentPlayer.Konto.tilføjVærdi(100);
			break;
			case 4: CurrentPlayer.Konto.hævVærdi(20);
			break;
			case 5: CurrentPlayer.Konto.tilføjVærdi(180);
			break;
			case 6: CurrentPlayer.Konto.tilføjVærdi(0);
			break;
			case 7: CurrentPlayer.Konto.hævVærdi(70);
			break;
			case 8: CurrentPlayer.Konto.tilføjVærdi(60);
			break;
			case 9: CurrentPlayer.Konto.hævVærdi(80);
			break;
			case 10: CurrentPlayer.Konto.hævVærdi(50);
			break;
			case 11: CurrentPlayer.Konto.tilføjVærdi(650);

			break;
			default: besked = StandardBeskeder (6);
			}


			besked = hentFeltBeskrivelse(CurrentPlayer.getPosition()-1);
			GUI.setBalance(CurrentPlayer.getNavn(), CurrentPlayer.Konto.getVærdi());
			if (CurrentPlayer.Konto.getVærdi() >= 3000)
				winner = true;
			if (CurrentPlayer.getPosition() == 9)
				yourturn = true;
			else yourturn = false;
		}
	}
	public void endGame(Spiller FørsteSpiller, Spiller AndenSpiller) {
		if (FørsteSpiller.Konto.getVærdi() > AndenSpiller.Konto.getVærdi())
			GUI.showMessage(FørsteSpiller.getNavn() +  StandardBeskeder(7));
		else GUI.showMessage(AndenSpiller.getNavn() + StandardBeskeder(7));
	}

}
