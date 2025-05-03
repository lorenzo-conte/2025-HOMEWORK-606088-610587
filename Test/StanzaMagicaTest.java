import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class StanzaMagicaTest {
    
    private Partita partita;
    private IO io;

    @BeforeEach
    public void setUp() {
        this.io = new IOConsole();
        partita = new Partita();
       
        StanzaMagica plastica= new StanzaMagica("StanzaPlastificata", 2);
        partita.getLabirinto().creaStanze();
       partita.getLabirinto().setStanzaCorrente(plastica);
       Stanza plastic= partita.getLabirinto().getStanzaCorrente();
        partita.giocatore.getBorsa().addAttrezzo(new Attrezzo("tranquillante", 2));
        plastic.addAttrezzo(new Attrezzo("machete", 6));
        plastic.addAttrezzo(new Attrezzo("tridagger", 4));
    }
    @Test
    public void Effettivamente() {
     
        assertTrue(partita.giocatore.getBorsa().hasAttrezzo("tranquillante"));
        
    }

    @Test
    public void PosaEffettivamente() {
        ComandoPosa comando = new ComandoPosa(io);
        comando.setParametro("tranquillante");
        comando.esegui(partita);
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("etnalliuqnart"));
        
    }
}
