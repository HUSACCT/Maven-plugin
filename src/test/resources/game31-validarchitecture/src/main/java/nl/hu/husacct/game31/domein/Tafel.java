package nl.hu.husacct.game31.domein;

import java.util.*;

public class Tafel
{
	private Vector kaarten;
	private Kaart selectedKaart;
	private int place;

	public Tafel()
	{
	}

	public void setKaarten(Vector kaarten)
	{
		this.kaarten = kaarten;
	}

	public void selecteerKaart(int index)
	{
		try {
			selectedKaart = (Kaart) kaarten.elementAt(index);
		}
		catch (NullPointerException e) { System.out.println("vector nog niet gevuld!"); }
	}

	public Kaart getSelected()
	{
		return selectedKaart;
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

	public Vector getKaarten()
	{
		return kaarten;
	}
	public void replaceAll(Vector kaarten)
	{
		this.kaarten = kaarten;
	}

}