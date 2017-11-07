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
		GUI.showMessage(StandardBeskeder (0));
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
		Raflebæger cup = new Raflebæger(2);
		String besked = null;
		boolean winner = false;
		boolean yourturn = true;
	
		while(!winner) {
			
			yourturn = true;
			while(yourturn == true && winner == false) {
				GUI.getUserButtonPressed(besked, Spiller1.getNavn() + StandardBeskeder(5));
				cup.rulRaflebæger();
				GUI.setDice(cup.getTerninger()[0].getAntalØjne(), cup.getTerninger()[1].getAntalØjne());
				Spiller1.setPosition(cup.getSum() - 1);
				GUI.removeAllCars(Spiller1.getNavn());
				GUI.setCar(Spiller1.getPosition(), Spiller1.getNavn());

				switch (Spiller1.getPosition()) {
				case 1: Konto1.tilføjVærdi(250);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 2: Konto1.hævVærdi(100);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 3: Konto1.tilføjVærdi(100);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 4: Konto1.hævVærdi(20);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 5: Konto1.tilføjVærdi(180);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 6: Konto1.tilføjVærdi(0);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 7: Konto1.hævVærdi(70);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 8: Konto1.tilføjVærdi(60);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 9: Konto1.hævVærdi(80);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 10: Konto1.hævVærdi(50);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				case 11: Konto1.tilføjVærdi(650);
				besked = hentFeltBeskrivelse(Spiller1.getPosition()-1);
				break;
				default: besked = StandardBeskeder (6);
				}
				
					
				
				GUI.setBalance(Spiller1.getNavn(), Konto1.getVærdi());
				if (Konto1.getVærdi() >= 3000)
					winner = true;
				if (Spiller1.getPosition() == 9)
					yourturn = true;
				else yourturn = false;
			}
			yourturn = true;
			while(yourturn == true && winner == false ) {
				GUI.getUserButtonPressed(besked, Spiller2.getNavn() + StandardBeskeder(5));
				cup.rulRaflebæger();
				GUI.setDice(cup.getTerninger()[0].getAntalØjne(), cup.getTerninger()[1].getAntalØjne());
				Spiller2.setPosition(cup.getSum() - 1);
				GUI.removeAllCars(Spiller2.getNavn());
				GUI.setCar(Spiller2.getPosition(), Spiller2.getNavn());

				switch (Spiller2.getPosition()) {
				case 1: Konto2.tilføjVærdi(250);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 2: Konto2.hævVærdi(100);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 3: Konto2.tilføjVærdi(100);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 4: Konto2.hævVærdi(20);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 5: Konto2.tilføjVærdi(180);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 6: Konto2.tilføjVærdi(0);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 7: Konto2.hævVærdi(70);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 8: Konto2.tilføjVærdi(60);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 9: Konto2.hævVærdi(80);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 10: Konto2.hævVærdi(50);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				case 11: Konto2.tilføjVærdi(650);
				besked = hentFeltBeskrivelse(Spiller2.getPosition()-1);
				break;
				default: besked = StandardBeskeder (6);
				}

				GUI.setBalance(Spiller2.getNavn(), Konto2.getVærdi());
				
				if (Konto2.getVærdi() >= 3000)
					winner = true;
				if (Spiller2.getPosition() == 9)
					yourturn = true;
				else yourturn = false;

			}
		}
		if (Konto1.getVærdi() > Konto2.getVærdi())
			GUI.showMessage(Spiller1.getNavn() +  StandardBeskeder(7));
		else GUI.showMessage(Spiller2.getNavn() + StandardBeskeder(7));
		}

		private void initializeGUI() {
			// TODO Create Fields
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

			//TODO send Fields to GUI

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
		
	}
