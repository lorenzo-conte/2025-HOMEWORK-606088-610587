
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
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;


public class ComandoPosaTest {
	private IO io;
	
	

	Partita partita;
	

	
	@Before
	public void setUp() {
		this.io=new IOConsole();
		partita=new Partita();
		partita.getLabirinto().creaStanze();
		partita.giocatore.getBorsa().addAttrezzo(new Attrezzo("tnt", 2));
		partita.giocatore.getBorsa().addAttrezzo(new Attrezzo("razzo", 3));
		partita.giocatore.getBorsa().addAttrezzo(new Attrezzo("sasso", 1));

		
		
	}
	@Test
	public void PosaSasso() {
		ComandoPosa comando=new ComandoPosa(io);
		comando.setParametro("sasso");
		comando.esegui(partita);
		assertFalse(partita.giocatore.getBorsa().hasAttrezzo("sasso"));
		
		}
	
	

	
	@Test
	public void Posatnt() {
		ComandoPosa comando=new ComandoPosa(io);
		comando.setParametro("tnt");
		comando.esegui(partita);
		assertFalse(partita.giocatore.getBorsa().hasAttrezzo("tnt"));
		
		}
	
	@Test
	public void PosaRazzo() {
		ComandoPosa comando=new ComandoPosa(io);
		comando.setParametro("razzo");
		comando.esegui(partita);
		assertFalse(partita.giocatore.getBorsa().hasAttrezzo("razzo"));
		
		}
	
	
	
}
