package tamagotchi.criatura;

import tamagotchi.animacao.AnimacaoGato;

public class TamagotchiGato extends TamagotchiBase {
    public TamagotchiGato(String nome) {
        super(nome);
        this.setAnimacao(new AnimacaoGato(this));
    }
}
