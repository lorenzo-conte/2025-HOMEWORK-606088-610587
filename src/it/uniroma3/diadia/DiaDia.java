package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
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
			"Per conoscere le istruzioni usa il comando 'aiuto'. \n";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};
	private Giocatore giocatore;
	private Partita partita;
	
	private IO io;

	public DiaDia(IO console) {
		
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
		
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
		io.mostraMessaggio("Hai vinto!");
		if (this.partita.isFinita())
		io.mostraMessaggio("Partita finita");
		
		return this.partita.isFinita();
	}



	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}