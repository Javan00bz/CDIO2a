package CDIO2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Oversæt {
	
	public static ArrayList<String> file1() {

		ArrayList<String> lines1 = new ArrayList<String>();

		try {
			BufferedReader reader1 = new BufferedReader(new FileReader("file1.txt"));
			String line = "\r\n";
			while ((line = reader1.readLine()) != null) {
				lines1.add(line);
			}
			System.out.println(lines1);
			reader1.close();
		} catch (IOException e) {
			System.out.println("error");
		} finally {
			System.out.println("file1 read");
		}
		return lines1;
	}

	public static ArrayList<String> file2() {

		ArrayList<String> lines1 = new ArrayList<String>();

		try {
			BufferedReader reader1 = new BufferedReader(new FileReader("file2.txt"));
			String line = "\r\n";
			while ((line = reader1.readLine()) != null) {
				lines1.add(line);
			}
			System.out.println(lines1);
			reader1.close();
		} catch (IOException e) {
			System.out.println("error");
		} finally {
			System.out.println("file2 read");
		}
		return lines1;
	}

	public static ArrayList<String> file3() {

		ArrayList<String> lines1 = new ArrayList<String>();
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader("file3.txt"));
			String line = "\r\n";
			while ((line = reader1.readLine()) != null) {
				lines1.add(line);
			}
			System.out.println(lines1);
			reader1.close();
		} catch (IOException e) {
			System.out.println("error");
		} finally {
			System.out.println("file3 read");
		}
		return lines1;
	}

	public static ArrayList<String> file4() {

		ArrayList<String> lines1 = new ArrayList<String>();
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader("file4.txt"));
			String line = "\r\n";
			while ((line = reader1.readLine()) != null) {
				lines1.add(line);
			}
			System.out.println(lines1);
			reader1.close();
		} catch (IOException e) {
			System.out.println("error");
		} finally {
			System.out.println("file4 read");
		}
		return lines1;
	}
}
