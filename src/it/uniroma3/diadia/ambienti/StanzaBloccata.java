package it.uniroma3.diadia.ambienti;



import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String sbloccaStanza;

	public StanzaBloccata(String nome,String direzione,String sblocca) {
		super(nome);
		this.direzioneBloccata=direzione;
		this.sbloccaStanza=sblocca;
	

		
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		//nell'if controllo se la direzione che mi viene data come parametro sia quella che viene bloccata
		//se,è lei e non c'è l'attrezzo che serve nella stanza mi ritorna la stanza attuale;altrimenti
		// se la direzione non è quella della stanza bloccata OPPURE la direzione è quella della stanza bloccata 
		//ma c'è lo strumentopolo il programma si comporta normalmente
		if( direzione.equals(direzioneBloccata) && !this.hasAttrezzo(sbloccaStanza)) {
			return this ;
      
		}else {
			   return super.getStanzaAdiacente(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		String descrizioneBase = super.getDescrizione();
		if (!this.hasAttrezzo(sbloccaStanza)) {
			descrizioneBase += "\n[ATTENZIONE] La direzione \"" + direzioneBloccata +
				"\" è bloccata. Serve l'attrezzo \"" + sbloccaStanza + "\" per sbloccarla.";
		}
		return descrizioneBase;
	}


}