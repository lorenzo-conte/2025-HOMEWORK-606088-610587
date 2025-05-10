
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiTest {
	private IO io;
	Partita partita;
	
	@Before
	public void setUp() {
		this.io=new IOConsole();
		partita=new Partita();
		partita.getLabirinto().creaStanze();
		}
	
	
	@Test
	public void testVai() {
		ComandoVai comando = new ComandoVai(io);
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals("Aula N10",partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testFine() {
		ComandoFine comando = new ComandoFine(io);
		comando.esegui(partita);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testNonValido() {
		ComandoNonValido comando = new ComandoNonValido(io);
		comando.esegui(partita);
		
	}
	
	
}
