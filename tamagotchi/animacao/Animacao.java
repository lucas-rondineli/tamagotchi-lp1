package tamagotchi.animacao;

public interface Animacao {
    // Constantes
    public int TEMPO_PARADO = 1000;
    public int TEMPO_COMENDO = 4500;
    public int TEMPO_BRINCANDO = 2000;
    public int TEMPO_DORMINDO = 4500;
    public int TEMPO_LIMPANDO = 4000;

    // Métodos
    public void parado();

    public void comendo();

    public void brincando();

    public void dormindo();

    public void limpando();

    public void morto();

    public void mostrarStatus();

    public void limpaTela();

    public void esperar(int tempo);
}
