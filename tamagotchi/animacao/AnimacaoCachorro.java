package tamagotchi.animacao;

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
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_PARADO / numeroDeFrames;

        this.limpaTela();
        AtoPadrao.padrao1();
        cicloDeAnimacao();

        AtoPadrao.padrao2();
        cicloDeAnimacao();
    }

    public void comendo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;

        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao();

        AnimacaoMaca.maca2();
        cicloDeAnimacao();

        AnimacaoMaca.maca3();
        cicloDeAnimacao();

        AnimacaoMaca.maca4();
        cicloDeAnimacao();

        AnimacaoMaca.maca5();
        cicloDeAnimacao();

        AnimacaoMaca.maca6();
        cicloDeAnimacao();

        AtoComer1.atoComer1();
        cicloDeAnimacao();

        AtoComer1.atoComer2();
        cicloDeAnimacao();

        AtoComer1.atoComer3();
       cicloDeAnimacao();

        AtoComer1.atoComer4();
        cicloDeAnimacao();

        AtoComer1.atoComer5();
        cicloDeAnimacao();
        
        AtoComer1.atoComer6();
        cicloDeAnimacao();
        
    }

    public void brincando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_BRINCANDO / numeroDeFrames;

        this.limpaTela();
        AtoPadrao.padrao1();
        cicloDeAnimacao();
        
        this.limpaTela();
        AtoPadrao.padrao2();
        cicloDeAnimacao();

        Desconfiado.brabo1();
        cicloDeAnimacao();
        Desconfiado.brabo2();
        cicloDeAnimacao();
    }

    public void dormindo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_DORMINDO / numeroDeFrames;

        this.limpaTela();
        Dormir.dormir1();
        cicloDeAnimacao();
        Dormir.dormir2();
        cicloDeAnimacao();
        Dormir.dormir3();
        cicloDeAnimacao();
        Dormir.dormir4();
        cicloDeAnimacao();
        Dormir.dormir5();
        cicloDeAnimacao();
        Dormir.dormir6();
        cicloDeAnimacao();
        Dormir.dormir7();
        cicloDeAnimacao();
        Dormir.dormir8();
        cicloDeAnimacao();
        Dormir.dormir9();
        cicloDeAnimacao();

    }

    public void limpando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_LIMPANDO / numeroDeFrames;

        this.limpaTela();
        Coco.coco1();
        cicloDeAnimacao();
        Coco.coco2();
        cicloDeAnimacao();
        Coco.coco1();
        cicloDeAnimacao();
        Coco.coco2();
        cicloDeAnimacao();

        Limpeza.limpar1();
        cicloDeAnimacao();
        Limpeza.limpar2();
        cicloDeAnimacao();
        Limpeza.limpar3();
        cicloDeAnimacao();
        Limpeza.limpar4();
        cicloDeAnimacao();

    }

    public void morto() {
        this.limpaTela();
        GameOver.gameover();
        System.out.printf("┼┼┼┼┼┼┼ SEU %s MORREU ┼┼┼┼┼┼%n", this.tamagotchi.getNome());
        System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
    }

    public void mostrarStatus() {

        System.out.printf("\nNome: %s\n", this.tamagotchi.getNome());
        System.out.printf("Fome: %d / %d\n", this.tamagotchi.getFome(), this.tamagotchi.FOME_MAXIMA);
        System.out.printf("Energia: %d / %d\n", this.tamagotchi.getEnergia(), this.tamagotchi.ENERGIA_MAXIMA);
        System.out.printf("Limpeza: %d / %d\n", this.tamagotchi.getLimpeza(), this.tamagotchi.LIMPEZA_MAXIMA);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
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

    public void cicloDeAnimacao(){
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        this.limpaTela();
    }
}
