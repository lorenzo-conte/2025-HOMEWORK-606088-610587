package it.uniroma3.diadia;

public class ComandoNonValido implements Comando{

	@Override
	public void esegui(Partita partita) {
		
		System.out.println("Il comando da te inserito non è valido, usa il tool ''aiuto'' per schiarirti le idee");
		
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
