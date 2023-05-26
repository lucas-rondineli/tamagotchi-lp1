package tamagotchi.criatura;

import tamagotchi.animacao.AnimacaoCachorro;

public class TamagotchiCachorro extends TamagotchiBase {
    public TamagotchiCachorro(String nome) {
        super(nome);
        this.setAnimacao(new AnimacaoCachorro(this));
    }
}
