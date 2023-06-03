package tamagotchi.animacao.mametchi;

import tamagotchi.animacao.Animacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import tamagotchi.som.Som;

import java.io.Serializable;

public class AnimacaoUrso implements Animacao, Serializable {
    Som som = new Som();
    // Atributos
    private TamagotchiBase tamagotchi;

    // Construtor
    public AnimacaoUrso(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        this.limpaTela();
        UrsoPadrao.padrao1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);

        UrsoPadrao.padrao2();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
    }

    public void comendo() {
        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        AnimacaoMaca.maca3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        AnimacaoMaca.maca5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        UrsoComer.atoComer1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        som.comer();
        UrsoComer.atoComer2();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        UrsoComer.atoComer3();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        som.comer();
        UrsoComer.atoComer4();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        UrsoComer.atoComer5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);

        som.comer();
        UrsoComer.atoComer6();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 9);
    }

    public void brincando() {
        this.limpaTela();
        UrsoBrincar.brabo1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);

        som.brincar();
        UrsoBrincar.brabo2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);

        UrsoBrincar.brabo1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);

        som.brincar();
        UrsoBrincar.brabo2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);
    }

    public void dormindo() {

        this.limpaTela();
        som.dormir();

        UrsoDormir.dormir1();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir2();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir3();
        som.dormir();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir4();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir5();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir6();
        som.dormir();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir7();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir8();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        UrsoDormir.dormir9();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);

    }

    public void limpando() {

        this.limpaTela();
        som.limpar();
        UrsoCoco.coco1();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        UrsoCoco.coco2();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);

        UrsoLimpeza.limpar1();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        UrsoLimpeza.limpar2();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        UrsoLimpeza.limpar3();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        UrsoLimpeza.limpar4();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);

    }

    public void morto() {
        this.limpaTela();
        som.morrer();
        AnimacaoMorrer.morrer1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);
        AnimacaoMorrer.morrer2();
        som.morrer();
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
