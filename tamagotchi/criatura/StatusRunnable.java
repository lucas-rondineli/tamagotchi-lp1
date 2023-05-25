package tamagotchi.criatura;

import java.lang.Runnable;

class StatusRunnable implements Runnable {
    private TamagotchiBase tamagotchi;

    public StatusRunnable(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public void run() {
        while (this.tamagotchi.getEstaVivo()) {
            if (this.tamagotchi.getFome() >= this.tamagotchi.FOME_MAXIMA
                    || this.tamagotchi.getEnergia() <= this.tamagotchi.ENERGIA_MINIMA
                    || this.tamagotchi.getLimpeza() <= this.tamagotchi.LIMPEZA_MINIMA)
                this.tamagotchi.matar();
            else {
                this.tamagotchi.cicloDosStatus();

                try {
                    Thread.sleep(this.tamagotchi.RELOGIO_DOS_STATUS);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
