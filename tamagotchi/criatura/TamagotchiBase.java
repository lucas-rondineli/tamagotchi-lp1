package tamagotchi.criatura;

import java.lang.Thread;

public abstract class TamagotchiBase {
    public int CLOCK_TIME = 500;
    public int FOME_MINIMA = 0;
    public int FOME_MAXIMA = 100;
    public int ENERGIA_MINIMA = 0;
    public int ENERGIA_MAXIMA = 100;
    public int LIMPEZA_MINIMA = 0;
    public int LIMPEZA_MAXIMA = 100;

    private String nome;
    private int fome;
    private int energia;
    private int limpeza;
    private boolean estaVivo;

    private Thread controladorDosCiclos = new Thread(new TamagotchiRunnable(this));

    public boolean getEstaVivo() {
        return this.estaVivo;
    }

    public void cicloPrincipal() {

    }

    public void matar() {
        this.estaVivo = false;
    }
}
