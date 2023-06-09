package tools;

public class CriarJar {
    public static void main(String[] args) {
        try {
            String caminho = FolderFinder.findAbsolutePath(System.getProperty("user.dir"), "tamagotchi");
            caminho = "cmd.exe /c cd " + caminho.substring(0, caminho.length() - 11);
            
            // Comando 1: cd "local do projeto"
            Runtime.getRuntime().exec(caminho).waitFor();

            // Comando 2: dir /b /s *.java > tmp.txt
            Runtime.getRuntime().exec("cmd.exe /c dir /b /s *.java > tmp.txt").waitFor();

            // Comando 3: javac @tmp.txt
            Runtime.getRuntime().exec("cmd.exe /c javac @tmp.txt").waitFor();

            // Comando 4: del tmp.txt
            Runtime.getRuntime().exec("cmd.exe /c del tmp.txt").waitFor();

            // Comando 5: mkdir bin
            Runtime.getRuntime().exec("cmd.exe /c mkdir bin").waitFor();

            // Comando 6: jar cfvm bin/Tamagotchi.jar Manifest.txt -C . .
            Runtime.getRuntime().exec("cmd.exe /c jar -cfm bin/Tamagotchi.jar recursos/Manifest.txt @recursos/LocaisDasClasses.txt @recursos/LocaisDosSons.txt").waitFor();

            // Comando 7: del /s *.class
            Runtime.getRuntime().exec("cmd.exe /c del /s *.class").waitFor();

            System.out.println("Executável criado com sucesso.");
        } catch (Exception e) {
        }
    }
}