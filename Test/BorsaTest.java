import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo falce;
	Attrezzo sega;
	
	@Before
	public void setUp() {
		falce = new Attrezzo("falce", 4);
		sega = new Attrezzo("sega", 13);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(falce));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(sega));

	}
	
	@Test
	public void testGetPeso() {
		b.addAttrezzo(falce);
		assertEquals(falce, b.getAttrezzo("falce"));
	}
	
	@Test
	public void testHasAttrezzo() {
	    b.addAttrezzo(falce);
	    assertTrue(b.hasAttrezzo("falce"));
	}

	@Test
	public void testGetAttrezzo() {
	    b.addAttrezzo(falce);
	    assertEquals(falce, b.getAttrezzo("falce"));
	}

	@Test
	public void testRemoveAttrezzo() {
	    b.addAttrezzo(falce);
	    assertEquals(falce, b.removeAttrezzo("falce"));
	}

	@Test
	public void testRemoveAttrezzoNonEsistente() {
	    assertNull(b.removeAttrezzo("nonEsiste"));
	}
}
