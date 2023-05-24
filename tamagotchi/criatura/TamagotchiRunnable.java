package tamagotchi.criatura;

import java.lang.Runnable;

public class TamagotchiRunnable implements Runnable {
    private TamagotchiBase tamagotchi;

    public TamagotchiRunnable(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public void run() {
        while (this.tamagotchi.getEstaVivo()) {
            this.tamagotchi.cicloPrincipal();

            try {
                Thread.sleep(this.tamagotchi.CLOCK_TIME);
            } catch (InterruptedException err) {
                this.tamagotchi.matar();
            }
        }

    }
}
