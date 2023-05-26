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
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        AtoPadrao.padrao2();
        this.mostrarStatus();
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
        this.esperar(tempoDoFrame);
    }

    public void comendo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;

        this.limpaTela();
        AnimacaoMaca.maca1();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AnimacaoMaca.maca2();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AnimacaoMaca.maca3();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AnimacaoMaca.maca4();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AnimacaoMaca.maca5();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AnimacaoMaca.maca6();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AtoComer1.atoComer1();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AtoComer1.atoComer2();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AtoComer1.atoComer3();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AtoComer1.atoComer4();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        AtoComer1.atoComer5();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        AtoComer1.atoComer6();
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        
    }

    public void brincando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_BRINCANDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO BRINCANDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do CACHORRO BRINCANDO - Frame 2");
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
        System.out.printf("Tchau bichinho %s :c\n", this.tamagotchi.getNome());
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
}
