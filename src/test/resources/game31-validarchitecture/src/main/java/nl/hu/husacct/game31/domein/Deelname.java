package nl.hu.husacct.game31.domein;

import java.util.*;

public class Deelname
{
	private Speler speler;
	private Vector kaarten;
	private int eindScore;	
	private int place;
	private Kaart selectedKaart;

	public Deelname(Speler speler)
	{
		this.speler = speler;
		this.speler.setDeelname(this);
	}

	public void setKaarten(Vector kaarten)
	{
		this.kaarten = kaarten;
	}

	public int geefEindScore()
	{
		eindScore = speler.geefFiches();
		return eindScore;
	}

	public void replaceFor(Kaart k1, Kaart k2)
	{
		for (Iterator i = kaarten.iterator(); i.hasNext();) {
			Kaart k = (Kaart) i.next();
			if (k.equals(k1)) {
				place = kaarten.indexOf(k);
				kaarten.removeElementAt(place);
				kaarten.insertElementAt(k2, place);
				break;
			}
		}
	}

	public Vector getKaarten() {	
		if (kaarten == null) {
			return new Vector();
		} else {
			return kaarten;
		}
	}

	public Speler getSpeler()
	{
		return speler;
	}

	public void dumpFiche()
	{
		speler.dumpFiche();
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

	public void replaceAll(Vector kaarten)
	{
		this.kaarten = kaarten;
	}
	
	public int getScore()
	{
		return eindScore;
	}
}
