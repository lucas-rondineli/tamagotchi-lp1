package tamagotchi.criatura;

import java.lang.Thread;
import tamagotchi.animacao.Animacao;

public abstract class TamagotchiBase {
    // Constantes
    public final int RELOGIO_DOS_STATUS = 500;
    public final int RELOGIO_DA_ANIMACAO = 1000;
    public final int FATOR_DE_TEMPO_DE_ACAO = 3;
    public final int FOME_MINIMA = 0;
    public final int FOME_MAXIMA = 100;
    public final int ENERGIA_MINIMA = 0;
    public final int ENERGIA_MAXIMA = 100;
    public final int LIMPEZA_MINIMA = 0;
    public final int LIMPEZA_MAXIMA = 100;
    public final int PARADO = 0;
    public final int COMENDO = 1;
    public final int BRINCANDO = 2;
    public final int DORMINDO = 3;
    public final int LIMPANDO = 4;

    // Atributos
    protected String nome;
    protected int fome;
    protected int energia;
    protected int limpeza;
    protected boolean estaVivo;
    protected int estadoAtual;
    protected Animacao anm;

    protected Thread controladorDosStatus = new Thread(new StatusRunnable(this));
    protected Thread controladorDaAnimacao = new Thread(new AnimacaoRunnable(this));

    // Construtor
    public TamagotchiBase(String nome) {
        this.setNome(nome);
        this.fome = this.FOME_MINIMA;
        this.energia = this.ENERGIA_MAXIMA;
        this.limpeza = this.LIMPEZA_MAXIMA;
        this.estaVivo = true;
        this.estadoAtual = this.PARADO;
    }

    // Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public int getFome() {
        return this.fome;
    }

    public int getEnergia() {
        return this.energia;
    }

    public int getLimpeza() {
        return this.limpeza;
    }

    public boolean getEstaVivo() {
        return this.estaVivo;
    }

    public int getEstadoAtual() {
        return this.estadoAtual;
    }

    public Animacao getAnimacao() {
        return this.anm;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnimacao(Animacao anm) {
        this.anm = anm;
    }

    public void setEstadoAtual(int estado) {
        this.estadoAtual = estado;
    }

    // Métodos
    public void iniciar() {
        if (this.anm != null) {
            this.controladorDosStatus.start();
            this.controladorDaAnimacao.start();
        }
    }

    public void cicloDosStatus() {
        this.fome++;
        this.energia--;
        this.limpeza--;
    }

    public void alimentar() {
        this.setEstadoAtual(this.COMENDO);
        this.fome = this.FOME_MINIMA;
        this.resetarEstado();
    }

    public void brincar() {
        this.setEstadoAtual(this.BRINCANDO);
        this.resetarEstado();
    }

    public void limpar() {
        this.setEstadoAtual(this.LIMPANDO);
        this.limpeza = this.LIMPEZA_MAXIMA;
        this.resetarEstado();
    }

    public void dormir() {
        this.setEstadoAtual(this.DORMINDO);
        this.energia = this.ENERGIA_MAXIMA;
        this.resetarEstado();
    }

    public void matar() {
        this.estaVivo = false;
    }

    public void resetarEstado() {
        try {
            Thread.sleep(this.RELOGIO_DA_ANIMACAO * this.FATOR_DE_TEMPO_DE_ACAO);
        } catch (InterruptedException e) {
        }
        this.setEstadoAtual(this.PARADO);
    }
}
