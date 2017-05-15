package main.java.game31.domain.gamecontrol;

import java.util.*;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.players.PlayersService;
import main.java.game31.domain.players.Speler;

public class Deelname
{
	private int spelerId;
	private Vector<Kaart> kaarten;
	private int eindScore;	
	private int place;
	private Kaart selectedKaart;

	public Deelname(int speler)
	{
		this.spelerId = speler;
		Speler.geefSpeler(spelerId).setDeelname(this);
	}

	public void setKaarten(Vector<Kaart> kaarten)
	{
		this.kaarten = kaarten;
	}

	public void eersteKeerInRonde() {
		Speler.geefSpeler(spelerId).eersteKeerInRonde();
	}
	
	public void aanDeBeurt() {
		Speler.geefSpeler(spelerId).aanDeBeurt();
	}
	
	public int geefEindScore()
	{
		eindScore = PlayersService.getInstance().geefSpelerDetails(spelerId).geefFiches();
		return eindScore;
	}

	public void replaceFor(Kaart k1, Kaart k2)
	{
		for (Iterator<Kaart> i = kaarten.iterator(); i.hasNext();) {
			Kaart k = (Kaart) i.next();
			if (k.equals(k1)) {
				place = kaarten.indexOf(k);
				kaarten.removeElementAt(place);
				kaarten.insertElementAt(k2, place);
				break;
			}
		}
	}

	public Vector<Kaart> getKaarten() {	
		if (kaarten == null) {
			return new Vector<Kaart>();
		} else {
			return kaarten;
		}
	}

	public int getSpeler()
	{
		return spelerId;
	}

	public void dumpFiche()
	{
		Speler.geefSpeler(spelerId).dumpFiche();
	}

	public Kaart getSelected()
	{
		return selectedKaart;
	}

	public void selecteerKaart(int index)
	{
		try {
			selectedKaart = (Kaart) kaarten.elementAt(index);
		}
		catch (NullPointerException e) { System.out.println("vector nog niet gevuld!"); }
	}

	public void replaceAll(Vector<Kaart> kaarten)
	{
		this.kaarten = kaarten;
	}
	
	public int getScore()
	{
		return eindScore;
	}
}
