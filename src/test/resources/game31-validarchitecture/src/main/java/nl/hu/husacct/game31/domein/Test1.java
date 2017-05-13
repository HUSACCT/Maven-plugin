package nl.hu.husacct.game31.domein;

import java.util.*;

public class Test1 {
	
	private static double[][][] kaartenTabel;
	private static Kaart[] kaartenIndex;
	
	private static Vector alleKaarten;
	
	
	public static void main(String[] args)
	{
		KaartStapel kStapel = new KaartStapel("Eenendertigen");
		
		alleKaarten = kStapel.getKaarten();
		vulKaartenTabel();
		
		for(int i=0;i<32;i++)
		{
			for(int j=0;j<32;j++)
			{
				for(int k=0;k<32;k++)
				{
					System.out.print(kaartenTabel[i][j][k] + " ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}
	}
	
	private static void vulKaartenTabel()
	{
		Kaart[] kaartenIndex = new Kaart[32];
		
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
						String getal = kaartenIndex[i].geefGetal();
						if(getal.equals(kaartenIndex[j].geefGetal()) && getal.equals(kaartenIndex[k].geefGetal()))
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
}
