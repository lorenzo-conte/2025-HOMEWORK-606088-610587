
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaNord;

    @BeforeEach
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Corridoio", "nord", "piede_di_porco");
        stanzaNord = new Stanza("Stanza Nord");
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaNord);
    }

    @Test
    public void testGetStanzaAdiacente_SenzaAttrezzo() {
        // Non ho l'attrezzo, quindi rimango nella stanza corrente
        assertSame(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacente_ConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo("piede_di_porco", 1));
        // Ho l'attrezzo, quindi vado a nord
        assertSame(stanzaNord, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testDescrizione_SenzaAttrezzo() {
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("bloccata") || descrizione.contains("Serve l'attrezzo"));
    }

    @Test
    public void testDescrizione_ConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo("piede_di_porco", 1));
        String descrizione = stanzaBloccata.getDescrizione();
        assertFalse(descrizione.contains("bloccata"));
        assertTrue(descrizione.contains("Corridoio"));
    }
}
