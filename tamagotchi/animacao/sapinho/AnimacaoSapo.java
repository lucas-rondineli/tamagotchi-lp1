package tamagotchi.animacao.sapinho;

import tamagotchi.animacao.IAnimacao;
import tamagotchi.animacao.AnimacaoMaca;
import tamagotchi.animacao.AnimacaoMorrer;
import tamagotchi.criatura.TamagotchiBase;
import tamagotchi.som.Som;
import java.io.Serializable;

public class AnimacaoSapo implements IAnimacao, Serializable {
    // Atributos
    private TamagotchiBase tamagotchi;
    transient private Som som = new Som();
    private int framesParado = 2;
    private int framesComendo = 9;
    private int framesBrincando = 5;
    private int framesDormindo = 9;
    private int framesLimpando = 6;
    private int framesMorto = 4;
    private int tempoDoFrameParado = IAnimacao.TEMPO_PARADO/framesParado;
    private int tempoDoFrameComendo = IAnimacao.TEMPO_COMENDO/framesComendo;
    private int tempoDoFrameBrincando = IAnimacao.TEMPO_BRINCANDO / framesBrincando;
    private int tempoDoFrameDormindo = IAnimacao.TEMPO_DORMINDO / framesDormindo;
    private int tempoDoFrameLimpando = IAnimacao.TEMPO_LIMPANDO / framesLimpando;
    private int tempoDoFrameMorto = IAnimacao.TEMPO_MORTO/ framesMorto;



    // Construtor
    public AnimacaoSapo(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    // Métodos
    public void parado() {

        if (this.tamagotchi.getPerigo())
            this.som.alerta();
        this.limpaTela();
        SapoPadrao.padrao1();
        cicloDeAnimacao(this.tempoDoFrameParado);

        SapoPadrao.padrao2();
        cicloDeAnimacao(this.tempoDoFrameParado);
    }

    public void comendo() {

        this.limpaTela();
        AnimacaoMaca.maca1();
        cicloDeAnimacao(this.tempoDoFrameComendo);

        AnimacaoMaca.maca3();
        cicloDeAnimacao(this.tempoDoFrameComendo);

        AnimacaoMaca.maca5();
        cicloDeAnimacao(this.tempoDoFrameComendo);

        SapoComer.comer1();
        cicloDeAnimacao(this.tempoDoFrameComendo);
        som.comer();

        SapoComer.comer2();
        cicloDeAnimacao(this.tempoDoFrameComendo);

        SapoComer.comer3();
        cicloDeAnimacao(this.tempoDoFrameComendo);
        som.comer();

        SapoComer.comer5();
        cicloDeAnimacao(this.tempoDoFrameComendo);
        som.comer();

        SapoComer.comer6();
        cicloDeAnimacao(this.tempoDoFrameComendo);

        SapoComer.comer7();
        cicloDeAnimacao(this.tempoDoFrameComendo);
    }

    public void brincando() {

        this.limpaTela();
        SapoBrincar.brincar1();
        cicloDeAnimacao(this.tempoDoFrameBrincando);
        som.brincar();

        SapoBrincar.brincar2();
        cicloDeAnimacao(this.tempoDoFrameBrincando);

        SapoBrincar.brincar3();
        cicloDeAnimacao(this.tempoDoFrameBrincando);
        som.brincar();

        SapoBrincar.brincar4();
        cicloDeAnimacao(this.tempoDoFrameBrincando);

        SapoBrincar.brincar5();
        cicloDeAnimacao(this.tempoDoFrameBrincando);
    }

    public void dormindo() {

        this.limpaTela();
        SapoDormir.dormir1();
        cicloDeAnimacao(this.tempoDoFrameDormindo);
        som.dormir();

        SapoDormir.dormir2();
        cicloDeAnimacao(this.tempoDoFrameDormindo);

        SapoDormir.dormir3();
        cicloDeAnimacao(this.tempoDoFrameDormindo);
        som.dormir();

        SapoDormir.dormir4();
        cicloDeAnimacao(this.tempoDoFrameDormindo);

        SapoDormir.dormir5();
        cicloDeAnimacao(this.tempoDoFrameDormindo);

        SapoDormir.dormir6();
        cicloDeAnimacao(this.tempoDoFrameDormindo);
        som.dormir();

        SapoDormir.dormir7();
        cicloDeAnimacao(this.tempoDoFrameDormindo);

        SapoDormir.dormir8();
        cicloDeAnimacao(this.tempoDoFrameDormindo);

        SapoDormir.dormir9();
        cicloDeAnimacao(this.tempoDoFrameDormindo);
    }

    public void limpando() {
        this.limpaTela();
        SapoCoco.coco1();
        cicloDeAnimacao(this.tempoDoFrameLimpando);
        som.limpar();

        SapoCoco.coco2();
        cicloDeAnimacao(this.tempoDoFrameLimpando);

        SapoLimpar.limpeza1();
        cicloDeAnimacao(this.tempoDoFrameLimpando);

        SapoLimpar.limpeza2();
        cicloDeAnimacao(this.tempoDoFrameLimpando);

        SapoLimpar.limpeza3();
        cicloDeAnimacao(this.tempoDoFrameLimpando);

        SapoLimpar.limpeza4();
        cicloDeAnimacao(this.tempoDoFrameLimpando);
    }

    public void morto() {

        this.limpaTela();
        AnimacaoMorrer.morrer1();
        this.esperar(tempoDoFrameMorto);
        this.limpaTela();
        som.morrer();

        AnimacaoMorrer.morrer2();
        this.esperar(tempoDoFrameMorto);
        this.limpaTela();

        AnimacaoMorrer.morrer1();
        this.esperar(tempoDoFrameMorto);
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
