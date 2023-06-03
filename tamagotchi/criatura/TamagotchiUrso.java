package tamagotchi.criatura;

import tamagotchi.animacao.mametchi.AnimacaoUrso;

public class TamagotchiUrso extends TamagotchiBase {
    public TamagotchiUrso(String nome) {
        super(nome);
        this.setAnimacao(new AnimacaoUrso(this));
    }
}
