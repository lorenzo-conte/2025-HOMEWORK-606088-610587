import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StanzaTest {
	
	
	
	
	@Test
	void AtrioEguale () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		assertEquals("Atrio",atrio.getNome());
		
		
		
	}
	@Test
	void TestDirezioniAtrio () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		
		assertNotNull(atrio.getDirezioni(), "L'array dovrebbe avere un array di direzioni");
		
		
	}

}
