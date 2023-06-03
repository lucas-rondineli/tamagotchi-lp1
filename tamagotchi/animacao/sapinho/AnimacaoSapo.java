package tamagotchi.animacao.sapinho;

import tamagotchi.animacao.Animacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import tamagotchi.som.Som;

import java.io.Serializable;

public class AnimacaoSapo implements Animacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;
    Som som = new Som();

    // Construtor
    public AnimacaoSapo(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        this.limpaTela();
        SapoPadrao.padrao1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);

        SapoPadrao.padrao2();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
    }

    public void comendo() {
        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        AnimacaoMaca.maca3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        AnimacaoMaca.maca5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);

        SapoComer.comer1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        som.comer();
        SapoComer.comer2();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        SapoComer.comer3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        som.comer();
        SapoComer.comer4();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        SapoComer.comer5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        som.comer();
        SapoComer.comer6();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);
        SapoComer.comer7();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 10);

    }

    public void brincando() {
        this.limpaTela();
        SapoBrincar.brincar1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        som.brincar();
        SapoBrincar.brincar2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar3();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        som.brincar();
        SapoBrincar.brincar4();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar5();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
    }

    public void dormindo() {
        this.limpaTela();
        som.dormir();
        SapoDormir.dormir1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir3();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        som.dormir();
        SapoDormir.dormir4();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir5();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir6();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        som.dormir();
        SapoDormir.dormir7();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir8();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir9();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
    }

    public void limpando() {
        this.limpaTela();
        som.limpar();
        SapoCoco.coco1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoCoco.coco2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);

        SapoLimpar.limpeza1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoLimpar.limpeza2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoLimpar.limpeza3();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoLimpar.limpeza4();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
    }

    public void morto() {
        this.limpaTela();
        som.morrer();
        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
        AnimacaoMorrer.morrer2();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
        som.morrer();
        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
        AnimacaoMorrer.morrer2();
        System.out.println("x-----------------------------------------------------------------x");
        System.out.printf( "                         SEU %s MORREU                           \n" +
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
        System.out.println("x  1) Alimentar    2) Brincar   3)Banheiro     4)Dormir  0) Sair  x");
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

    public void cicloDeAnimacao(int tempo, int numeroDeFrames){
        this.mostrarStatus();
        this.esperar(tempo/numeroDeFrames);
        this.limpaTela();
    }
}
