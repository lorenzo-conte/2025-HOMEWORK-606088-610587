package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO io;
	public ComandoNonValido(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		
		io.mostraMessaggio("Il comando da te inserito non è valido, usa il tool ''aiuto'' per schiarirti le idee\n");
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
