package CDIO2;

//Klasse for spillets spillere
public class Spiller {
	
	private String navn;
	int position;
	private Konto konto;
	
	public Konto getKonto() {
		return konto;
	}

	//Konstruktør. Laver en spiller med navn og placering og knytter en konto til den
	public Spiller(String N, int P, Konto Konto)
	{
		navn = N;
		position = P;
		this.konto = Konto;
	}
	
	public Spiller(String userString, int p, int i) {
		this.konto = new Konto(i);
		this.navn = userString;
		this.position = p;
	}

	public String getNavn()
	{
		return navn;
	}
	
	public void setNavn(String NytNavn)
	{
		navn = NytNavn;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int NyPosition)
	{
		position = NyPosition;
	}
}

