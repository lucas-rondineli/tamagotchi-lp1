package tamagotchi.som;

import java.io.InputStream;
import java.io.BufferedInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
    private Clip alerta;
    private Clip comer;
    private Clip brincar;
    private Clip limpar;
    private Clip dormir;
    private Clip morrer;

    public Som() {
        try {
            this.alerta = AudioSystem.getClip();
            this.comer = AudioSystem.getClip();
            this.brincar = AudioSystem.getClip();
            this.limpar = AudioSystem.getClip();
            this.dormir = AudioSystem.getClip();
            this.morrer = AudioSystem.getClip();
        } catch (Exception e) {
        }

        Clip[] clips = {this.alerta, this.comer, this.brincar, this.limpar, this.dormir, this.morrer};
        String[] arquivosDeAudio = {"/tamagotchi/som/sonsDB/17.wav",
                "/tamagotchi/som/sonsDB/09.wav", 
                "/tamagotchi/som/sonsDB/08.wav", 
                "/tamagotchi/som/sonsDB/19.wav", 
                "/tamagotchi/som/sonsDB/04.wav", 
                "/tamagotchi/som/sonsDB/03.wav"};
        for (int i = 0; i < 6; i++)
            try (InputStream is = Som.class.getResourceAsStream(arquivosDeAudio[i]);
            BufferedInputStream bis = new BufferedInputStream(is);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bis)) {
                clips[i].open(ais);
            } catch (Exception e) {
            }
    }

    public void alerta() {
        this.alerta.setMicrosecondPosition(0);
        this.alerta.start();
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
