package main.java.game31.domain.players;

import java.util.Calendar;

import main.java.game31.domain.carddeck.KaartStapel;
import main.java.game31.domain.gamecontrol.Spel;
import main.java.game31.domain.gamecontrol.Tafel;

public class PlayersService {
	
	private static PlayersService instance;
	
	private PlayersService() {
	}
	
	public static PlayersService getInstance() {
		if (PlayersService.instance == null) {
			instance = new PlayersService();
		}
		return instance;
	}

	public int createHumanSpeler(String naam, Calendar geboorteDatum, int fiches, Tafel tafel) {
		Speler human = new HumanSpeler(naam, geboorteDatum, fiches, tafel);
		int spelerId = human.getId();
		return spelerId;
	}

	public int createComputerSpeler(String naam, int fiches, Tafel tafel, KaartStapel ks, Spel spel) {
		Speler computer = new ComputerSpeler(naam, fiches, tafel, ks, spel);
		int spelerId = computer.getId();
		return spelerId;
	}
	
	public void dumpFiche(int spelerId) {
		Speler speler = Speler.geefSpeler(spelerId);
		if (speler != null) {
			speler.dumpFiche();
		}
	}
	
	public SpelerDTO geefSpelerDetails(int spelerId) {
		SpelerDTO spelerDTO;
		Speler speler = Speler.geefSpeler(spelerId);
		if (speler != null) {
			spelerDTO = speler.geefDetails();
		} else {
			spelerDTO =  new SpelerDTO(spelerId, "", 0, true);
		}
		return spelerDTO;
	}
}
