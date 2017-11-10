package CDIO2;

//Klasse for spillerens konto. En konto indeholder en integer
public class Konto {
	
	int værdi;
	
	public Konto(int V)
	{
		værdi = V;
	}
	
	public int getVærdi()
	{
		return værdi;
	}
	
	public void setVærdi(int nyVærdi)
	{
		værdi=nyVærdi;
	}
	//Tilføjer et antal point til en spillers konto
	public int tilføjVærdi(int indskud)
	{
		return værdi = værdi + indskud;
	}
	//Hæver et antal point fra en spillers konto. Sørger for at kontoen aldrig kommer under 0
	public int hævVærdi(int fradrag)
	{	
		værdi = værdi - fradrag;
		if (værdi < 0)
			værdi = 0;
		return værdi;
	}
}
