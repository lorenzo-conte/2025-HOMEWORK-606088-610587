package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoGuarda implements Comando{
	private IO io;
	public ComandoGuarda(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Attualmente ti trovi in: ");
	
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		
		io.mostraMessaggio("\n"+partita.giocatore.getBorsa().toString());
		io.mostraMessaggio("\nSei ancora in gioco! Ti rimangono "+partita.getGiocatore().getCfu()+" mosse\n");
		

		
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
