package it.uniroma3.diadia;

public class ComandoGuarda implements Comando{
	
	@Override
	public void esegui(Partita partita) {
		System.out.print("\nAttualmente ti trovi in: ");
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		System.out.print("\nIn borsa hai:");
		System.out.println(partita.giocatore.getBorsa().toString());
		System.out.println("Sei ancora in gioco! Ti rimangono "+partita.getGiocatore().getCfu()+"mosse");


		
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
