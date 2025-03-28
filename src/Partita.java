



/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	Giocatore giocatore= new Giocatore();
	private Labirinto labirinto;
	
	private boolean finita;
	static final private int CFU_INIZIALI = 20;
	
	
	public Partita(){
		
		labirinto = new Labirinto();
		labirinto.creaStanze();
		this.finita = false;
		this.giocatore.CreaCFU();
	}
	
	
	/*tutto ciò che era in questa classe Partita, riguardante la creazione delle
	 * stanze, è stato spostato nella classe Labirinto*/	
	
	
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
		
	
	
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente() == labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	
}
