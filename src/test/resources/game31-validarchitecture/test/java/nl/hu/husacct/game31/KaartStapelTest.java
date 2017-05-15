package nl.hu.husacct.game31;

import static org.junit.Assert.assertSame;
import nl.hu.husacct.game31.domein.KaartStapel;

import org.junit.Before;
import org.junit.Test;



public class KaartStapelTest {

	KaartStapel kaartStapel;
	
	@Before
	public void prepareServices(){
		this.kaartStapel = new KaartStapel("Eenendertigen");
	}
	
	@Test 
	public void testAantalKaarten(){
		int aantalKaarten = kaartStapel.getKaarten().size();
		System.out.println(" Number of cards: " + kaartStapel.getKaarten().size());
		assertSame(aantalKaarten, 32);
	}
	
	@Test 
	public void testAantalGeschuddeKaarten(){
		int aantalKaarten = kaartStapel.getKaarten().size();
		assertSame(aantalKaarten, 32);
	}
}
