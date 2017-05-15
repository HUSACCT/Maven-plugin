package main.java.game31.domain.gamecontrol;

import java.awt.Frame;
import java.util.*;

import javax.swing.JOptionPane;

import main.java.game31.domain.carddeck.Kaart;
import main.java.game31.domain.carddeck.KaartStapel;
import main.java.game31.domain.players.PlayersService;
import main.java.game31.userinterface.MainFrame;
import main.java.game31.userinterface.ScoreOverzichtFrame;

public class Spel
{
	private Frame mf;
	private Vector<SpelRonde> 		spelRondes			= new Vector<SpelRonde>();
	private int	gewonnenSpeler;
	private TreeSet<Integer> spelerIds	= new TreeSet<Integer>();
	private TreeSet<Integer> deelnemendeSpelerIds	= new TreeSet<Integer>();
	private	KaartStapel	ks					= new KaartStapel("Eenendertigen");
	private	Tafel 		tafel				= new Tafel();

	public Spel(Vector<?> compSpeler, Vector<?> humanSpelerData, int fiches, Frame mf)
	{
		this.mf = mf;
		if (!humanSpelerData.isEmpty()) {
			for (Iterator<?> i = humanSpelerData.iterator(); i.hasNext();) {
				Vector<?> data = (Vector<?>) i.next();
				for (Iterator<?> j = data.iterator(); j.hasNext();) {
					spelerIds.add(PlayersService.getInstance().createHumanSpeler((String) j.next(), (Calendar) j.next(), fiches, tafel));
				}
			}
		}

		if (!compSpeler.isEmpty()) {
			for (Iterator<?> i = compSpeler.iterator(); i.hasNext();) {
				spelerIds.add(PlayersService.getInstance().createComputerSpeler((String) i.next(), fiches, tafel, ks, this));
			}
		}

		deelnemendeSpelerIds = spelerIds;
		SpelRonde sr = new SpelRonde(this, ks, tafel, spelerIds);
		sr.setSpeler(spelerIds.first());
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
		Vector<Kaart> tafel1 = tafel.getKaarten();
		Vector<Kaart> dn = spelronde.getActiveDeelname().getKaarten();
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
		TreeSet<Integer> overblijvendeSpelerIds	= new TreeSet<Integer>();
		for (int spelerId : deelnemendeSpelerIds) {
			int aantalFiches = PlayersService.getInstance().geefSpelerDetails(spelerId).geefFiches();
			if (aantalFiches > 0) {
				overblijvendeSpelerIds.add(spelerId);
			}
		}
		if(overblijvendeSpelerIds.size() == 1) {
			String winnaar = PlayersService.getInstance().geefSpelerDetails(overblijvendeSpelerIds.first()).geefNaam();
			JOptionPane.showMessageDialog(mf, "Speler " + winnaar + " heeft gewonnen!", "Einde Spel!", JOptionPane.WARNING_MESSAGE);
			MainFrame frame = (MainFrame) mf;
			frame.dispose();
			new MainFrame(1);
			new ScoreOverzichtFrame(spelRondes);
		}
		deelnemendeSpelerIds = overblijvendeSpelerIds;
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
		Vector<?> deelnemers = sp.geefDeelnames();
		// eindScore per deelname wordt geset
		for (Iterator<?> i = deelnemers.iterator(); i.hasNext();) {
			Deelname dn = (Deelname) i.next();
			dn.geefEindScore();
		}
		spelRondes.add(new SpelRonde(this, ks, tafel, deelnemendeSpelerIds));
		// winnende speler van afgelopen ronde wordt opgehaald
		int waarde = 0;
		int spelerId = 0;
		for (Iterator<?> i = deelnemers.iterator(); i.hasNext();) {			
			Deelname d1 = (Deelname)i.next();
			System.out.println(controleerWaarde(d1));
			if (controleerWaarde(d1) > waarde) {
				waarde = controleerWaarde(d1);
				spelerId = d1.getSpeler();
			}			
		}
		setGewonnenSpeler(spelerId);		
		getHuidigeSpelRonde().setSpeler(gewonnenSpeler);
	}

	private void setGewonnenSpeler(int s) {
	  this.gewonnenSpeler = s;
    }

    public Tafel getTafel() {
    	return tafel;
    }

    public SpelRonde getHuidigeSpelRonde() {
    	SpelRonde sp = (SpelRonde) spelRondes.lastElement();
    	return sp;
    }

    public Vector<?> getTotalScore(){
    	return new Vector<Object>();
    }

	public int controleerWaarde(Deelname dn)
	{
		Vector<?> v = dn.getKaarten();
		Iterator<?> i = v.iterator();
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