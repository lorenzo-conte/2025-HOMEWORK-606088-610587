
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;

    @BeforeEach
    public void setUp() {
        stanzaBuia = new StanzaBuia("Caverna Oscura", "lanterna");
    }

    @Test
    public void testDescrizione_SenzaAttrezzo() {
        assertEquals("Ma dove sono finito, qui c'è buio pesto...dovrei metterci qualcosa per fare luce", stanzaBuia.getDescrizione());
    }

    @Test
    public void testDescrizione_ConAttrezzoVisibilita() {
        Attrezzo lanterna = new Attrezzo("lanterna", 1);
        stanzaBuia.addAttrezzo(lanterna);
        String descrizione = stanzaBuia.getDescrizione();
        assertTrue(descrizione.contains("Caverna Oscura"));
        assertTrue(descrizione.contains("lanterna"));
    }
}
