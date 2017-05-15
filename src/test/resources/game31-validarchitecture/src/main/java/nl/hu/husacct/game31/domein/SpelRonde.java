package nl.hu.husacct.game31.domein;

import java.util.*;

public class SpelRonde
{
	private static int laatsteNr = 0;
	private int rondeNr;
	private Vector deelnemers = new Vector();
	private Vector totaalKaarten = new Vector();
	private int beurtenTeGaan = -1;
	private Tafel tafel;
	private Deelname activeDeelname;
	private Vector spelers;
	private Speler speler;
	private Spel spel;
	private KaartStapel ks;

	public SpelRonde(Spel spel, KaartStapel ks, Tafel tafel, Vector spelers)
	{
		rondeNr = laatsteNr++;
		this.spel = spel;
		this.ks = ks;
		this.tafel = tafel;
		this.spelers = spelers;
		totaalKaarten = ks.geefKaartenGeschud(1+ spelers.size());
		int counter = 0;
		for (Iterator i = spelers.iterator(); i.hasNext();) {
			activeDeelname = new Deelname((Speler) i.next());
			Vector persoonKaarten = new Vector();
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			persoonKaarten.add(totaalKaarten.elementAt(counter++));
			//activeDeelname.setKaarten(totaalKaarten);
			activeDeelname.setKaarten(persoonKaarten);
			deelnemers.add(activeDeelname);
		}
		Vector tafelKaarten = new Vector();
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafelKaarten.add(totaalKaarten.elementAt(counter++));
		tafel.setKaarten(tafelKaarten);
	}

	public void setSpeler(Speler s)
	{
		Deelname s1;
		for (Iterator i = deelnemers.iterator(); i.hasNext();) {
			s1 = (Deelname) i.next();
			if (s.equals(s1.getSpeler())) {
				activeDeelname = s1;
				activeDeelname.getSpeler().eersteKeerInRonde();
			}
		}
	}

	public int geefRondeNr()
	{
		return rondeNr;
	}

	public Vector geefDeelnames()
	{
		return deelnemers;
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
			for (Iterator i = deelnemers.iterator(); i.hasNext();) {
				d1 = (Deelname) i.next();
				if (activeDeelname.equals(d1)) {
					if (d1.equals(deelnemers.lastElement())) activeDeelname = (Deelname) deelnemers.firstElement();
					else activeDeelname = (Deelname) i.next();
					if(beurtenTeGaan != -1) beurtenTeGaan--;
					activeDeelname.getSpeler().aanDeBeurt();
				}
				
			}
		}
		else if (beurtenTeGaan == 0) {
			int waarde = 31;
			Speler s = null;
			for (Iterator i = deelnemers.iterator(); i.hasNext();) {
				Deelname dn = (Deelname) i.next();
				if (waarde > spel.controleerWaarde(dn)) {
					waarde = spel.controleerWaarde(dn);
					s = dn.getSpeler();
				}
			}
			s.dumpFiche();
			spel.volgendeRonde();
		}
	}

	public void setBeurtenTeGaan()
	{
		beurtenTeGaan = deelnemers.size() - 1;
	}
}