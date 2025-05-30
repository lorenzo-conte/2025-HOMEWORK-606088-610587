package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};
	private final static String NOME = "aiuto";
	private IO io;
	public ComandoAiuto(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Capisco, hai un vuoto di memoria, ti aiuto a ricordare i comandi:\n");
		for(int i=0; i< ELENCO_COMANDI.length; i++) {
			io.mostraMessaggio("["+ELENCO_COMANDI[i]+"] ");
			}
		io.mostraMessaggio("\n");
		}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
