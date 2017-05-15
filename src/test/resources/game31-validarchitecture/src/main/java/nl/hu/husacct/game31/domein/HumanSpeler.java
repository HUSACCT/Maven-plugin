package nl.hu.husacct.game31.domein;

import java.util.*;

public class HumanSpeler extends Speler
{
	private Calendar gebDatum;

	public HumanSpeler(String naam, Calendar gebDatum, int fiches, Pot pot, Tafel tafel)
	{
		super(naam, fiches, tafel, pot);
		this.gebDatum = gebDatum;
	}

	public void aanDeBeurt()
	{
	}

	public void eersteKeerInRonde()
	{
	}
}