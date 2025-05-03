package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {

    static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
    static final protected int NUMERO_MASSIMO_ATTREZZI = 10;

    protected String nome;
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;
    protected StanzaProtected[] stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
    protected String[] direzioni;

    public StanzaProtected(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
        boolean aggiornato = false;
        for (int i = 0; i < this.direzioni.length; i++)
            if (direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                aggiornato = true;
            }
        if (!aggiornato)
            if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
                this.direzioni[numeroStanzeAdiacenti] = direzione;
                this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
                this.numeroStanzeAdiacenti++;
            }
    }

    public StanzaProtected getStanzaAdiacente(String direzione) {
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione))
                return this.stanzeAdiacenti[i];
        }
        return null;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescrizione() {
        return this.toString();
    }

    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    public int getNumeroAttrezzi() {
        return this.numeroAttrezzi;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[this.numeroAttrezzi++] = attrezzo;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        for (Attrezzo a : this.attrezzi) {
            if (a != null && a.getNome().equals(nomeAttrezzo))
                return true;
        }
        return false;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo a : this.attrezzi) {
            if (a != null && a.getNome().equals(nomeAttrezzo))
                return a;
        }
        return null;
    }

    public boolean removeAttrezzo(Attrezzo attrezzo) {
        String nomeTogliere = attrezzo.getNome();
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i] != null && nomeTogliere.equals(this.attrezzi[i].getNome())) {
                this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi - 1];
                this.attrezzi[this.numeroAttrezzi - 1] = null;
                this.numeroAttrezzi--;
                return true;
            }
        }
        return false;
    }

    public String[] getDirezioni() {
        String[] direzioni = new String[this.numeroStanzeAdiacenti];
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            direzioni[i] = this.direzioni[i];
        return direzioni;
    }

    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        for (String direzione : this.direzioni)
            if (direzione != null)
                risultato.append(" " + direzione);
        risultato.append("\nAttrezzi nella stanza: ");
        for (Attrezzo attrezzo : this.attrezzi)
            if (attrezzo != null)
                risultato.append(attrezzo.toString() + " ");
        return risultato.toString();
    }
}
