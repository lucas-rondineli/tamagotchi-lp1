package tamagotchi.criatura;

import java.lang.Runnable;

class AnimacaoRunnable implements Runnable {
    private TamagotchiBase tamagotchi;

    public AnimacaoRunnable(TamagotchiBase tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public void run() {
        while (this.tamagotchi.getEstaVivo()) {
            int estadoAtual = this.tamagotchi.getEstadoAtual();
            if (estadoAtual == this.tamagotchi.PARADO)
                this.tamagotchi.getAnimacao().parado();
            else if (estadoAtual == this.tamagotchi.COMENDO)
                this.tamagotchi.getAnimacao().comendo();
            else if (estadoAtual == this.tamagotchi.BRINCANDO)
                this.tamagotchi.getAnimacao().brincando();
            else if (estadoAtual == this.tamagotchi.DORMINDO)
                this.tamagotchi.getAnimacao().dormindo();
            else if (estadoAtual == this.tamagotchi.LIMPANDO)
                this.tamagotchi.getAnimacao().limpando();

            try {
                Thread.sleep(this.tamagotchi.RELOGIO_DA_ANIMACAO / this.tamagotchi.getAnimacao().NUMERO_DE_FRAMES);
            } catch (InterruptedException e) {
            }
        }
    }
}
