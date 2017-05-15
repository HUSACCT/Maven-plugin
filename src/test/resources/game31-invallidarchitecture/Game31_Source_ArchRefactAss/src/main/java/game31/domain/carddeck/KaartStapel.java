package main.java.game31.domain.carddeck;

import java.util.*;

public class KaartStapel
{
   private Vector<Kaart> kaarten;
   private Vector<Kaart> oorspronkelijkeKaarten = new Vector<>();
   private Vector<Kaart> geschuddeKaarten = new Vector<>();
   private String spelType;
   private int card;

   public KaartStapel(String spelType)
   {
      this.spelType = spelType;
      KaartSpel kaartSpel = new KaartSpel(this);
      kaarten = kaartSpel.geefKaarten();
      for(Enumeration<Kaart> e=kaarten.elements(); e.hasMoreElements();){
      	oorspronkelijkeKaarten.addElement((Kaart) e.nextElement());
      }
   }

   public Vector<Kaart> geefKaartenGeschud(int aantalDeelnemers)
   {
      int number = kaarten.size();
      geschuddeKaarten.removeAllElements();
      for (int i = 0; i < kaarten.size(); i++) {
        card = (int) (Math.random() * number);
        geschuddeKaarten.add((Kaart) kaarten.elementAt(card));
        kaarten.removeElementAt(card);
        number--;
      }
      geschuddeKaarten.setSize(aantalDeelnemers * 3);
      kaarten.removeAllElements();
	  for(Enumeration<Kaart> e=oorspronkelijkeKaarten.elements(); e.hasMoreElements();){
	    kaarten.addElement((Kaart) e.nextElement());
	  }
      return geschuddeKaarten;
   }

   public String geefSpelType() {
      return spelType;
   }

   public Vector<Kaart> getKaarten() {
	   return kaarten;
   }
}
