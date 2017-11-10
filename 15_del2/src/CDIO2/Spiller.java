package CDIO2;

//Klasse for spillets spillere
public class Spiller {
	
	String Navn;
	int Position;
	Konto Konto;
	
	//Konstruktør. Laver en spiller med navn og placering og knytter en konto til den
	public Spiller(String N, int P, Konto Konto)
	{
		Navn = N;
		Position = P;
		this.Konto = Konto;
	}
	
	public String getNavn()
	{
		return Navn;
	}
	
	public void setNavn(String NytNavn)
	{
		Navn = NytNavn;
	}
	
	public int getPosition()
	{
		return Position;
	}
	
	public void setPosition(int NyPosition)
	{
		Position = NyPosition;
	}
}

