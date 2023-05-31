package tamagotchi.som;

import tools.FolderFinder;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
    private Clip botao;
    private Clip comer;
    private Clip brincar;
    private Clip limpar;
    private Clip dormir;
    private Clip morrer;

    public Som() {
        String caminhoSonsDb = FolderFinder.findAbsolutePath(System.getProperty("user.dir"), "tamagotchi") + "\\som\\sonsDB\\";

        try {
            this.botao = AudioSystem.getClip();
            this.comer = AudioSystem.getClip();
            this.brincar = AudioSystem.getClip();
            this.limpar = AudioSystem.getClip();
            this.dormir = AudioSystem.getClip();
            this.morrer = AudioSystem.getClip();
        } catch (Exception e) {
        }

        AudioInputStream tmp;
        try {
            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "01.wav"));
            this.botao.open(tmp);
            tmp.close();

            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "09.wav"));
            this.comer.open(tmp);
            tmp.close();

            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "08.wav"));
            this.brincar.open(tmp);
            tmp.close();

            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "19.wav"));
            this.limpar.open(tmp);
            tmp.close();

            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "04.wav"));
            this.dormir.open(tmp);
            tmp.close();

            tmp = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "03.wav"));
            this.morrer.open(tmp);
            tmp.close();
        } catch (Exception e) {
        }
    }

    public void botao() {
        this.botao.setMicrosecondPosition(0);
        this.botao.start();
    }

    public void comer() {
        this.comer.setMicrosecondPosition(0);
        this.comer.start();
    }

    public void brincar() {
        this.brincar.setMicrosecondPosition(0);
        this.brincar.start();
    }

    public void limpar() {
        this.limpar.setMicrosecondPosition(0);
        this.limpar.start();
    }

    public void dormir() {
        this.dormir.setMicrosecondPosition(0);
        this.dormir.start();
    }

    public void morrer() {
        this.morrer.setMicrosecondPosition(0);
        this.morrer.start();
    }
}
