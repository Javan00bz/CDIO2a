package CDIO2;

public class Spiller {
	
	String Navn;
	int Position;
	Konto Konto;
	
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

