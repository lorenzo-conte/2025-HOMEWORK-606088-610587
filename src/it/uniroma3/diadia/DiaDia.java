package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};
	private Giocatore giocatore;
	private Partita partita;
	
	private IOConsole io;

	public DiaDia(IOConsole console) {
		
		this.io = console;
		
		this.partita = new Partita();
		this.giocatore= new Giocatore();
	}

	public void gioca() {
		String istruzione; 
	

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		Scanner scannerDiLinee;		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   
	
	
	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire;
		
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
		io.mostraMessaggio("Hai vinto!");
		if (this.partita.isFinita())
		io.mostraMessaggio("Partita finita");
		
		return this.partita.isFinita();
	}


	/*
	private boolean processaIstruzione(String istruzione) {
	    Comando comandoDaEseguire = new Comando(istruzione);

	    if (comandoDaEseguire.getNome().equals("fine")) {
	        this.fine();
	        System.exit(0);

	    } else if (comandoDaEseguire.getNome().equals("vai")) {
	        this.vai(comandoDaEseguire.getParametro());

	    } else if (comandoDaEseguire.getNome().equals("aiuto")) {
	        this.aiuto();

	    } else if (comandoDaEseguire.getNome().equals("prendi")) {
	        if (this.PrendiAttrezzo(comandoDaEseguire.getParametro())) {
	            io.mostraMessaggio("Hai preso l'attrezzo.");
	        } else {
	            io.mostraMessaggio("Non c'� quell'attrezzo nella stanza.");
	        }
	        // Stampa stanza e borsa dopo il comando
	        io.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
	        io.mostraMessaggio(this.partita.giocatore.getBorsa().toString());

	    } else if (comandoDaEseguire.getNome().equals("posa")) {
	        if (this.PosaAttrezzo(comandoDaEseguire.getParametro())) {
	        	io.mostraMessaggio("Hai posato l'attrezzo.");
	        } else {
	        	io.mostraMessaggio("Non hai quell'attrezzo o la stanza � piena.");
	        }
	        // Stampa stanza e borsa dopo il comando
	        io.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
	        io.mostraMessaggio(this.partita.giocatore.getBorsa().toString());
	                                                             /*aggiungo il toString() perchè in IOConsole si ha "public void mostraMessaggio(String msg)",
	                                                              * ma io gli sto passando una Borsa, che non è una String; ciò che si fa in breve è convertire 
	                                                              * Borsa in String


	    } else {
	    	io.mostraMessaggio("Comando sconosciuto");
	    }

	    if (this.partita.vinta()) {
	    	io.mostraMessaggio("Hai vinto!");
	        return true;
	    } else {
	        return false;
	    }
	}


	//implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	
	/*
	private void aiuto() {
		io.mostraMessaggio("Capisco, hai un vuoto di memoria, ti aiuto a ricordare i comandi:");
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio("["+ elencoComandi[i]+"] ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	
	/*
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu-1);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	//PRENDI ATTREZZO
	private boolean PrendiAttrezzo(String nomeAttrezzo) {
	    Stanza corrente = this.partita.getLabirinto().getStanzaCorrente();
	    Attrezzo[] attrezzi = corrente.getAttrezzi();
	    Attrezzo attrezzo = null;

	    for (int i = 0; i < attrezzi.length; i++) {
	        if (attrezzi[i] != null && attrezzi[i].getNome().equals(nomeAttrezzo)) {
	            attrezzo = attrezzi[i];
	            break;
	        }
	    }

	    if (attrezzo != null) {
	        corrente.removeAttrezzo(attrezzo);
	        this.partita.giocatore.getBorsa().addAttrezzo(attrezzo);
	        return true;
	    }

	    return false;
	}

	
	private boolean PosaAttrezzo(String attrezzo) {
	    Stanza corrente = this.partita.getLabirinto().getStanzaCorrente();
	    Borsa sium = this.partita.giocatore.getBorsa();
	    Attrezzo posare = sium.getAttrezzo(attrezzo);

	    if (posare != null && corrente.getNumeroAttrezzi() < 10) {
	        corrente.addAttrezzo(posare);
	        sium.removeAttrezzo(posare.getNome());
	        return true;
	    }

	    return false;
	}
	
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  
		System.exit(0);
	}

	*/
	

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}