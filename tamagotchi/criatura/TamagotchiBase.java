package tamagotchi.criatura;

import tamagotchi.animacao.IAnimacao;
import java.lang.Thread;
import java.io.Serializable;

public abstract class TamagotchiBase implements Serializable {
    // Constantes
    public final int RELOGIO_DOS_STATUS = 500;
    public final int FOME_MINIMA = 0;
    public final int FOME_MAXIMA = 100;
    public final int FELICIDADE_MINIMA = 0;
    public final int FELICIDADE_MAXIMA = 100;
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
    protected int felicidade;
    protected int energia;
    protected int limpeza;
    protected boolean estaVivo;
    protected int estadoAtual;
    protected IAnimacao anm;

    transient protected Thread controladorDosStatus = new Thread(new StatusRunnable(this));
    transient protected Thread controladorDaAnimacao = new Thread(new AnimacaoRunnable(this));

    // Construtor
    public TamagotchiBase(String nome) {
        this.setNome(nome);
        this.fome = this.FOME_MINIMA;
        this.felicidade = this.FELICIDADE_MAXIMA;
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

    public int getFelicidade() {
        return this.felicidade;
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

    public IAnimacao getAnimacao() {
        return this.anm;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected void setAnimacao(IAnimacao anm) {
        this.anm = anm;
    }

    protected void setEstadoAtual(int estado) {
        this.estadoAtual = estado;
    }

    // Métodos
    public void iniciar() {
        if (this.anm != null) {
            this.controladorDosStatus.start();
            this.controladorDaAnimacao.start();
        }
    }

    public void alimentar() {
        this.setEstadoAtual(this.COMENDO);
        this.fome = this.FOME_MINIMA;
        this.resetarEstado(IAnimacao.TEMPO_COMENDO);
    }

    public void brincar() {
        this.setEstadoAtual(this.BRINCANDO);
        this.felicidade = this.FELICIDADE_MAXIMA;
        this.resetarEstado(IAnimacao.TEMPO_BRINCANDO);
    }

    public void limpar() {
        this.setEstadoAtual(this.LIMPANDO);
        this.limpeza = this.LIMPEZA_MAXIMA;
        this.resetarEstado(IAnimacao.TEMPO_LIMPANDO);
    }

    public void dormir() {
        this.setEstadoAtual(this.DORMINDO);
        this.energia = this.ENERGIA_MAXIMA;
        this.resetarEstado(IAnimacao.TEMPO_DORMINDO);
    }

    public void matar() {
        this.estaVivo = false;
    }

    public void reiniciar() {
        this.estaVivo = true;
        this.anm.reiniciarSom();
        this.controladorDosStatus = new Thread(new StatusRunnable(this));
        this.controladorDaAnimacao = new Thread(new AnimacaoRunnable(this));
    }

    void cicloDosStatus() {
        this.fome++;
        this.felicidade--;
        this.energia--;
        this.limpeza--;
    }

    void resetarEstado(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
        }
        this.setEstadoAtual(this.PARADO);
    }
}
