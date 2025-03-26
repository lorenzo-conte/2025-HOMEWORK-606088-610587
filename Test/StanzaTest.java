import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class StanzaTest {
	
	
	private Stanza newStanza;
	
	
	
	@BeforeEach
	void SetUp(){
		newStanza = new Stanza("Aula N3");
	}
	
	
	
	
	
	@Test
	void ImpostoStanzaNordDiN3() {
		
		Stanza aulaN4;
		aulaN4 = new Stanza("Aula N2");
		newStanza.impostaStanzaAdiacente("nord", aulaN4);
	}
	
	
	
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
	
	@Test
	void TestDirezioneNordAtrio () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		
		assertEquals("Biblioteca" ,atrio.getStanzaAdiacente("nord").getNome());
		
		
	}
	
	//TEST SU METODO "public Stanza getStanzaAdiacente(String derision)"
	
	@Test
	void TestDirezioneEstAtrio () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		
		assertEquals("Aula N11" ,atrio.getStanzaAdiacente("est").getNome());
		
		
	}
	
	@Test
	void TestDirezioneOvestAtrio () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		
		assertEquals("Laboratorio Campus" ,atrio.getStanzaAdiacente("ovest").getNome());
		
		
	}
	
	
	
	
	
	
	
	
	
	

}