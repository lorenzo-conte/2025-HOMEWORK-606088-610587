package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {
	private String vedere;
	public StanzaBuia(String nome,String vedere) {
		super(nome);
		this.vedere=vedere;
		
	}
	@Override
	public String getDescrizione() {
	    if (this.hasAttrezzo(vedere)) {
	        return super.getDescrizione();
	    } else {
	        return "Ma dove sono finito, qui c'è buio pesto...dovrei metterci qualcosa per fare luce";
	    }
	}

	
	
	
}
