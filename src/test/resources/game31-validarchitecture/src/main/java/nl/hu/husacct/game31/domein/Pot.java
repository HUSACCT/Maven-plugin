package nl.hu.husacct.game31.domein;

public class Pot {
	public int fiches;

	public Pot()
	{
		fiches = 0;
	}

	public void donatieFiche()
	{
		fiches++;
	}

	public int geefFiches() {
		return fiches;
	}
}