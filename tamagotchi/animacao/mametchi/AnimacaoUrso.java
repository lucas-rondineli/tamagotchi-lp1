package tamagotchi.animacao.mametchi;

import tamagotchi.animacao.IAnimacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import tamagotchi.som.Som;
import java.io.Serializable;

public class AnimacaoUrso implements IAnimacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;
    transient private Som som = new Som();

    // Construtor
    public AnimacaoUrso(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {
        int tempoDoFrame = IAnimacao.TEMPO_PARADO / 2;

        if (this.tamagotchi.getPerigo())
            this.som.alerta();
        this.limpaTela();
        UrsoPadrao.padrao1();
        cicloDeAnimacao(tempoDoFrame);

        UrsoPadrao.padrao2();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void comendo() {
        int tempoDoFrame = IAnimacao.TEMPO_COMENDO / 9;

        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao(tempoDoFrame);

        AnimacaoMaca.maca3();
        cicloDeAnimacao(tempoDoFrame);

        AnimacaoMaca.maca5();
        cicloDeAnimacao(tempoDoFrame);

        UrsoComer.atoComer1();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        UrsoComer.atoComer2();
        cicloDeAnimacao(tempoDoFrame);

        UrsoComer.atoComer3();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        UrsoComer.atoComer4();
        cicloDeAnimacao(tempoDoFrame);

        UrsoComer.atoComer5();
        cicloDeAnimacao(tempoDoFrame);
        som.comer();

        UrsoComer.atoComer6();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void brincando() {
        int tempoDoFrame = IAnimacao.TEMPO_BRINCANDO / 4;

        this.limpaTela();
        UrsoBrincar.brabo1();
        cicloDeAnimacao(tempoDoFrame);
        som.brincar();

        UrsoBrincar.brabo2();
        cicloDeAnimacao(tempoDoFrame);

        UrsoBrincar.brabo1();
        cicloDeAnimacao(tempoDoFrame);
        som.brincar();

        UrsoBrincar.brabo2();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void dormindo() {
        int tempoDoFrame = IAnimacao.TEMPO_DORMINDO / 9;

        this.limpaTela();
        UrsoDormir.dormir1();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        UrsoDormir.dormir2();
        cicloDeAnimacao(tempoDoFrame);

        UrsoDormir.dormir3();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        UrsoDormir.dormir4();
        cicloDeAnimacao(tempoDoFrame);

        UrsoDormir.dormir5();
        cicloDeAnimacao(tempoDoFrame);

        UrsoDormir.dormir6();
        cicloDeAnimacao(tempoDoFrame);
        som.dormir();

        UrsoDormir.dormir7();
        cicloDeAnimacao(tempoDoFrame);

        UrsoDormir.dormir8();
        cicloDeAnimacao(tempoDoFrame);

        UrsoDormir.dormir9();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void limpando() {
        int tempoDoFrame = IAnimacao.TEMPO_LIMPANDO / 6;

        this.limpaTela();
        UrsoCoco.coco1();
        cicloDeAnimacao(tempoDoFrame);
        som.limpar();

        UrsoCoco.coco2();
        cicloDeAnimacao(tempoDoFrame);

        UrsoLimpeza.limpar1();
        cicloDeAnimacao(tempoDoFrame);

        UrsoLimpeza.limpar2();
        cicloDeAnimacao(tempoDoFrame);

        UrsoLimpeza.limpar3();
        cicloDeAnimacao(tempoDoFrame);

        UrsoLimpeza.limpar4();
        cicloDeAnimacao(tempoDoFrame);
    }

    public void morto() {
        int tempoDoFrame = 500;

        this.limpaTela();
        AnimacaoMorrer.morrer1();
        this.esperar(tempoDoFrame);
        this.limpaTela();
        som.morrer();

        AnimacaoMorrer.morrer2();
        this.esperar(tempoDoFrame);
        this.limpaTela();

        AnimacaoMorrer.morrer1();
        this.esperar(tempoDoFrame);
        this.limpaTela();

        AnimacaoMorrer.morrer2();
        System.out.println("x-----------------------------------------------------------------x");
        System.out.printf("x                        SEU %s MORREU                          x\n" +
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
