package tamagotchi.animacao;

import tamagotchi.criatura.TamagotchiBase;

public class AnimacaoGato implements Animacao {
    // Atributos
    private TamagotchiBase tamagotchi;

    // Construtor
    public AnimacaoGato(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        this.limpaTela();
        System.out.println("ASCII Art do GATO PARADO - Frame 1");
        this.mostrarStatus();
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
        this.esperar();

        this.limpaTela();
        System.out.println("ASCII Art do GATO PARADO - Frame 2");
        this.mostrarStatus();
        System.out.printf("1) Alimentar    2) Brincar    3) Banheiro    4) Dormir    0) Finalizar");
    }

    public void comendo() {
        this.limpaTela();
        System.out.println("ASCII Art do GATO COMENDO - Frame 1");
        this.mostrarStatus();
        this.esperar();

        this.limpaTela();
        System.out.println("ASCII Art do GATO COMENDO - Frame 2");
        this.mostrarStatus();
    }

    public void brincando() {
        this.limpaTela();
        System.out.println("ASCII Art do GATO BRINCANDO - Frame 1");
        this.mostrarStatus();
        this.esperar();

        this.limpaTela();
        System.out.println("ASCII Art do GATO BRINCANDO - Frame 2");
        this.mostrarStatus();
    }

    public void dormindo() {
        this.limpaTela();
        this.limpaTela();
        System.out.println("ASCII Art do GATO DORMINDO - Frame 1");
        this.mostrarStatus();
        this.esperar();

        this.limpaTela();
        System.out.println("ASCII Art do GATO DORMINDO - Frame 2");
        this.mostrarStatus();
    }

    public void limpando() {
        this.limpaTela();
        System.out.println("ASCII Art do GATO LIMPANDO - Frame 1");
        this.mostrarStatus();
        this.esperar();

        this.limpaTela();
        System.out.println("ASCII Art do GATO LIMPANDO - Frame 2");
        this.mostrarStatus();
    }

    public void morto() {
        this.limpaTela();
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

    public void esperar() {
        try {
            Thread.sleep(this.tamagotchi.RELOGIO_DA_ANIMACAO / Animacao.NUMERO_DE_FRAMES);
        } catch (Exception e) {
        }
    }
}
