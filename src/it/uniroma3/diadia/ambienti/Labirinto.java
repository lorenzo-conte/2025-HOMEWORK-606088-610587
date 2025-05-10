package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
//import Stanza;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	Attrezzo passi=new Attrezzo("passi",1);//modifica
    	Attrezzo corrente=new Attrezzo("corrente",2);//modifica
    	Attrezzo xilazina=new Attrezzo("tranquillante",3); //modifica
    	Attrezzo carro=new Attrezzo("carrarmato",15);//modifica
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza armadillo=new Stanza("Stanza Biologia Animale");
		StanzaMagica aulaPlastica= new StanzaMagica("Stanza Plastificata", 2);//modifica
		StanzaBloccata ufficioRettore= new StanzaBloccata("Ufficio del Rettore", "est","passi");//modifica
		StanzaBuia sgabuzzino=new StanzaBuia("Sgabuzzino", "corrente");//modifica
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", aulaPlastica);//modifica
		aulaN11.impostaStanzaAdiacente("nord", ufficioRettore);//modifica
		
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", aulaPlastica);//modifica
		
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("nord", sgabuzzino);//modifica
		
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		aulaPlastica.impostaStanzaAdiacente("nord", aulaN11); //modifica
		aulaPlastica.impostaStanzaAdiacente("sud",aulaN10 );//modifica

		ufficioRettore.impostaStanzaAdiacente("sud", aulaN11);//modifica
		ufficioRettore.impostaStanzaAdiacente("est", armadillo);//modifica
		
		armadillo.impostaStanzaAdiacente("ovest", ufficioRettore);
		
		sgabuzzino.impostaStanzaAdiacente("sud", laboratorio);//modifica

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(xilazina);//modifica
		sgabuzzino.addAttrezzo(corrente);//modifica
		sgabuzzino.addAttrezzo(carro);//modifica
		ufficioRettore.addAttrezzo(passi);//modifica
		

		// il gioco comincia nell'atrio
       stanzaCorrente = atrio;  
	//	 stanzaCorrente = aulaPlastica;
		stanzaVincente = biblioteca;
    }
    
    
    public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

}
