import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ComandoPrendi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	
	private Stanza atrio;
	Partita partita = new Partita();
	Stanza newStanza=new Stanza("Prova");
	@Before
	public void setUp() {
	    partita = new Partita(); 
	    atrio = partita.getLabirinto().getStanzaCorrente();

	    newStanza = new Stanza("Prova");
	    newStanza.addAttrezzo(new Attrezzo("pinza", 12));

	    atrio.addAttrezzo(new Attrezzo("lama", 3));
	    atrio.addAttrezzo(new Attrezzo("cacciavite", 1));
	}

	

	
	@Test
	public void testRaccogliOggettoLamaInAtrio() {
		
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("lama");
		comando.esegui(partita);
		assertEquals("lama", partita.getGiocatore().getBorsa().getAttrezzo("lama").getNome());
		
	}
	
	
	
	@Test
	public void testRaccogliOggettiCacciaviteAtrio() {
		
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("cacciavite");
		comando.esegui(partita);
		assertEquals("cacciavite", partita.getGiocatore().getBorsa().getAttrezzo("cacciavite").getNome());
	}

	@Test
	public void testRaccogliOggettoPinza() {
	    partita.getLabirinto().setStanzaCorrente(newStanza);
	    
	    ComandoPrendi comando = new ComandoPrendi();
	    comando.setParametro("pinza");
	    comando.esegui(partita);

	    //non lo raccoglie perche pesa troppo
	    assertFalse(partita.giocatore.getBorsa().hasAttrezzo("pinza"));
	}

}


