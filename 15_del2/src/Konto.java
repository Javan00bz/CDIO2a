

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
		return værdi = værdi - fradrag;
	}
}
