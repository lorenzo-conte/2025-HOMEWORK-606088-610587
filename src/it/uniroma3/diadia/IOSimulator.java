package it.uniroma3.diadia;

public class IOSimulator implements IO {

    private String[] comandiUtente;
    private int indiceComando;

    private String[] messaggiStampati;
    private int indiceScritturaMessaggio;
    private int indiceLetturaMessaggio;

    public IOSimulator(String[] comandiUtente) {
        this.comandiUtente = comandiUtente;
        this.indiceComando = 0;

        this.messaggiStampati = new String[1000]; // spazio sufficiente
        this.indiceScritturaMessaggio = 0;
        this.indiceLetturaMessaggio = 0;
    }

    @Override
    public String leggiRiga() {
        if (indiceComando < comandiUtente.length)
            return comandiUtente[indiceComando++];
        return null;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (indiceScritturaMessaggio < messaggiStampati.length)
            this.messaggiStampati[indiceScritturaMessaggio++] = messaggio;
    }

    public boolean haAltriMessaggi() {
        return indiceLetturaMessaggio < indiceScritturaMessaggio;
    }

    public String leggiMessaggio() {
        if (haAltriMessaggi())
            return messaggiStampati[indiceLetturaMessaggio++];
        return null;
    }

    public String[] getMessaggiStampati() {
        return this.messaggiStampati;
    }
}
