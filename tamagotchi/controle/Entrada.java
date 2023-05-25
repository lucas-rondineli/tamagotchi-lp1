package tamagotchi.controle;

import tamagotchi.criatura.*;
import tools.Validator;

public class Entrada {
    public static void main(String[] args) {
        Validator vd = new Validator(System.in);
        TamagotchiBase tamagotchi;

        String nome = vd.validateString("Por favor, entre com o nome do seu Tamagotchi: ",
                "Erro. Um nome vazio não é válido.\n\n",
                (n) -> {
                    return n.length() > 0;
                });
        int opt = vd.validateInt("\nEscolha um tipo de Tamagotchi.\n1 - Cachorro\n2 - Gato\n",
                "Erro. Digite um número entre 1 e 2.\n\n",
                (n) -> {
                    return n == 1 || n == 2;
                });

        if (opt == 1)
            tamagotchi = new TamagotchiCachorro(nome);
        else
            tamagotchi = new TamagotchiGato(nome);

        tamagotchi.iniciar();
        while (true) {
            opt = vd.validateInt("", "",
                    (n) -> {
                        return 0 <= n && n <= 4;
                    });

            if (!tamagotchi.getEstaVivo())
                break;
            if (opt == 0) {
                tamagotchi.matar();
                break;
            }
            switch (opt) {
                case 1:
                    tamagotchi.alimentar();
                    break;
                case 2:
                    tamagotchi.brincar();
                    break;
                case 3:
                    tamagotchi.dormir();
                    break;
                case 4:
                    tamagotchi.limpar();
            }
        }
        tamagotchi.getAnimacao().morto();
    }
}
