package nl.hu.husacct.game31.domein;

import java.util.*;

public class KaartStapel
{
   private KaartSpel kaartSpel;
   private Vector kaarten;
   private Vector oorspronkelijkeKaarten = new Vector();
   private Vector geschuddeKaarten = new Vector();
   private String spelType;
   private int card;

   public KaartStapel(String spelType)
   {
      this.spelType = spelType;
      KaartSpel kaartSpel = new KaartSpel(this);
      kaarten = kaartSpel.geefKaarten();
      for(Enumeration e=kaarten.elements(); e.hasMoreElements();){
      	oorspronkelijkeKaarten.addElement((Kaart) e.nextElement());
      }
   }

   public Vector geefKaartenGeschud(int aantalDeelnemers)
   {
      int number = kaarten.size();
      geschuddeKaarten.removeAllElements();
      for (int i = 0; i < kaarten.size(); i++) {
        card = (int) (Math.random() * number);
        geschuddeKaarten.add(kaarten.elementAt(card));
        kaarten.removeElementAt(card);
        number--;
      }
      geschuddeKaarten.setSize(aantalDeelnemers * 3);
      kaarten.removeAllElements();
	  for(Enumeration e=oorspronkelijkeKaarten.elements(); e.hasMoreElements();){
	    kaarten.addElement((Kaart) e.nextElement());
	  }
      return geschuddeKaarten;
   }

   public String geefSpelType() {
      return spelType;
   }

   public Vector getKaarten() {
	   return kaarten;
   }
}
