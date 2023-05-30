package tamagotchi.som;

import tools.FolderFinder;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
    private Clip clp;
    private AudioInputStream botao;
    private AudioInputStream comer;
    private AudioInputStream brincar;
    private AudioInputStream limpar;
    private AudioInputStream dormir;
    private AudioInputStream morrer;

    public Som() {
        String caminhoSonsDb = FolderFinder.findAbsolutePath(System.getProperty("user.dir"), "sonsDB") + '\\';

        try {
            this.clp = AudioSystem.getClip();
        } catch (Exception e) {
        }

        try {
            this.botao = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "01.wav"));
            this.comer = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "09.wav"));
            this.brincar = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "08.wav"));
            this.limpar = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "19.wav"));
            this.dormir = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "04.wav"));
            this.morrer = AudioSystem.getAudioInputStream(new File(caminhoSonsDb + "03.wav"));
        } catch (Exception e) {
        }
    }

    public void botao() {
        try {
            this.clp.close();
            this.clp.open(this.botao);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }

    public void comer() {
        try {
            this.clp.close();
            this.clp.open(this.comer);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }

    public void brincar() {
        try {
            this.clp.close();
            this.clp.open(this.brincar);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }

    public void limpar() {
        try {
            this.clp.close();
            this.clp.open(this.limpar);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }

    public void dormir() {
        try {
            this.clp.close();
            this.clp.open(this.dormir);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }

    public void morrer() {
        try {
            this.clp.close();
            this.clp.open(this.morrer);
        } catch (Exception e) {
        }
        this.clp.setMicrosecondPosition(0);
        this.clp.start();
    }
}
