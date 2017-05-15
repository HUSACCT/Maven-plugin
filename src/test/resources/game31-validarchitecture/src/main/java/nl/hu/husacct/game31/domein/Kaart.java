package nl.hu.husacct.game31.domein;

public class Kaart
{
	private Deelname eigenaar;
	private String symbool;
	private String gifAdr;
	private String getal;
	private int waarde;
	private KaartSpel kSpel;
	private KaartStapel ks;


	public Kaart(String gifAdr, String symbool, String getal, int waarde, KaartSpel kSpel, KaartStapel ks)
	{
		//System.out.println(waarde);
		this.gifAdr = gifAdr;
		this.symbool = symbool;
		this.getal = getal;
		this.waarde = waarde;
		this.kSpel = kSpel;
		this.ks = ks;
	}

	/**
	@param dn
	 */
	public void setEigenaar(Deelname dn)
	{
		eigenaar = dn;
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
