package main.java.game31.domain.gamecontrol;

import java.util.*;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.carddeck.KaartStapel;

public class SpelRonde
{
	private static int laatsteNr = 0;
	private int rondeNr;
	private Vector<Deelname> deelnames = new Vector<>();
	private Vector<Kaart> totaalKaarten = new Vector<>();
	private int beurtenTeGaan = -1;
	private Deelname activeDeelname;
	private Spel spel;
	public SpelRonde(Spel spel, KaartStapel ks, Tafel tafel, TreeSet<Integer> deelnemendeSpelerIds)
	{
		rondeNr = laatsteNr++;
		this.spel = spel;
		totaalKaarten = ks.geefKaartenGeschud(1+ deelnemendeSpelerIds.size());
		int counter = 0;
		for (int spelerId : deelnemendeSpelerIds) {
			activeDeelname = new Deelname(spelerId);
			Vector<Kaart> persoonKaarten = new Vector<>();
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			//activeDeelname.setKaarten(totaalKaarten);
			activeDeelname.setKaarten(persoonKaarten);
			deelnames.add(activeDeelname);
		}
		Vector<Kaart> tafelKaarten = new Vector<>();
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafel.setKaarten(tafelKaarten);
	}

	public void setSpeler(int spelerId)
	{
		Deelname s1;
		for (Iterator<Deelname> i = deelnames.iterator(); i.hasNext();) {
			s1 = (Deelname) i.next();
			if (spelerId == s1.getSpeler()) {
				activeDeelname = s1;
				activeDeelname.eersteKeerInRonde();
			}
		}
	}

	public int geefRondeNr()
	{
		return rondeNr;
	}

	public Vector<Deelname> geefDeelnames()
	{
		return deelnames;
	}

	public Deelname getActiveDeelname()
	{
		return activeDeelname;
	}

	public void volgendeSpeler()
	{
		System.out.println("" + beurtenTeGaan);
		if (beurtenTeGaan != 0) {
			Deelname d1;
			for (Iterator<Deelname> i = deelnames.iterator(); i.hasNext();) {
				d1 = (Deelname) i.next();
				if (activeDeelname.equals(d1)) {
					if (d1.equals(deelnames.lastElement())) activeDeelname = (Deelname) deelnames.firstElement();
					else activeDeelname = (Deelname) i.next();
					if(beurtenTeGaan != -1) beurtenTeGaan--;
					activeDeelname.aanDeBeurt();
				}
				
			}
		}
		else if (beurtenTeGaan == 0) {
			int waarde = 31;
			Deelname selected = null;
			for (Iterator<Deelname> i = deelnames.iterator(); i.hasNext();) {
				Deelname dn = (Deelname) i.next();
				if (waarde > spel.controleerWaarde(dn)) {
					waarde = spel.controleerWaarde(dn);
					selected = dn;
				}
			}
			selected.dumpFiche();
			spel.volgendeRonde();
		}
	}

	public void setBeurtenTeGaan()
	{
		beurtenTeGaan = deelnames.size() - 1;
	}
}