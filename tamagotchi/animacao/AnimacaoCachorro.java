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
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        AtoPadrao.padrao2();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void comendo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;

        AnimacaoMaca.maca1();
        cicloDeAnimação();

        AnimacaoMaca.maca2();
        cicloDeAnimação();

        AnimacaoMaca.maca3();
        cicloDeAnimação();

        AnimacaoMaca.maca4();
        cicloDeAnimação();

        AnimacaoMaca.maca5();
        cicloDeAnimação();

        AnimacaoMaca.maca6();
        cicloDeAnimação();

        AtoComer1.atoComer1();
        cicloDeAnimação();

        AtoComer1.atoComer2();
        cicloDeAnimação();

        AtoComer1.atoComer3();
       cicloDeAnimação();

        AtoComer1.atoComer4();
        cicloDeAnimação();

        AtoComer1.atoComer5();
        cicloDeAnimação();
        
        AtoComer1.atoComer6();
        cicloDeAnimação();
        
    }

    public void brincando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_BRINCANDO / numeroDeFrames;

        AtoPadrao.padrao1();
        cicloDeAnimação();
        
        this.limpaTela();
        AtoPadrao.padrao2();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        Desconfiado.brabo1();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        Desconfiado.brabo2();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void dormindo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_DORMINDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO DORMINDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO DORMINDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void limpando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_LIMPANDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO LIMPANDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO LIMPANDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
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

    public void cicloDeAnimação(){
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        this.limpaTela();
    }
}
