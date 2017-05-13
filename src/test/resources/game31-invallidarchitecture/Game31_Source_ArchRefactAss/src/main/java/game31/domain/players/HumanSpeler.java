package main.java.game31.domain.players;

import java.util.*;

import main.java.game31.domain.gamecontrol.Tafel;

public class HumanSpeler extends Speler
{
	private Calendar gebDatum;

	public HumanSpeler(String naam, Calendar gebDatum, int fiches, Tafel tafel)
	{
		super(naam, fiches, tafel, true);
		this.gebDatum = gebDatum;
	}

	public void aanDeBeurt()
	{
	}

	public void eersteKeerInRonde()
	{
	}
	
	public Calendar geefGeboorteDatum() {
		return gebDatum;
	}
}