package tamagotchi.animacao.sapinho;

import tamagotchi.animacao.IAnimacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import tamagotchi.som.Som;
import java.io.Serializable;

public class AnimacaoSapo implements IAnimacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;
    transient private Som som = new Som();

    // Construtor
    public AnimacaoSapo(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        int tempoDoFrame = IAnimacao.TEMPO_PARADO / 2;

        this.limpaTela();
        SapoPadrao.padrao1();
        cicloDeAnimacao(tempoDoFrame);

        SapoPadrao.padrao2();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void comendo() {
        int tempoDoFrame = IAnimacao.TEMPO_COMENDO / 10;

        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao(tempoDoFrame);

        AnimacaoMaca.maca3();
        cicloDeAnimacao(tempoDoFrame);

        AnimacaoMaca.maca5();
        cicloDeAnimacao(tempoDoFrame);

        SapoComer.comer1();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        SapoComer.comer2();
        cicloDeAnimacao(tempoDoFrame);

        SapoComer.comer3();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        SapoComer.comer4();
        cicloDeAnimacao(tempoDoFrame);

        SapoComer.comer5();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        SapoComer.comer6();
        cicloDeAnimacao(tempoDoFrame);
        SapoComer.comer7();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void brincando() {
        int tempoDoFrame = IAnimacao.TEMPO_BRINCANDO / 5;

        this.limpaTela();
        SapoBrincar.brincar1();
        cicloDeAnimacao(tempoDoFrame);
        som.brincar();

        SapoBrincar.brincar2();
        cicloDeAnimacao(tempoDoFrame);

        SapoBrincar.brincar3();
        cicloDeAnimacao(tempoDoFrame);
        som.brincar();

        SapoBrincar.brincar4();
        cicloDeAnimacao(tempoDoFrame);

        SapoBrincar.brincar5();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void dormindo() {
        int tempoDoFrame = IAnimacao.TEMPO_DORMINDO / 9;

        this.limpaTela();
        SapoDormir.dormir1();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        SapoDormir.dormir2();
        cicloDeAnimacao(tempoDoFrame);

        SapoDormir.dormir3();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        SapoDormir.dormir4();
        cicloDeAnimacao(tempoDoFrame);

        SapoDormir.dormir5();
        cicloDeAnimacao(tempoDoFrame);

        SapoDormir.dormir6();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        SapoDormir.dormir7();
        cicloDeAnimacao(tempoDoFrame);

        SapoDormir.dormir8();
        cicloDeAnimacao(tempoDoFrame);

        SapoDormir.dormir9();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void limpando() {
        int tempoDoFrame = IAnimacao.TEMPO_LIMPANDO / 6;

        this.limpaTela();
        SapoCoco.coco1();
        cicloDeAnimacao(tempoDoFrame);
        som.limpar();

        SapoCoco.coco2();
        cicloDeAnimacao(tempoDoFrame);

        SapoLimpar.limpeza1();
        cicloDeAnimacao(tempoDoFrame);

        SapoLimpar.limpeza2();
        cicloDeAnimacao(tempoDoFrame);

        SapoLimpar.limpeza3();
        cicloDeAnimacao(tempoDoFrame);

        SapoLimpar.limpeza4();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void morto() {
        int tempoDoFrame = 500;

        this.limpaTela();
        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(tempoDoFrame);
        som.morrer();

        AnimacaoMorrer.morrer2();
        cicloDeAnimacao(tempoDoFrame);
        som.morrer();

        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(tempoDoFrame);

        AnimacaoMorrer.morrer2();
        System.out.println("x-----------------------------------------------------------------x");
        System.out.printf("                         SEU %s MORREU                           \n" +
                "", this.tamagotchi.getNome().toUpperCase());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }

    public void mostrarStatus() {
        System.out.printf("\nNome: %s\n", this.tamagotchi.getNome());
        System.out.printf("Fome: %d / %d\n", this.tamagotchi.getFome(), this.tamagotchi.FOME_MAXIMA);
        System.out.printf("Felicidade: %d / %d\n", this.tamagotchi.getFelicidade(), this.tamagotchi.FELICIDADE_MAXIMA);
        System.out.printf("Energia: %d / %d\n", this.tamagotchi.getEnergia(), this.tamagotchi.ENERGIA_MAXIMA);
        System.out.printf("Limpeza: %d / %d\n", this.tamagotchi.getLimpeza(), this.tamagotchi.LIMPEZA_MAXIMA);

        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x-----------------------------------------------------------------x");
        System.out.println("x 1) Alimentar    2) Brincar   3) Banheiro     4) Dormir  0) Sair x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void esperar(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
        }
    }

    public void cicloDeAnimacao(int tempoDoCiclo) {
        this.mostrarStatus();
        this.esperar(tempoDoCiclo);
        this.limpaTela();
    }

    public void reiniciarSom() {
        this.som = new Som();
    }
}
