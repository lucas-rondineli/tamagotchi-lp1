package tamagotchi.animacao;

public interface Animacao {
    public final int NUMERO_DE_FRAMES = 2;

    public void parado();

    public void comendo();

    public void brincando();

    public void dormindo();

    public void limpando();

    public void morto();

    public void mostrarStatus();

    public void limpaTela();

    public void esperar();
}

// Ações Atuais: 1) Alimentar 2) Brincar 3) Banheiro 4) Dormir 0) Finalizar
// Tipos Atuais: 1) Cachorro 2) Gato

// Onde mudar:
// controle.Entrada
// criatura.TamagotchiCachorro.java
// criatura.TamagotchiGato.java
