package main.java.game31.domain.players;

public class SpelerDTO {
	protected int id = 0;
	protected String naam = "";
	protected int fiches = 0;
	protected boolean isHuman = true;
	
	public SpelerDTO(int id, String naam, int fiches, boolean isHuman)
	{
		this.id = id;
		this.naam = naam;
		this.fiches = fiches;
		this.isHuman = isHuman;
	}

	public int geefId() {
		return id;
	}
	
	public String geefNaam() {
		return naam;
	}

	public int geefFiches()
	{
		return fiches;
	}
	
	public boolean isHumanSpeler() {
		return isHuman;
	}

}
