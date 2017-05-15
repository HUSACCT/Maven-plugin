package main.java.game31.domain.carddeck;

public class Kaart
{
	private String symbool;
	private String gifAdr;
	private String getal;
	private int waarde;

	public Kaart(String gifAdr, String symbool, String getal, int waarde, KaartSpel kSpel, KaartStapel ks)
	{
		this.gifAdr = gifAdr;
		this.symbool = symbool;
		this.getal = getal;
		this.waarde = waarde;
	}

	/**
	@return java.lang.String
	 */
	public String geefSymbool()
	{
		return symbool;
	}

	/**
	@return int
	 */
	public int geefWaarde()
	{
		return waarde;
	}

	/**
	@return java.lang.String
	 */
	public String geefGetal()
	{
		return getal;
	}

	/**
	@return java.lang.String
	 */
	public String geefGifAdr()
	{
		return gifAdr;
	}
}
