package it.uniroma3.diadia;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};
	private final static String NOME = "aiuto";

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			System.out.println(ELENCO_COMANDI[i]+" ");
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
