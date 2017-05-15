package nl.hu.husacct.game31.domein;

public abstract class Speler {
	String naam;
	int fices;
	Deelname deelname;
	Tafel tafel;
	Pot pot;

	public Speler(String naam, int fices, Tafel tafel, Pot pot)
	{
		this.naam = naam;
		this.fices = fices;
		this.tafel = tafel;
		this.pot = pot;
	}

	public String geefNaam()
	{
		return naam;
	}

	public void dumpFiche()
	{
		pot.donatieFiche();
		this.fices--;
	}

	public int geefFiches()
	{
		return fices;
	}

	public abstract void aanDeBeurt();
	public abstract void eersteKeerInRonde();


	public void setDeelname(Deelname dn) {
		this.deelname = dn;
	}
}
