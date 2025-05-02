package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendi implements Comando{
	
	
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	private IO io;
	public ComandoPrendi(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (a == null) {
			io.mostraMessaggio("Attrezzo inesistente.\n");
			return;
		}
		if( partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("Oggetto raccolto con successo!\n");
		} 
		else {
			io.mostraMessaggio("Attrezzo troppo pesante, non può entrare in borsa\n");
		}
	}

	
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

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
