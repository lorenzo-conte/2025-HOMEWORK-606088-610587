import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	

	@Test
	void testcfu() {
		
		assertEquals(20, new Partita().giocatore.getCfu());
				
	}
	
	
	@Test
	void testGetStanzaVincente() {
		
		assertEquals("Biblioteca", new Partita().getLabirinto().getStanzaVincente().getNome());
				
	}
	
	
	
	@Test
	void testGetStanzaCorrente() {
		
		assertEquals("Atrio", new Partita().getLabirinto().getStanzaCorrente().getNome());
				
	}	
	
	
	/*Creo un'istanza di Partita, che di default inizia nell'Atrio, poi creo una nuova
	 * stanza chiamata "Laboratorio". Successivamente viene usato il metodo setStanzaCorrente(nuovaStanza)
	 * per impostarla come stanza attuale. In fine con assertEquals(...) verifico che la stanza 
	 * sia stata aggiornata correttamente*/
	
	@Test
    void testSetStanzaCorrente() {
		
        Partita partita = new Partita();
        Stanza nuovaStanza = new Stanza("Laboratorio"); 
        
        partita.getLabirinto().setStanzaCorrente(nuovaStanza); 
        
        assertEquals("Laboratorio", partita.getLabirinto().getStanzaCorrente().getNome()); 
    
	}
	
	
	@Test
	void testVinta() {
		
		assertFalse(new Partita().vinta());
				
	}
	
	
	
	@Test
	void testIsFinita() {
		
		assertFalse(new Partita().isFinita());
				
	}
	
	@Test
	void testSetFinita() {
		
		Partita partita = new Partita();
		
		assertFalse(partita.isFinita());  //all'inizio la partita non è finita
		
		partita.setFinita(); //faccio finire la partita
		
		assertTrue(partita.isFinita());  /*siccome l'ho fatta finire, mi deve uscire tale risultato dal testo,
		                                  * così da verificare che il metodo setFinita funzioni correttamente */
				
	}	

}
