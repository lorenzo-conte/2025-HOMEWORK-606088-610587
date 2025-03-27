import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class StanzaTest {
	
	
	private Stanza newStanza;
	private Stanza atrio;
	
	
	
	
	@BeforeEach
	void SetUp(){
		newStanza = new Stanza("Aula N3");
		Partita partita = new Partita();
		atrio= partita.getStanzaCorrente();
		
		
		Attrezzo bomba = new Attrezzo("bomba", 15);
		Attrezzo lama = new Attrezzo("lama", 3);
		Attrezzo forbice = new Attrezzo("forbice", 2);
		Attrezzo martello = new Attrezzo("martello", 4);
		Attrezzo cacciavite = new Attrezzo("cacciavite", 1);
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo pinza = new Attrezzo("pinza", 2);
		Attrezzo sega = new Attrezzo("sega", 3);
		Attrezzo tenaglia = new Attrezzo("tenaglia", 2);
		Attrezzo ascia = new Attrezzo("ascia", 5);

		
		newStanza.addAttrezzo(bomba);
		newStanza.addAttrezzo(lama);
		newStanza.addAttrezzo(forbice);
		newStanza.addAttrezzo(martello);
		newStanza.addAttrezzo(cacciavite);
		newStanza.addAttrezzo(chiave);
		newStanza.addAttrezzo(pinza);
		newStanza.addAttrezzo(sega);
		newStanza.addAttrezzo(tenaglia);
		newStanza.addAttrezzo(ascia);
		
	}
	
	//TEST SU "addAttrezzo()" e "getAttrezzi[]"
	
	@Test
	void TestaAggiuntaBombaAdN3(){
		
		assertEquals("bomba", newStanza.getAttrezzi()[0].getNome());
		
	}
	@Test
	void TestaAggiuntaLamaAdN3(){
	
		assertEquals("lama", newStanza.getAttrezzi()[1].getNome());
		
	}
	@Test
	void TestaAggiuntaForbiceAdN3(){
		
		assertEquals("forbice", newStanza.getAttrezzi()[2].getNome());
		
	}
	
	//TEST SU "GetAttrezzo()"
	@Test
	void TestaAggiuntaPinzaAdN3(){
		
		assertEquals("pinza", newStanza.getAttrezzo("pinza").getNome());
		
	}
	@Test
	void TestaAggiuntaSegaAdN3(){
		
		assertEquals("sega", newStanza.getAttrezzo("sega").getNome());
		
	}
	@Test
	void TestaAggiuntaAsciaAdN3(){
		
		assertEquals("ascia", newStanza.getAttrezzo("ascia").getNome());
		 
	}
	
//TEST SU " public void impostaStanzaAdiacente(String derision, Stanza stanza) "
	@Test
	void ImpostoStanzaNordDiN3() {
		
		Stanza aulaN4;
		aulaN4 = new Stanza("Aula N4");
		newStanza.impostaStanzaAdiacente("nord", aulaN4);
		assertEquals("Aula N4" ,newStanza.getStanzaAdiacente("nord").getNome());
	}
	@Test
	void ImpostoStanzaEstDiN3() {
		
		Stanza aulaN5;
		aulaN5 = new Stanza("Aula N5");
		newStanza.impostaStanzaAdiacente("est", aulaN5);
		assertEquals("Aula N5" ,newStanza.getStanzaAdiacente("est").getNome());
	}
	@Test
	void ImpostoStanzaOvestDiN3() {
		
		Stanza aulaN6;
		aulaN6 = new Stanza("Aula N6");
		newStanza.impostaStanzaAdiacente("ovest", aulaN6);
		assertEquals("Aula N6" ,newStanza.getStanzaAdiacente("ovest").getNome());
	}
	
	
	//TEST SU "getNome()
	
	
	@Test
	void AtrioEguale () {
	    
		
		assertEquals("Atrio",atrio.getNome());
		
		
	}
	
	@Test
	void N3Eguale() {
		assertEquals("Aula N3", newStanza.getNome());
		
		
	}
	
	@Test
	void TestDirezioniAtrio () {
	   
		
		
		assertNotNull(atrio.getDirezioni(), "L'array dovrebbe avere un array di direzioni");
		
		
	}
	
	
	//TEST SU METODO "public Stanza getStanzaAdiacente(String derision)"
	
	@Test
	void TestDirezioneNordAtrio () {
	   
		
		assertEquals("Biblioteca" ,atrio.getStanzaAdiacente("nord").getNome());
		
		
	}
	

	
	@Test
	void TestDirezioneEstAtrio () {
	   
		
		assertEquals("Aula N11" ,atrio.getStanzaAdiacente("est").getNome());
		
		
	}
	
	@Test
	void TestDirezioneOvestAtrio () {
	    Partita partita = new Partita();
		Stanza atrio= partita.getStanzaCorrente();
		
		
		assertEquals("Laboratorio Campus" ,atrio.getStanzaAdiacente("ovest").getNome());
		
		
	}
	//TEST SU hasAttrezzo()
	@Test
	void N3HaPinza() {
		
		assertTrue(newStanza.hasAttrezzo("pinza"));
		
	}
	
	@Test
	void N3HaAscia() {
		
		assertTrue(newStanza.hasAttrezzo("ascia"));
		
	}
	
	@Test
	void N3HaLama() {
		
		assertTrue(newStanza.hasAttrezzo("lama"));
		
	}
	
	//TEST SU getDirezioni()	
	
	@Test
	void TestAdiacentiAtrio() {
		
		assertTrue(Arrays.asList(atrio.getDirezioni()).contains("nord"));
		
	}
	@Test
	void TestNumAdiacentiAtrio() {
		
	assertEquals(4, atrio.getDirezioni().length);
		
	}
	@Test
	void TestAdiacentiAtrio2() {
	
	assertTrue(Arrays.asList(atrio.getDirezioni()).contains("sud"));
	
	}
	//TEST  "getDescrizione() e "ToString()"
	@Test
	void TestDescrizioneAtrio() {
		assertNotNull(atrio.getDescrizione());
	}
	@Test
	void TestDescrizioneNordDiAtrio() {
		assertNotNull(atrio.getStanzaAdiacente("nord").getDescrizione());
	}
	void TestDescrizioneSudDiAtrio() {
		assertNotNull(atrio.getStanzaAdiacente("sud").getDescrizione());
	}
	
	
	
	
	

}