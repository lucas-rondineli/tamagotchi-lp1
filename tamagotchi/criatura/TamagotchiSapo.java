package tamagotchi.criatura;

import tamagotchi.animacao.sapinho.AnimacaoSapo;

public class TamagotchiSapo extends TamagotchiBase {
    public TamagotchiSapo(String nome) {
        super(nome);
        this.setAnimacao(new AnimacaoSapo(this));
    }
}
