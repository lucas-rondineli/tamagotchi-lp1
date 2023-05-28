package tamagotchi.criatura;

import tamagotchi.animacao.sapinho.AnimacaoGato;

public class TamagotchiGato extends TamagotchiBase {
    public TamagotchiGato(String nome) {
        super(nome);
        this.setAnimacao(new AnimacaoGato(this));
    }
}
