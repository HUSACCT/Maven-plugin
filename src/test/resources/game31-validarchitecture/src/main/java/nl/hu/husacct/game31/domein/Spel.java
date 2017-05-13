package nl.hu.husacct.game31.domein;

import java.awt.Frame;
import java.util.*;

import javax.swing.JOptionPane;

import nl.hu.husacct.game31.userinterface.MainFrame;
import nl.hu.husacct.game31.userinterface.ScoreOverzichtFrame;

public class Spel
{
	private Frame 	mf;
	private Vector 		spelRondes			= new Vector();
	private int 		beginFiches;
	private Speler		gewonnenSpeler;
	private Vector 		spelers				= new Vector();
	private Vector		deelnemendeSpelers	= new Vector();
	private	KaartStapel	ks					= new KaartStapel("Eenendertigen");
	private	Tafel 		tafel				= new Tafel();
	private Pot 		pot					= new Pot();


	public Spel(Vector compSpeler, Vector humanSpelerData, int fiches, Frame mf)
	{
		this.mf = mf;
		beginFiches = fiches;
		if (!humanSpelerData.isEmpty()) {
			for (Iterator i = humanSpelerData.iterator(); i.hasNext();) {
				Vector data = (Vector) i.next();
				for (Iterator j = data.iterator(); j.hasNext();) {
					spelers.add(new HumanSpeler((String) j.next(), (Calendar) j.next(), fiches, pot, tafel));
				}
			}
		}

		if (!compSpeler.isEmpty()) {
			for (Iterator i = compSpeler.iterator(); i.hasNext();) {
				spelers.add(new ComputerSpeler((String) i.next(), fiches, tafel, pot, ks, this));
			}
		}

		deelnemendeSpelers = spelers;
		SpelRonde sr = new SpelRonde(this, ks, tafel, spelers);
		sr.setSpeler((Speler) spelers.firstElement());
		spelRondes.add(sr);
	}

	public void ruil1Kaart(Kaart k1, Kaart k2)
	{
		SpelRonde spelronde = (SpelRonde) spelRondes.lastElement();
		spelronde.getActiveDeelname().replaceFor(k1, k2);
		tafel.replaceFor(k2, k1);
		if (controleerWaarde(getHuidigeSpelRonde().getActiveDeelname()) == 31) {
			JOptionPane.showMessageDialog(mf,"U heef 31, een nieuwe SpelRonde word gestart.", "Error", JOptionPane.ERROR_MESSAGE);
			volgendeRonde();
		}
		else getHuidigeSpelRonde().volgendeSpeler();
		updateUI();
	}
	
	public void updateUI() {
		if(mf instanceof MainFrame) {
			MainFrame frame = (MainFrame) mf;
			frame.updateUI();
		}
	}

	public void ruil3Kaart()
	{
		SpelRonde spelronde = (SpelRonde) spelRondes.lastElement();
		Vector tafel1 = tafel.getKaarten();
		Vector dn = spelronde.getActiveDeelname().getKaarten();
		spelronde.getActiveDeelname().replaceAll(tafel1);
		tafel.replaceAll(dn);
		if (controleerWaarde(getHuidigeSpelRonde().getActiveDeelname()) == 31) {
			JOptionPane.showMessageDialog(mf,"U heef 31, een nieuwe SpelRonde word gestart.", "Error", JOptionPane.ERROR_MESSAGE);
			volgendeRonde();
		}
		getHuidigeSpelRonde().volgendeSpeler();
		updateUI();
	}

	private void controleerPunten()
	{
		Vector v = new Vector();
		for (Iterator i = deelnemendeSpelers.iterator(); i.hasNext();) {
			Speler s2 = (Speler) i.next();
			if (s2.geefFiches() > 0) {
				v.add(s2);
			}
		}
		if(v.size() == 1) {
			Speler winnaar = (Speler)v.get(0);
			JOptionPane.showMessageDialog(mf, "Speler " + winnaar.geefNaam() + " heeft gewonnen!", "Einde Spel!", JOptionPane.WARNING_MESSAGE);
			MainFrame frame = (MainFrame) mf;
			frame.dispose();
			new MainFrame(1);
			new ScoreOverzichtFrame(spelRondes);
		}
		deelnemendeSpelers = v;
	}

	public void volgendeRonde()
	{
		nieuweSpelRonde();
		SpelRonde sr = (SpelRonde) spelRondes.lastElement();
		sr.setSpeler(gewonnenSpeler);
		JOptionPane.showMessageDialog(mf, "Nieuwe Ronde!", "Melding", JOptionPane.INFORMATION_MESSAGE);
		if(mf instanceof MainFrame) {
			MainFrame frame = (MainFrame) mf;
			frame.newRound();
		}
	}

	public void pas() {
		SpelRonde sp = (SpelRonde) spelRondes.lastElement();
		sp.setBeurtenTeGaan();
		sp.volgendeSpeler();
		updateUI();
	}

	public void doorSchuiven() {
		SpelRonde sp = getHuidigeSpelRonde();
		if (controleerWaarde(getHuidigeSpelRonde().getActiveDeelname()) == 31) {
			JOptionPane.showMessageDialog(mf,"U heef 31, een nieuwe SpelRonde word gestart.", "Error", JOptionPane.ERROR_MESSAGE);
			volgendeRonde();
		}
		else sp.volgendeSpeler();
		updateUI();
	}

	private void nieuweSpelRonde() {
		controleerPunten();
		SpelRonde sp = (SpelRonde)spelRondes.lastElement();
		Vector deelnemers = sp.geefDeelnames();
		// eindScore per deelname wordt geset
		for (Iterator i = deelnemers.iterator(); i.hasNext();) {
			Deelname dn = (Deelname) i.next();
			dn.geefEindScore();
		}
		spelRondes.add(new SpelRonde(this, ks, tafel, deelnemendeSpelers));
		// winnende speler van afgelopen ronde wordt opgehaald
		int waarde = 0;
		Speler s = null;
		for (Iterator i = deelnemers.iterator(); i.hasNext();) {			
			Deelname d1 = (Deelname)i.next();
			System.out.println(controleerWaarde(d1));
			if (controleerWaarde(d1) > waarde) {
				waarde = controleerWaarde(d1);
				s = d1.getSpeler();
			}			
		}
		setGewonnenSpeler(s);		
		getHuidigeSpelRonde().setSpeler(gewonnenSpeler);
	}

	private void setGewonnenSpeler(Speler s) {
	  this.gewonnenSpeler = s;
    }

    public Tafel getTafel() {
    	return tafel;
    }

    public SpelRonde getHuidigeSpelRonde() {
    	SpelRonde sp = (SpelRonde) spelRondes.lastElement();
    	return sp;
    }

    public Vector getTotalScore(){
    	return new Vector();
    }

	public int controleerWaarde(Deelname dn)
	{
		Vector v = dn.getKaarten();
		Iterator i = v.iterator();
		Kaart k1 = (Kaart) i.next();
		Kaart k2 = (Kaart) i.next();
		Kaart k3 = (Kaart) i.next();
		int waarde = 0;
		if ((k1.geefSymbool().equals(k2.geefSymbool())) && (k1.geefSymbool().equals(k3.geefSymbool()))) {
			waarde = (k1.geefWaarde() + k2.geefWaarde() + k3.geefWaarde());
		}
		else if( (k1.geefSymbool().equals(k2.geefSymbool())) && !(k1.geefSymbool().equals(k3.geefSymbool()))) {
			waarde = (k1.geefWaarde() + (k2.geefWaarde()));
		}
		else if((k1.geefSymbool().equals(k3.geefSymbool())) && !(k1.geefSymbool().equals(k2.geefSymbool()))) {
			waarde = k1.geefWaarde() + k3.geefWaarde();
		}
		else if((k2.geefSymbool().equals(k3.geefSymbool())) && !(k2.geefSymbool().equals(k1.geefSymbool()))) {
			waarde = k2.geefWaarde() + k3.geefWaarde();
		}
		else {
			waarde = k1.geefWaarde();
			if (k2.geefWaarde() > waarde) waarde = k2.geefWaarde();
			if (k3.geefWaarde() > waarde) waarde = k3.geefWaarde();
		}
		return waarde;
	}
}