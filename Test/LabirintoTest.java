import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;


public class LabirintoTest {
	
	Labirinto l;
	Stanza stanza;
	Stanza laboratorio;
	Stanza biblioteca;
	
	

	@Before
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		
        assertEquals("Atrio", l.getStanzaCorrente().getNome()); 
		biblioteca = new Stanza("Biblioteca");
		laboratorio = new Stanza("laboratorio");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(laboratorio);
		assertEquals(laboratorio, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testCreazioneStanze() {
	    assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

	@Test
	public void testCollegamentoStanze() {
	    assertNotNull(l.getStanzaCorrente().getStanzaAdiacente("nord"));
	}

	    
	@Test
	public void testStanzaNonVincente() {
	    assertNotEquals("laboratorio", l.getStanzaVincente().getNome());
	}

}
