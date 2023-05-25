package tamagotchi.controle;

import tamagotchi.criatura.*;
import tools.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Entrada {
    public static void main(String[] args) {
        Validator vd = new Validator(System.in);
        TamagotchiBase tamagotchi;
        int opt;
        String caminho = System.getProperty("user.dir") + "\\tamagotchi\\dados\\Tamagotchi.data";

        // Criando um Tamagotchi novo ou recuperando-o da memória
        new File(System.getProperty("user.dir") + "\\tamagotchi\\dados").mkdir();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho));
            tamagotchi = (TamagotchiBase) ois.readObject();
            tamagotchi.reiniciar();
            ois.close();
        } catch (Exception e) {
            String nome = vd.validateString("Por favor, entre com o nome do seu Tamagotchi: ",
                    "Erro. Um nome vazio não é válido.\n\n",
                    (n) -> {
                        return n.length() > 0;
                    });
            opt = vd.validateInt("\nEscolha um tipo de Tamagotchi.\n1 - Cachorro\n2 - Gato\n",
                    "Erro. Digite um número entre 1 e 2.\n\n",
                    (n) -> {
                        return n == 1 || n == 2;
                    });

            if (opt == 1)
                tamagotchi = new TamagotchiCachorro(nome);
            else
                tamagotchi = new TamagotchiGato(nome);
        }

        // Iniciando o Tamagotchi e recebendo as entradas do usuário
        tamagotchi.iniciar();
        while (true) {
            opt = vd.validateInt("", "",
                    (n) -> {
                        return 0 <= n && n <= 4;
                    });

            if (!tamagotchi.getEstaVivo()) {
                tamagotchi.getAnimacao().morto();
                new File(caminho).delete();
                break;
            }

            if (opt == 0) {
                tamagotchi.matar();
                try {
                    Thread.sleep(tamagotchi.RELOGIO_DA_ANIMACAO + tamagotchi.RELOGIO_DOS_STATUS);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho));
                    oos.writeObject(tamagotchi);
                    oos.close();
                    System.out.printf("\nTamagotchi Salvo com Sucesso.");
                } catch (Exception e) {
                }
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
    }
}
