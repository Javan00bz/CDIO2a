package CDIO2;


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
	
	public int tilføjVærdi(int indskud)
	{
		return værdi = værdi + indskud;
	}
	
	public int hævVærdi(int fradrag)
	{	
		værdi = værdi - fradrag;
		if (værdi < 0)
			værdi = 0;
		return værdi;
	}
}
