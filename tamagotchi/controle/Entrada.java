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
        String caminhoDosDados = System.getProperty("user.dir") + "\\dados";
        int opt;

        // Criando um Tamagotchi novo ou recuperando-o da memória
        new File(caminhoDosDados).mkdir();
        caminhoDosDados += "\\Tamagotchi.data";
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoDosDados));
            tamagotchi = (TamagotchiBase) ois.readObject();
            tamagotchi.reiniciar();
            ois.close();
        } catch (Exception e) {
            String nome = vd.validateString("Por favor, entre com o nome do seu Tamagotchi: ",
                    "Erro. Um nome vazio, ou com mais de 10 caracteres, não é válido.\n\n",
                    (n) -> {
                        return 0 < n.length() && n.length() <= 10;
                    });
            opt = vd.validateInt("\nEscolha um tipo de Tamagotchi.\n1 - Ursinho\n2 - Sapinho\n",
                    "Erro. Digite um número entre 1 e 2.\n\n",
                    (n) -> {
                        return n == 1 || n == 2;
                    });

            if (opt == 1)
                tamagotchi = new TamagotchiUrso(nome);
            else
                tamagotchi = new TamagotchiSapo(nome);
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
                new File(caminhoDosDados).delete();
                break;
            }

            if (opt == 0) {
                tamagotchi.matar();
                try {
                    Thread.sleep(tamagotchi.RELOGIO_DOS_STATUS);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoDosDados));
                    oos.writeObject(tamagotchi);
                    oos.close();

                    tamagotchi.getControladorDaAnimacao().join();
                    System.out.printf("Tamagotchi Salvo com Sucesso.");
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
                    tamagotchi.limpar();
                    break;
                case 4:
                    tamagotchi.dormir();
            }
        }
        vd.close();
    }
}
