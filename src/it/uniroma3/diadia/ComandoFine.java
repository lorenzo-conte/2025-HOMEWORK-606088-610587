package it.uniroma3.diadia;

public class ComandoFine implements Comando{
	
	
	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		System.out.println(MESSAGGIO_FINE);
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
