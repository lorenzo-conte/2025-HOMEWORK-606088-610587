package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


import java.util.Scanner;


public interface Comando{
	
	public void esegui(Partita partita);
	
	void setParametro(String parametro);

	String getParametro();
	
	public String getNome();
	
	
}