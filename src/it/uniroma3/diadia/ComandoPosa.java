package it.uniroma3.diadia;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		 if (a == null) {
		        System.out.println("Attrezzo inesistente nella borsa.");
		        return;
		    }
		if(partita.getStanzaCorrente().getNumeroAttrezzi()<=10) {
			
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			System.out.println("Oggetto posato con successo!");
		}
		else {
			System.out.println("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
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
