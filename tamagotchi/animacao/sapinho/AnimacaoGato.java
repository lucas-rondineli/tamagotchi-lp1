package tamagotchi.animacao.sapinho;

import tamagotchi.animacao.Animacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import java.io.Serializable;

public class AnimacaoGato implements Animacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;

    // Construtor
    public AnimacaoGato(TamagotchiBase tamagotchi) {
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
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        AnimacaoMaca.maca2();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        AnimacaoMaca.maca3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        AnimacaoMaca.maca4();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        AnimacaoMaca.maca5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        AnimacaoMaca.maca6();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer2();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer4();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer6();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        SapoComer.comer7();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);

    }

    public void brincando() {
        this.limpaTela();
        SapoBrincar.brincar1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar3();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar4();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
        SapoBrincar.brincar5();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 5);
    }

    public void dormindo() {
        this.limpaTela();
        SapoDormir.dormir1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir3();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir4();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir5();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir6();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir7();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir8();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
        SapoDormir.dormir9();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 9);
    }

    public void limpando() {
        this.limpaTela();
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
        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
        AnimacaoMorrer.morrer2();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
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
