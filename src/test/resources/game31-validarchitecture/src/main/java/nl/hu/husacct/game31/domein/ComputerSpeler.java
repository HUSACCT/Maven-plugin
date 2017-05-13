package nl.hu.husacct.game31.domein;

import java.util.*;

public class ComputerSpeler extends Speler{

	private double[][][] kaartenTabel;
	private Kaart[] kaartenIndex;

	private Vector alleKaarten;

	private Spel spel;
	private int schuifCounter = 0;

	public ComputerSpeler(String naam, int fices, Tafel tafel, Pot pot, KaartStapel kaartStapel, Spel spel)
	{
		super(naam,fices, tafel, pot);
		this.alleKaarten = kaartStapel.getKaarten();
		this.spel = spel;
		vulKaartenTabel();
		printTabel();
	}

	private void vulKaartenTabel()
	{
		kaartenIndex = new Kaart[32];

		Vector kaarten = alleKaarten;

		//kaarten ophalen en in een array plaatsen
		int index = 0;
		for(Iterator itr = kaarten.iterator();itr.hasNext();index++)
		{
			Kaart k = (Kaart) itr.next();
			kaartenIndex[index] = k;
			//System.out.println(index + " " + k.geefSymbool() + " " + k.geefGetal());
		}


		//kaartenTabel invullen, de coordinaten geven de index van de Kaart in de kaartenIndex aan
		//op de locatie staat het aantal punten dat een combinatie oplevert
		kaartenTabel = new double[32][32][32];
		for(int i=0;i<32;i++)
		{
			for(int j=0;j<32;j++)
			{
				for(int k=0;k<32;k++)
				{
					//niet dezelfde kaart
					if(kaartenIndex[i] != kaartenIndex[j] && kaartenIndex[i] != kaartenIndex[k] && kaartenIndex[j] != kaartenIndex[k])
					{
						//zelfde getal
						String getalK1 = kaartenIndex[i].geefGetal();
						String getalK2 = kaartenIndex[j].geefGetal();
						String getalK3 = kaartenIndex[k].geefGetal();
						if(getalK1.equals(getalK2) && getalK1.equals(getalK3) && getalK3.equals(getalK2))
						{
							kaartenTabel[i][j][k] = 30.5;
						}

						//zelfde kleur
						String symbool = kaartenIndex[i].geefSymbool();

						if(symbool.equals(kaartenIndex[j].geefSymbool()) && symbool.equals(kaartenIndex[k].geefSymbool()))
						{
							kaartenTabel[i][j][k] = kaartenIndex[i].geefWaarde() + kaartenIndex[j].geefWaarde() + kaartenIndex[k].geefWaarde();
						}
						else if(symbool.equals(kaartenIndex[j].geefSymbool()))
						{
							kaartenTabel[i][j][k] = kaartenIndex[i].geefWaarde() + kaartenIndex[j].geefWaarde();
						}
						else if(symbool.equals(kaartenIndex[k].geefSymbool()))
						{
							kaartenTabel[i][j][k] = kaartenIndex[i].geefWaarde() + kaartenIndex[k].geefWaarde();
						}
						else if(kaartenIndex[j].geefSymbool().equals(kaartenIndex[k].geefSymbool()))
						{
							kaartenTabel[i][j][k] = kaartenIndex[j].geefWaarde() + kaartenIndex[k].geefWaarde();
						}
					}
				}
			}
		}
	}

	//de computerspeler krijgt de beurt
	public void aanDeBeurt()
	{
		Vector opTafel = tafel.getKaarten();
		Vector inHand  = deelname.getKaarten();

		double puntenOpTafel = zoekPunten(opTafel);
		double puntenInHand = zoekPunten(inHand);

		int[] indexHand = new int[3];
		int[] indexTafel = new int[3];

		for(int i=0;i<3;i++)
		{
			indexHand[i] = zoekIndex((Kaart)inHand.elementAt(i));
			indexTafel[i] = zoekIndex((Kaart)opTafel.elementAt(i));
		}

		double[][] puntenTabel = combineer(indexHand, indexTafel);
		int[] besteCoords = zoekCoordsBeste(puntenTabel);
		double bestePunten = puntenTabel[besteCoords[0]][besteCoords[1]];

		if(bestePunten > puntenOpTafel && bestePunten > puntenInHand)
		{
			//1kaart wisselen
			tafel.selecteerKaart(besteCoords[1]);
			deelname.selecteerKaart(besteCoords[0]);
			spel.ruil1Kaart(deelname.getSelected(), tafel.getSelected());
		}
		else if(bestePunten < puntenOpTafel)
		{
			//alles wisselen
			spel.ruil3Kaart();
			schuifCounter = 0;
		}
		else if(bestePunten <= puntenInHand)
		{
			if(puntenInHand > 25 || schuifCounter == 2)
			{
				//pass
				spel.pas();
			}
			else
			{
				//doorschuiven
				schuifCounter++;
				spel.doorSchuiven();
			}
		}
		Vector handkaartjes = deelname.getKaarten();
		for(int i=0;i<3;i++)
		{
			Kaart k = (Kaart)handkaartjes.elementAt(i);
			System.out.println(k.geefSymbool() + " " + k.geefGetal());
		}
		
	}

	//de computerspeler krijgt als eerste de beurt in een nieuwe ronde
	public void eersteKeerInRonde()
	{
		schuifCounter = 0;
		
		Vector inHand  = deelname.getKaarten();
		double puntenInHand = zoekPunten(inHand);

		//kan er 30.5 worden gescoord met deze kaarten?
		Vector kaarten = deelname.getKaarten();
		Kaart krt1 = (Kaart) kaarten.elementAt(0);
		Kaart krt2 = (Kaart) kaarten.elementAt(1);
		Kaart krt3 = (Kaart) kaarten.elementAt(2);

		if(puntenInHand == 31.0)
		{
			//doorschuiven
			spel.doorSchuiven();
			schuifCounter++;
		}
		else if(puntenInHand > 25)
		{
			//pass
			spel.pas();
		}
		else if(krt1.geefGetal().equals(krt2.geefGetal()) || krt1.geefGetal().equals(krt3.geefGetal()) || krt2.geefGetal().equals(krt3.geefGetal()))
		{
			//kaarten bekijken
			//zoek beste ruil
			//aanDeBeurt heeft dezelfde functionaliteiten dus roep ik die hier aan
			aanDeBeurt();
		}
		else if(puntenInHand == 0.0)
		{
			spel.ruil3Kaart();
		}
	}


	private int[] zoekCoordsBeste(double[][] puntenTabel)
	{
		int[] coords = new int[2];
		double grootste = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(puntenTabel[i][j] > grootste)
				{
					coords[0] = i;
					coords[1] = j;
				}
			}
		}
		return coords;
	}

	private double[][] combineer(int[] hand, int[] tafel)
	{
		double[][] tabel = new double[3][3];

		for(int i=0;i<3;i++) //regel
		{
			for(int j=0;j<3;j++) //kolom
			{
				int[] combinatie = new int[3];
				for(int k=0;k<3;k++)
				{
					if(k == i)
					{
						combinatie[k] =  tafel[j];
					}
					else
					{
						combinatie[k] = hand[k];
					}
				}
				tabel[i][j] = kaartenTabel[combinatie[0]][combinatie[1]][combinatie[2]];
			}
		}

		return tabel;
	}

	private int zoekIndex(Kaart k)
	{
		int index = 0;
		for(int i=0;i<32;i++)
		{
			if(kaartenIndex[i] == k)
			{
				return i;
			}
		}
		return -1;
	}

	private double zoekPunten(Vector kaarten)
	{
		double aantalPunten = 0;

		int[] index = new int[3];
		index[0] = zoekIndex((Kaart)kaarten.elementAt(0));
		index[1] = zoekIndex((Kaart)kaarten.elementAt(1));
		index[2] = zoekIndex((Kaart)kaarten.elementAt(2));

		aantalPunten = kaartenTabel[index[0]][index[1]][index[2]];

		return aantalPunten;
	}
	private void printTabel()
	{
		for(int i=0;i<32;i++)
		{
			for(int j=0;j<32;j++)
			{
				for(int k=0;k<32;k++)
				{
					System.out.print(" " + kaartenTabel[i][j][k]);
				}
				System.out.print('\n');
			}
			System.out.print('\n');
		}
	}
}
