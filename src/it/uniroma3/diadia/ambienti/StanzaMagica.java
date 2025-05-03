package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	final static private int SOGLIA_MAGICA_DEFAULT=3;
	
	public StanzaMagica(String nome,int soglia) {
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=soglia;
	}
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
		
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
		}
		

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++; //in ogni caso aumenta il contatore di attrezzi
		if(this.contatoreAttrezziPosati>=this.sogliaMagica) {
		attrezzo=modificaAttrezzo(attrezzo); //se era maggiore della soglia richiama modifica	
		}
		//sia che sia sopra che sotto la soglia in ogni caso va aggiunto elemento nella stanza
		return super.addAttrezzo(attrezzo);
		
	}
	

}
