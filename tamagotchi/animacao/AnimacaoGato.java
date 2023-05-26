package tamagotchi.animacao;

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
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_PARADO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do GATO PARADO - Frame 1");
        this.mostrarStatus();
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        System.out.println("ASCII Art do GATO PARADO - Frame 2");
        this.mostrarStatus();
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
        this.esperar(tempoDoFrame);
    }

    public void comendo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_COMENDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do GATO COMENDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
        
        this.limpaTela();
        System.out.println("ASCII Art do GATO COMENDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void brincando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_BRINCANDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do GATO BRINCANDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do GATO BRINCANDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void dormindo() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_DORMINDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do GATO DORMINDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do GATO DORMINDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void limpando() {
        int numeroDeFrames = 2;
        int tempoDoFrame = Animacao.TEMPO_LIMPANDO / numeroDeFrames;

        this.limpaTela();
        System.out.println("ASCII Art do GATO LIMPANDO - Frame 1");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);

        this.limpaTela();
        System.out.println("ASCII Art do GATO LIMPANDO - Frame 2");
        this.mostrarStatus();
        this.esperar(tempoDoFrame);
    }

    public void morto() {
        this.limpaTela();
        GameOver.gameover();
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
