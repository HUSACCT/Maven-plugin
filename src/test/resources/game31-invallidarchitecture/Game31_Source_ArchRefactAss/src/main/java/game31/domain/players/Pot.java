package main.java.game31.domain.players;

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