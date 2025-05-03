package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	final static protected int SOGLIA_MAGICA_DEFAULT=3;
	
	public StanzaMagicaProtected(String nome,int soglia) {
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=soglia;
	}
	public StanzaMagicaProtected(String nome) {
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
		if (this.contatoreAttrezziPosati >= this.sogliaMagica) {
			attrezzo = modificaAttrezzo(attrezzo);
		}
		this.contatoreAttrezziPosati++;

		// USO DIRETTO di array protected
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[this.numeroAttrezzi++] = attrezzo;
			return true;
		}
		return false;
	}

	

}
