package tamagotchi.animacao.mametchi;

import tamagotchi.animacao.Animacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import java.io.Serializable;

public class AnimacaoCachorro implements Animacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;

    // Construtor
    public AnimacaoCachorro(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        this.limpaTela();
        Padrao.padrao1();
        cicloDeAnimacao(Animacao.TEMPO_PARADO, 2);

        Padrao.padrao2();
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

        Comer.atoComer1();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);

        Comer.atoComer2();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);

        Comer.atoComer3();
       cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);

        Comer.atoComer4();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);

        Comer.atoComer5();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        
        Comer.atoComer6();
        cicloDeAnimacao(Animacao.TEMPO_COMENDO, 12);
        
    }

    public void brincando() {
        this.limpaTela();
        Padrao.padrao1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);
        
        this.limpaTela();
        Padrao.padrao2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);

        Desconfiado.brabo1();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);

        Desconfiado.brabo2();
        cicloDeAnimacao(Animacao.TEMPO_BRINCANDO, 4);
    }

    public void dormindo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_DORMINDO / numeroDeFrames;

        this.limpaTela();
        Dormir.dormir1();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir2();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir3();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir4();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir5();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir6();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir7();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir8();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);
        Dormir.dormir9();
        cicloDeAnimacao(Animacao.TEMPO_DORMINDO, 9);

    }

    public void limpando() {

        this.limpaTela();
        Coco.coco1();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Coco.coco2();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Coco.coco1();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Coco.coco2();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);

        Limpeza.limpar1();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Limpeza.limpar2();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Limpeza.limpar3();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);
        Limpeza.limpar4();
        cicloDeAnimacao(Animacao.TEMPO_LIMPANDO, 8);

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
