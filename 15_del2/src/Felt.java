import java.util.ArrayList;

import desktop_resources.GUI;

public class Felt {

	public static void BoardController(){
		
		ArrayList<String> lines1 = new ArrayList<String>();
		lines1 = Oversæt.file1();
		String[] li1 = new String[lines1.size()];
		li1 = lines1.toArray(li1);

		ArrayList<String> lines2 = new ArrayList<String>();
		lines2 = Oversæt.file2();
		String[] li2 = new String[lines2.size()];
		li2 = lines2.toArray(li2);

		ArrayList<String> lines3 = new ArrayList<String>();
		lines3 = Oversæt.file3();
		String[] li3 = new String[lines3.size()];
		li3 = lines3.toArray(li3);

		
		for (int q = 1; q < li1.length; q++) {
			GUI.setTitleText(q, li1[q - 1]);
		}
		for (int q = li1.length; q <= 40; q++) {
			GUI.setTitleText(q, " ");
		}

		for (int q = 1; q < li2.length; q++) {
			GUI.setDescriptionText(q, li2[q - 1]);
		}
		for (int q = li2.length; q <= 40; q++) {
			GUI.setDescriptionText(q, " ");
		}

		for (int q = 1; q < li3.length; q++) {
			GUI.setSubText(q, li3[q]);
		}
		for (int q = li3.length; q <= 40; q++) {
			GUI.setDescriptionText(q, " ");
		}
	}
}

